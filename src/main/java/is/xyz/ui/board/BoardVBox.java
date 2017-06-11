package is.xyz.ui.board;

import javafx.scene.layout.VBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class BoardVBox extends VBox {
    public BoardVBox() {
        super(BoardParent.SPACING);
        getChildren().add(new CemeteryRow(null));
        getChildren().add(new Board());
        getChildren().add(new CemeteryRow(null));
    }
}
