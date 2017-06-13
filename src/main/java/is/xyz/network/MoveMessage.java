package is.xyz.network;

import is.xyz.ui.board.Tile;
import javafx.application.Platform;

/**
 * Created by Admin on 12.06.2017.
 */
public class MoveMessage implements INetworkMessage {

    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public MoveMessage(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void work(NetworkManager manager) {
        Platform.runLater(() -> {
            manager.setTurn(!manager.isMyTurn());
            manager.getRightVBox().setText();
            final Tile[][] tiles = manager.getBoard().getTiles();
            final Tile tile = tiles[x2][y2];
            if (tile.getFigure() != null) {
                manager.getBoard().getCemetery().addFigure(tile.getFigure());
            }
            tile.setFigure(tiles[x1][y1].getFigure());
            tiles[x1][y1].setFigure(null);
            manager.getBoard().addListeners();
        });
    }
}
