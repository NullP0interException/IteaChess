package is.xyz.ui.board;

import is.xyz.network.NetworkManager;
import javafx.scene.layout.HBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class BoardParent extends HBox {
    public static final int SPACING = 10;

    public BoardParent(NetworkManager networkManager) {
        super(SPACING);
        getChildren().add(new BoardVBox(networkManager));
        getChildren().add(new RightVBox(networkManager));
    }
}
