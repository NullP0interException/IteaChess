package is.xyz.ui.board;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class CemeteryRowElement extends HBox {
    private ImageView image;
    private Label label;

    public CemeteryRowElement(ImageView image, Label label) {
        this.image = image;
        this.label = label;

        getChildren().addAll(image, label);
    }
}
