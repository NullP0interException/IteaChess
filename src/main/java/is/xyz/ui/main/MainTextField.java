package is.xyz.ui.main;


import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

/**
 * Created by Admin on 11.06.2017.
 */
public class MainTextField extends TextField {

    public MainTextField() {
        super("127.0.0.1");
        setPromptText("Enter ip");
        getStyleClass().add("mainTextField");
        setAlignment(Pos.CENTER);
        Platform.runLater(() -> getParent().requestFocus());
    }
}
