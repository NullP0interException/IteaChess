package is.xyz.chess.borad;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Board {
    public static final int SIZE = 8;
    private Tile[][] tiles;
    private Cemetery cemetery;

    public Board() {
        tiles = new Tile[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = new Tile(this, i, j);
            }
        }
        cemetery = new Cemetery();
    }

    public Cemetery getCemetery() {
        return cemetery;
    }
}
