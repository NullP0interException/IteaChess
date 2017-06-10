package is.xyz.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * Created by Admin on 10.06.2017.
 */
public class LogoLabel extends Label {

    public static final String LOGO_STRING = "Itea Chess";

    public LogoLabel() {
        super(LOGO_STRING);
        setAlignment(Pos.CENTER);
        getStyleClass().add("logoLabel");
    }
}
