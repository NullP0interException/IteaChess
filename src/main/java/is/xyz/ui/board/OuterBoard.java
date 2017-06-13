package is.xyz.ui.board;

import javafx.scene.layout.BorderPane;

/**
 * Created by Admin on 11.06.2017.
 */
public class OuterBoard extends BorderPane {

    public OuterBoard(Board board) {
        super(board);
        setLeft(new NumberColumn(board.isWhite()));
        setRight(new NumberColumn(board.isWhite()));
        setTop(new LettersRow());
        setBottom(new LettersRow());
    }
}
