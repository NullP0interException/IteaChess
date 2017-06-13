package is.xyz.ui.figures;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Knight extends Figure {

    public static final int[][] moves = new int[][]{{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2},};

    public Knight(boolean isWhite) {
        super(isWhite);
        getStyleClass().add((isWhite ? "white" : "black") + "Knight");
    }

    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        final Tile[][] tiles = getTile().getBoard().getTiles();
        for (int[] move : moves) {
            final int x = getTile().getX() + move[0];
            final int y = getTile().getY() + move[1];
            if (x >= 0 && y >= 0 && x < Board.SIZE && y < Board.SIZE) {
                final Tile tile = tiles[x][y];
                if (tile.canMoveTo()) {
                    list.add(tile);
                }
            }
        }
        return list;
    }
}
