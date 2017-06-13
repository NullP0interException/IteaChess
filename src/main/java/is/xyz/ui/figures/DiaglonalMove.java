package is.xyz.ui.figures;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12.06.2017.
 */
public class DiaglonalMove implements Move {

    private final Tile tile;

    public DiaglonalMove(Tile tile) {
        this.tile = tile;
    }


    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        final Tile[][] tiles = tile.getBoard().getTiles();
        final int x = tile.getX();
        final int y = tile.getY();
        for (int i = x + 1, j = y + 1; i < Board.SIZE && j < Board.SIZE; i++, j++) {
            if (tiles[i][j].canMoveTo()) {
                list.add(tiles[i][j]);
            }
            if (tiles[i][j].getFigure() != null) {
                break;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < Board.SIZE; i--, j++) {
            if (tiles[i][j].canMoveTo()) {
                list.add(tiles[i][j]);
            }
            if (tiles[i][j].getFigure() != null) {
                break;
            }
        }
        for (int i = x + 1, j = y - 1; i < Board.SIZE && j >= 0; i++, j--) {
            if (tiles[i][j].canMoveTo()) {
                list.add(tiles[i][j]);
            }
            if (tiles[i][j].getFigure() != null) {
                break;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (tiles[i][j].canMoveTo()) {
                list.add(tiles[i][j]);
            }
            if (tiles[i][j].getFigure() != null) {
                break;
            }
        }
        return list;
    }

}
