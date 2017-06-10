package is.xyz.ui;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Created by Admin on 10.06.2017.
 */
public class MainVBox extends VBox {

    public static final int SPACING = 10;

    public MainVBox() {
        super(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(new MainButton("Kappa", null), new MainButton("kappa2", null), new MainButton("Exit", null));
    }
}
