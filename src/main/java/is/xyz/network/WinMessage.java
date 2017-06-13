package is.xyz.network;

import javafx.application.Platform;

/**
 * Created by Admin on 12.06.2017.
 */
public class WinMessage implements INetworkMessage {
    @Override
    public void work(NetworkManager manager) {
        Platform.runLater(() -> {
            manager.getRightVBox().setText("You Win");
        });
    }
}
