package is.xyz.ui.figures;

import is.xyz.ui.board.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Queen extends Figure {
    public Queen(boolean isWhite) {
        super(isWhite);
        getStyleClass().add((isWhite ? "white" : "black") + "Queen");
    }

    @Override
    public List<Tile> getMoves() {
        final List<Tile> list = new ArrayList<>();
        list.addAll(new DiaglonalMove(getTile()).getMoves());
        list.addAll(new LineMove(getTile()).getMoves());
        return list;
    }
}
