package is.xyz.chess.borad;

import is.xyz.chess.figures.Figure;

import java.util.ArrayList;

/**
 * Created by atimohyn on 10.06.2017.
 */
public class Cemetery {
    private ArrayList<Figure> whiteFigures;
    private ArrayList<Figure> blackFigures;

    public Cemetery() {
        whiteFigures = new ArrayList<>(16);
        blackFigures = new ArrayList<>(16);
    }

    public boolean addFigure(Figure figure) {
        return figure.isWhite() ? whiteFigures.add(figure) : blackFigures.add(figure);
    }

    public ArrayList<Figure> getWhiteFigures() {
        return whiteFigures;
    }

    public ArrayList<Figure> getBlackFigures() {
        return blackFigures;
    }

}
