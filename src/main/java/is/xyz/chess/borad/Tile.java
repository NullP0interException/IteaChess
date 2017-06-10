package is.xyz.chess.borad;

import is.xyz.chess.figures.Figure;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Tile {
    private Board board;
    private int x;
    private int y;
    private Figure figure;

    public Tile() {
    }

    public Tile(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
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
    }

    public Board getBoard() {
        return board;
    }
}
