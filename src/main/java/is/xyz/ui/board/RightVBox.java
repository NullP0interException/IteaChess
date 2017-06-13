package is.xyz.ui.board;

import is.xyz.network.NetworkManager;
import is.xyz.ui.main.MainLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class RightVBox extends VBox {


    private final Label mainLabel;
    private final NetworkManager networkManager;
    private final ChatVBox chatVBox;

    public RightVBox(NetworkManager networkManager) {
        super(BoardParent.SPACING);
        this.networkManager = networkManager;
        this.networkManager.setRightVBox(this);
        setAlignment(Pos.CENTER);
        mainLabel = new Label("");
        mainLabel.setAlignment(Pos.CENTER);
        setText();
        chatVBox = new ChatVBox(networkManager);
        getChildren().addAll(mainLabel, chatVBox);
    }

    public ChatVBox getChatVBox() {
        return chatVBox;
    }

    public void setText() {
        mainLabel.setText(networkManager.isMyTurn() ? "Your turn" : "!Your turn");
        mainLabel.getStyleClass().add(!networkManager.isMyTurn() ? "red" : "green");
        mainLabel.getStyleClass().remove(networkManager.isMyTurn() ? "red" : "green");
    }

    public void setText(String s) {
        mainLabel.setText(s);
        mainLabel.getStyleClass().add(networkManager.isMyTurn() ? "red" : "green");
        mainLabel.getStyleClass().remove(!networkManager.isMyTurn() ? "red" : "green");
    }
}
