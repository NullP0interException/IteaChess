package is.xyz.ui.board;

import javafx.scene.layout.HBox;

/**
 * Created by atimohyn on 11.06.2017.
 */
public class BoardParent extends HBox {
    public static final int SPACING = 10;

    public BoardParent() {
        super(SPACING);
        getChildren().add(new BoardVBox());
        getChildren().add(new ChatVBox());
    }
}
