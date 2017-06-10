package is.xyz.chess.borad;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Board {
    private Tile[][] tiles;
    private Cemetery cemetery;

    public Board() {
        tiles = new Tile[8][8];
        cemetery = new Cemetery();
    }

    public Cemetery getCemetery() {
        return cemetery;
    }
}
