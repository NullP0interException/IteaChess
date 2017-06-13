package is.xyz.ui.main;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainScene extends Scene {

    public static final int MAIN_SCENE_WIDTH = 1280;
    public static final int MAIN_SCENE_HEIGHT = 720;

    public MainScene(Parent root) {
        super(root, MAIN_SCENE_WIDTH, MAIN_SCENE_HEIGHT);
//        getStylesheets().add(getClass().getClassLoader().getResource("App.css").toExternalForm());
        getStylesheets().add("app.css");
    }
}
