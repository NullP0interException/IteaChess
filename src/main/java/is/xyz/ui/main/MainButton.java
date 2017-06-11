package is.xyz.ui.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainButton extends Button {

    public MainButton(String text, EventHandler<ActionEvent> eventHandler) {
        super(text);
        setOnAction(eventHandler);
        getStyleClass().add("mainButton");
        setPrefSize(MenuVBox.PREF_WIDTH, MenuVBox.PREF_HEIGHT);
    }
}
