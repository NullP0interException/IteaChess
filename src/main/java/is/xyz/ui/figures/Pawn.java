package is.xyz.ui.figures;

import is.xyz.ui.board.Tile;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Pawn extends Figure {
    public Pawn(boolean isWhite, Tile tile) {
        super(isWhite, tile);
        getStyleClass().add(isWhite ? "white" : "black" + "Pawn");
    }
}
