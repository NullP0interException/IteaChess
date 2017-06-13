package is.xyz.ui.figures;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12.06.2017.
 */
public class LineMove implements Move {

    private final Tile tile;

    public LineMove(Tile tile) {
        this.tile = tile;
    }

    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        final Tile[][] tiles = tile.getBoard().getTiles();
        final int x = tile.getX();
        final int y = tile.getY();
        for (int i = x + 1; i < Board.SIZE; i += 1) {
            final Tile tile = tiles[i][y];
            if (tile.canMoveTo()) {
                list.add(tile);
            }
            if (tile.getFigure() != null) {
                break;
            }
        }
        for (int j = y + 1; j < Board.SIZE; j++) {
            final Tile tile = tiles[x][j];
            if (tile.canMoveTo()) {
                list.add(tile);
            }
            if (tile.getFigure() != null) {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i -= 1) {
            final Tile tile = tiles[i][y];
            if (tile.canMoveTo()) {
                list.add(tile);
            }
            if (tile.getFigure() != null) {
                break;
            }
        }
        for (int j = y - 1; j >= 0; j--) {
            final Tile tile = tiles[x][j];
            if (tile.canMoveTo()) {
                list.add(tile);
            }
            if (tile.getFigure() != null) {
                break;
            }
        }
        return list;
    }
}
