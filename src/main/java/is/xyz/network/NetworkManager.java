package is.xyz.network;

import javafx.concurrent.Task;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 11.06.2017.
 */
public class NetworkManager extends Task {

    public static final int PORT = 1488;
    private boolean host;
    private Socket socket;
    private ServerSocket ss;
    private String ip;
    private boolean white;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public NetworkManager() {
    }

    @Override
    protected Object call() {
        try {
            System.out.println("NetworkManager started");
            if (host) {
                ss = new ServerSocket(PORT);
                socket = ss.accept();
                white = Math.random() > 0.5;
                os = new ObjectOutputStream(socket.getOutputStream());
                os.flush();
                is = new ObjectInputStream(socket.getInputStream());
                os.writeObject(new InitialMessage(!white));
                os.writeObject(new InitialMessage(!white));
                System.out.println(white);
            } else {
                System.out.println("connecting");
                socket = new Socket(ip, PORT);
                System.out.println("connected");
                os = new ObjectOutputStream(socket.getOutputStream());
                os.flush();
                is = new ObjectInputStream(socket.getInputStream());
                read().work(this);
                read().work(this);
                System.out.println(white);
            }
            while (socket.getInetAddress().isReachable(1000)) {
                read();
                System.out.println("kappa");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    private INetworkMessage read() throws IOException, ClassNotFoundException {
        return ((INetworkMessage) is.readObject());
    }


    public void host() {
        host = true;
        new Thread(this).start();
    }

    public void connect(String ip) {
        host = false;
        this.ip = ip;
        new Thread(this).start();
    }

    public void stop() {
        try {
            ss.close();
        } catch (IOException | NullPointerException e) {
            //
        }
        try {
            socket.close();
        } catch (IOException | NullPointerException e) {
            //
        }
        System.out.println("Stopped");
    }

    public void setWhite(boolean white) {
        this.white = white;
    }
}
