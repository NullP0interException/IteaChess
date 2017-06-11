package is.xyz.ui.board;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Created by Admin on 11.06.2017.
 */
public class NumberColumn extends VBox {

    public NumberColumn(boolean isWhite) {
        setAlignment(Pos.CENTER);
        final ObservableList<Node> children = getChildren();
        if (!isWhite) {
            for (int i = 1; i <= Board.SIZE; i++) {
                children.add(new BoardLabel("" + i));
            }
        } else {
            for (int i = Board.SIZE; i > 0; i--) {
                children.add(new BoardLabel("" + i));
            }
        }
    }
}
