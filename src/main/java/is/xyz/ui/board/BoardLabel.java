package is.xyz.ui.board;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * Created by Admin on 11.06.2017.
 */
public class BoardLabel extends Label {
    public BoardLabel(String text) {
        super(text);
        setAlignment(Pos.CENTER);
        getStyleClass().add("boardLabel");
    }
}
