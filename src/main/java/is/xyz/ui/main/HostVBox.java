package is.xyz.ui.main;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Admin on 10.06.2017.
 */
public class HostVBox extends MenuVBox {

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
        getChildren().add(new MainLabel("Your ip: " + ip));
        getChildren().add(new MainProgressIndicator());
        getChildren().add(new MainButton("Cancel", event -> change(new MainVBox())));
    }
}
