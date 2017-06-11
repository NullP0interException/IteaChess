package is.xyz.ui.main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainLabel extends Label {

    public MainLabel(String text) {
        super(text);
        getStyleClass().add("mainLabel");
        setPrefSize(MenuVBox.PREF_WIDTH, MenuVBox.PREF_HEIGHT);
        setAlignment(Pos.CENTER);
    }
}
