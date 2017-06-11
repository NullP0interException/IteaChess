package is.xyz.network;

/**
 * Created by Admin on 11.06.2017.
 */
public class InitialMessage implements INetworkMessage {

    private final boolean white;

    public InitialMessage(boolean white) {
        this.white = white;
    }

    @Override
    public void work(NetworkManager manager) {
        manager.setWhite(white);
    }
}
