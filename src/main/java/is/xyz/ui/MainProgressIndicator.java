package is.xyz.ui;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;

import static is.xyz.ui.MenuVBox.SPACING;
import static javafx.geometry.Pos.CENTER;

/**
 * Created by Admin on 11.06.2017.
 */
public class MainProgressIndicator extends HBox {

    public MainProgressIndicator() {
        super(SPACING);
        setAlignment(CENTER);
        setPrefSize(MenuVBox.PREF_WIDTH, MenuVBox.PREF_HEIGHT);
        getChildren().addAll(new ProgressIndicator(), new Label("Waiting opponent..."));
    }
}
