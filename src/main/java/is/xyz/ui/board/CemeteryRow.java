package is.xyz.ui.board;

import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class CemeteryRow extends HBox {

    public static final int CEMETERY_SPACING = 20;

    public CemeteryRow(ObservableList<CemeteryRowElement> elementsList) {
        super(CEMETERY_SPACING);
//        getChildren().addAll(elementsList);
    }
}
