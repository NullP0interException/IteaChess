package is.xyz.ui.figures;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class King extends Figure {
    public King(boolean isWhite) {
        super(isWhite);
        getStyleClass().add((isWhite ? "white" : "black") + "King");
    }

    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        final int x = getTile().getX();
        final int y = getTile().getY();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < Board.SIZE && j < Board.SIZE) {
                    final Tile tile = getTile().getBoard().getTiles()[i][j];
                    if (tile.canMoveTo()) {
                        list.add(tile);
                    }
                }
            }
        }
        return list;
    }
}
