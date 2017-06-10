package is.xyz.ui;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainParent extends VBox {

    public static final int SPACING = 100;

    public MainParent() {
        super(SPACING);
        getChildren().addAll(new LogoLabel(), new MainVBox());
        setAlignment(Pos.CENTER);
    }
}
