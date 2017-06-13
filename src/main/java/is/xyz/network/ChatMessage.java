package is.xyz.network;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 * Created by Admin on 12.06.2017.
 */
public class ChatMessage implements INetworkMessage {

    private final String message;
    private final boolean isWhite;

    public ChatMessage(String message, boolean isWhite) {
        this.message = message;
        this.isWhite = isWhite;
    }

    @Override
    public void work(NetworkManager manager) {
        Platform.runLater(() -> {
            final TextArea textArea = manager.getRightVBox().getChatVBox().getTextArea();
            textArea.setText(textArea.getText() + "\n" + (isWhite ? "White: " : "Black: ") + message);
            textArea.positionCaret(textArea.getLength());
        });
    }
}
