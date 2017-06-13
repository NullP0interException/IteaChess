package is.xyz.ui.figures;

import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Bishop extends Figure {
    public Bishop(boolean isWhite) {
        super(isWhite);
        getStyleClass().add((isWhite ? "white" : "black") + "Bishop");
    }

    @Override
    public List<Tile> getMoves() {
        final ArrayList<Tile> list = new ArrayList<>();
        list.addAll(new DiaglonalMove(getTile()).getMoves());
        return list;
    }
}
