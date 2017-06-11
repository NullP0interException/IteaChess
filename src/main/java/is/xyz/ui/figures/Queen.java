package is.xyz.ui.figures;

import is.xyz.ui.board.Tile;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Queen extends Figure {
    public Queen(boolean isWhite, Tile tile) {
        super(isWhite, tile);
        getStyleClass().add(isWhite ? "white" : "black" + "Queen");
    }
}