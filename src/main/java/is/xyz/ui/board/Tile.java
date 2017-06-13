package is.xyz.ui.board;

import is.xyz.ui.figures.Figure;
import javafx.scene.layout.BorderPane;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Tile extends BorderPane {
    private Board board;
    private int x;
    private int y;
    private Figure figure;

    public Tile(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        getStyleClass().addAll("tile", (x + y) % 2 != 0 ? "blackTile" : "whiteTile");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        setCenter(figure);
    }

    public Board getBoard() {
        return board;
    }

    public boolean canMoveTo() {
        return (figure == null || !figure.isMy()) && !getBoard().isCheck(this);
    }
}
