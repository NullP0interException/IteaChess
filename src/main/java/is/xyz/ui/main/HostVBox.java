package is.xyz.ui.main;

import is.xyz.network.NetworkManager;
import javafx.application.Platform;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Admin on 10.06.2017.
 */
public class HostVBox extends MenuVBox {

    private NetworkManager networkManager;

    public HostVBox() {
        String ip = "127.0.0.1";
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp())
                    continue;
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (!addr.getHostAddress().contains(":")) {
                        ip = addr.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            networkManager = new NetworkManager(getScene().getWindow());
            networkManager.host();
        });
        getChildren().add(new MainLabel("Your ip: " + ip));
        getChildren().add(new MainProgressIndicator());
        getChildren().add(new MainButton("Cancel", event -> {
            networkManager.stop();
            change(new MainVBox());
        }));
    }
}
