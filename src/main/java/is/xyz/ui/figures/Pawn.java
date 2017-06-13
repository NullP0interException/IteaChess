package is.xyz.ui.figures;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

import static is.xyz.ui.board.Board.SIZE;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Pawn extends Figure {
    public Pawn(boolean isWhite) {
        super(isWhite);
        getStyleClass().add((isWhite ? "white" : "black") + "Pawn");
    }

    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        final List<Tile> result = new ArrayList<>();
        final Board board = getTile().getBoard();
        if (isWhite() ? (getTile().getY() == 1 && board.getTiles()[getTile().getX()][2].getFigure() == null)
                : (getTile().getY() == 6 && board.getTiles()[getTile().getX()][5].getFigure() == null)) {
            list.add(board.getTiles()[getTile().getX()][isWhite() ? 3 : 4]);
        }
        list.add(board.getTiles()[getTile().getX()][getTile().getY() + (isWhite() ? 1 : -1)]);
        for (Tile tile : list) {
            if (tile.getFigure() == null && !board.isCheck(tile)) {
                result.add(tile);
            }
        }
        list.clear();
        if (getTile().getX() > 0) {
            list.add(board.getTiles()[getTile().getX() - 1][getTile().getY() + (isWhite() ? 1 : -1)]);
        }
        if (getTile().getX() < SIZE - 1) {
            list.add(board.getTiles()[getTile().getX() + 1][getTile().getY() + (isWhite() ? 1 : -1)]);
        }
        for (Tile tile : list) {
            if (tile.getFigure() != null && tile.getFigure().isWhite() != isWhite() && !board.isCheck(tile)) {
                result.add(tile);
            }
        }
        return result;
    }
}
