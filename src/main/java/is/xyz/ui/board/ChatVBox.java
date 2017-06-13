package is.xyz.ui.board;

import is.xyz.network.ChatMessage;
import is.xyz.network.NetworkManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static is.xyz.ui.board.BoardParent.SPACING;

/**
 * Created by Admin on 12.06.2017.
 */
public class ChatVBox extends VBox {

    private final TextArea textArea;
    private final HBox hBox;
    private final TextField textField;
    private final Button button;
    private final NetworkManager networkManager;

    public ChatVBox(NetworkManager networkManager) {
        super(SPACING);
        this.networkManager = networkManager;
        setPrefWidth(500);
        setAlignment(Pos.CENTER);
        textArea = new TextArea();
        textArea.getStyleClass().add("chat");
        textArea.setPrefSize(500, 450);
        textArea.setEditable(false);
        hBox = new HBox(SPACING);
        textField = new TextField();
        textField.getStyleClass().add("chat");
        textField.setPrefSize(290, 100);
        textField.setOnKeyPressed(event -> {
            if (event.getCode()== KeyCode.ENTER){
                sendMessage();
            }
        });
        button = new Button("Send");
        button.getStyleClass().add("chatButton");
        button.setPrefSize(200, 100);
        button.setOnAction(event -> sendMessage());
        hBox.getChildren().addAll(textField, button);
        getChildren().addAll(textArea, hBox);
    }

    private void sendMessage() {
        if (textField.getText().equals(""))
            return;
        final ChatMessage chatMessage = new ChatMessage(textField.getText(), networkManager.isWhite());
        chatMessage.work(networkManager);
        networkManager.sendMessage(chatMessage);
        textField.setText("");
        textField.requestFocus();
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
