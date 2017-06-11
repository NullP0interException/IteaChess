package is.xyz.ui.board;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by Admin on 11.06.2017.
 */
public class LettersRow extends HBox {
    public LettersRow() {
        setAlignment(Pos.CENTER);
        final ObservableList<Node> children = getChildren();
        for (int i = 0; i < Board.SIZE; i++) {
            children.add(new BoardLabel((char) (65 + i) + ""));
        }
    }
}
