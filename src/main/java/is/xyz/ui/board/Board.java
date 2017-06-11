package is.xyz.ui.board;

import is.xyz.ui.figures.Bishop;
import javafx.scene.layout.GridPane;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Board extends GridPane {
    public static final int SIZE = 8;
    private final Tile[][] tiles;
    private final Cemetery cemetery;
    private final boolean white;

    public Board(boolean white) {
        this.white = white;
        tiles = new Tile[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                final Tile tile = new Tile(this, i, j);
                tiles[i][j] = tile;
                tile.setFigure(new Bishop(false, tile));
                add(tile, i, j);
            }
        }
        cemetery = new Cemetery();
    }

    public boolean isWhite() {
        return white;
    }

    public Cemetery getCemetery() {
        return cemetery;
    }
}
