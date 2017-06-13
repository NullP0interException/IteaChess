package is.xyz.ui.figures;

import is.xyz.network.MoveMessage;
import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public abstract class Figure extends ImageView {
    private boolean isWhite;

    public Figure(boolean isWhite) {
        this.isWhite = isWhite;
        getStyleClass().add("figure");
        Platform.runLater(() -> {
            if (getTile().getBoard().isWhite() == isWhite) {
                getStyleClass().add("myFigure");
            }
        });
        setFitHeight(60);
        setFitWidth(60);
    }

    public Tile getTile() {
        return ((Tile) getParent());
    }

    public boolean isWhite() {
        return isWhite;
    }


    public void move(Tile tile) {
        final MoveMessage moveMessage = new MoveMessage(getTile().getX(), getTile().getY(), tile.getX(), tile.getY());
        moveMessage.work(getTile().getBoard().getManager());
        getTile().getBoard().getManager().sendMessage(moveMessage);
    }

    public void tryToMove() {
        final Board board = getTile().getBoard();
        if (board.getManager().isMyTurn()) {
            board.setMovingTile(getTile());
            board.setMoves(getMoves());
        }
    }

    public abstract List<Tile> getMoves();

    public boolean isMy() {
        return getTile().getBoard().isWhite() == isWhite;
    }
}
