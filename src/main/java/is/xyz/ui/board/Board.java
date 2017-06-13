package is.xyz.ui.board;

import is.xyz.network.NetworkManager;
import is.xyz.network.WinMessage;
import is.xyz.ui.figures.*;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Board extends GridPane {
    public static final int SIZE = 8;
    private final Tile[][] tiles;
    private Tile movingTile = null;
    private final Cemetery cemetery;
    private King myKing;
    private final NetworkManager manager;
    private List<Tile> moves = new ArrayList<>();

    public Board(NetworkManager manager) {
        this.manager = manager;
        manager.setBoard(this);
        tiles = new Tile[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final Tile tile = new Tile(this, i, j);
                tiles[i][j] = tile;
                add(tile, i, isWhite() ? (SIZE - j) : j);
            }
        }
        addFigures();
        Platform.runLater(this::addListeners);
        cemetery = new Cemetery();
    }

    public void addListeners() {
        if (manager.isMyTurn()) {
            if (isMate()) {
                manager.sendMessage(new WinMessage());
                manager.getRightVBox().setText("You Lost");
                System.out.println("!!!mate");
                return;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final Tile tile = tiles[i][j];
                if (manager.isMyTurn()) {
                    if (tile.getFigure() != null && tile.getFigure().isWhite() == isWhite()) {
                        tile.setOnMouseClicked(event -> {
                            tile.getFigure().tryToMove();
                        });
                    }
                } else {
                    tile.setOnMouseClicked(null);
                    setMoves(null);
                    setMovingTile(null);
                }
            }
        }
    }

    private boolean isMate() {
        final ArrayList<Figure> figures = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final Figure figure = tiles[i][j].getFigure();
                if (figure != null && figure.isMy()) {
                    figures.add(figure);
                }
            }
        }
        for (Figure figure : figures) {
            movingTile = figure.getTile();
            final int size = figure.getMoves().size();
            if (size > 0) {
                System.out.println(size + "-" + figure);
                movingTile = null;
                return false;
            }
        }
        movingTile = null;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        return true;
    }

    private void addFigures() {
        for (int i = 0; i < SIZE; i++) {
            tiles[i][1].setFigure(new Pawn(true));
            tiles[i][6].setFigure(new Pawn(false));
        }
        tiles[0][0].setFigure(new Rook(true));
        tiles[1][0].setFigure(new Knight(true));
        tiles[2][0].setFigure(new Bishop(true));
        tiles[3][0].setFigure(new Queen(true));
        tiles[4][0].setFigure(new King(true));
        tiles[5][0].setFigure(new Bishop(true));
        tiles[6][0].setFigure(new Knight(true));
        tiles[7][0].setFigure(new Rook(true));
        tiles[0][7].setFigure(new Rook(false));
        tiles[1][7].setFigure(new Knight(false));
        tiles[2][7].setFigure(new Bishop(false));
        tiles[3][7].setFigure(new Queen(false));
        tiles[4][7].setFigure(new King(false));
        tiles[5][7].setFigure(new Bishop(false));
        tiles[6][7].setFigure(new Knight(false));
        tiles[7][7].setFigure(new Rook(false));
        myKing = (King) tiles[4][isWhite() ? 0 : 7].getFigure();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setMovingTile(Tile movingTile) {
        if (this.movingTile != null) {
            this.movingTile.getStyleClass().remove("moving");
        }
        this.movingTile = movingTile;
        if (movingTile != null) {
            movingTile.getStyleClass().add("moving");
        }
    }

    public NetworkManager getManager() {
        return manager;
    }

    public boolean isWhite() {
        return manager.isWhite();
    }

    public Cemetery getCemetery() {
        return cemetery;
    }

    public void setMoves(List<Tile> moves) {

        for (Tile move : this.moves) {
            move.setOnMouseClicked(null);
            move.getStyleClass().remove("move");
            move.getStyleClass().remove("attack");
            move.setOnMouseClicked(null);
        }
        this.moves = moves != null ? moves : new ArrayList<>();
        for (Tile move : this.moves) {
            if (move.getFigure() == null) {
                move.getStyleClass().add("move");
            } else {
                move.getStyleClass().add("attack");
            }
            move.setOnMouseClicked(event -> movingTile.getFigure().move(move));
        }
    }

    public boolean isCheck(Tile tile) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x;
                int y;
                if (movingTile.getFigure() instanceof King) {
                    x = tile.getX() + i;
                    y = tile.getY() + j;
                } else {
                    x = myKing.getTile().getX() + i;
                    y = myKing.getTile().getY() + j;
                }
                while (x >= 0 && y >= 0 && x < Board.SIZE && y < Board.SIZE) {
                    final Figure figure = tiles[x][y].getFigure();
                    if (figure != null) {
                        if (figure.getTile() != movingTile) {
                            if (figure.getTile() == tile) {
                                System.out.println("found: " + tile.getX() + "---" + tile.getY());
                            }
                            if (!figure.isMy() && figure.getTile() != tile) {
                                if (i == 0 || j == 0) {
                                    if (figure instanceof Queen || figure instanceof Rook) {
                                        return true;
                                    }
                                } else {
                                    if (figure instanceof Queen || figure instanceof Bishop) {
                                        return true;
                                    }
                                }
                                if (y == myKing.getY() + (isWhite() ? 1 : -1) && Math.abs(myKing.getTile().getX() - x) == 1 && figure instanceof Pawn) {
                                    return true;
                                }
                                if (figure instanceof King && Math.abs(myKing.getTile().getX() - x) <= 1 && Math.abs(myKing.getTile().getY() - y) <= 1) {
                                    return true;
                                }
                                break;
                            } else {
                                break;
                            }
                        }
                    } else if (tiles[x][y] == tile && !(movingTile.getFigure() instanceof King)) {
                        break;
                    }
                    x += i;
                    y += j;
                }
            }
        }
        for (int[] move : Knight.moves) {
            int x;
            int y;
            if (movingTile.getFigure() instanceof King) {
                x = tile.getX() + move[0];
                y = tile.getY() + move[1];
            } else {
                x = myKing.getTile().getX() + move[0];
                y = myKing.getTile().getY() + move[1];
            }
            if (x >= 0 && y >= 0 && x < Board.SIZE && y < Board.SIZE) {
                if (tiles[x][y] == tile) {
                    continue;
                }
                final Figure figure = tiles[x][y].getFigure();
                if (figure != null && !figure.isMy() && figure instanceof Knight) {
                    return true;
                }
            }
        }
        return false;
    }
}
