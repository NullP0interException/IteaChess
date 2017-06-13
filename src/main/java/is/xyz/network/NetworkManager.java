package is.xyz.network;

import is.xyz.ui.board.Board;
import is.xyz.ui.board.BoardParent;
import is.xyz.ui.board.RightVBox;
import is.xyz.ui.main.MainScene;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 11.06.2017.
 */
public class NetworkManager extends Task {

    public static final int PORT = 1488;
    private final Window window;
    private boolean host;
    private Socket socket;
    private ServerSocket ss;
    private String ip;
    private boolean white;
    private boolean turn;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private Board board;
    private RightVBox rightVBox;

    public NetworkManager(Window window) {
        this.window = window;
    }

    @Override
    protected Object call() {
        try {
            window.setOnCloseRequest(event -> stop());
            System.out.println("NetworkManager started");
            if (host) {
                ss = new ServerSocket(PORT);
                socket = ss.accept();
                white = Math.random() > 0.5;
                os = new ObjectOutputStream(socket.getOutputStream());
                os.flush();
                is = new ObjectInputStream(socket.getInputStream());
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
                System.out.println(white);
            }
            turn = white;
            Platform.runLater(() -> ((Stage) window).setScene(new MainScene(new BoardParent(this))));
            while (true/*socket.getInetAddress().isReachable(1000)*/) {
                read().work(this);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    private INetworkMessage read() throws IOException, ClassNotFoundException {
        return ((INetworkMessage) is.readObject());
    }

    public void setBoard(Board board) {
        this.board = board;
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

    public boolean isWhite() {
        return white;
    }

    public boolean isMyTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Board getBoard() {
        return board;
    }

    public void sendMessage(INetworkMessage message){
        try {
            os.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRightVBox(RightVBox rightVBox) {
        this.rightVBox = rightVBox;
    }

    public RightVBox getRightVBox() {
        return rightVBox;
    }
}
