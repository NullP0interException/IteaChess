package is.xyz.ui.board;

import is.xyz.network.NetworkManager;
import javafx.scene.layout.VBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class BoardVBox extends VBox {
    public BoardVBox(NetworkManager networkManager) {
        super(BoardParent.SPACING);
        getChildren().add(new CemeteryRow(null));
        getChildren().add(new OuterBoard(new Board(networkManager)));
        getChildren().add(new CemeteryRow(null));
    }
}
