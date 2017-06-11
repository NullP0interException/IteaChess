package is.xyz.ui;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainVBox extends MenuVBox {

    public MainVBox() {
        getChildren().add(new MainButton("Host", event -> change(new HostVBox())));
        getChildren().add(new MainButton("Connect", null));
        getChildren().add(new MainButton("Exit", event -> System.exit(0)));
    }
}
