package is.xyz.ui.figures;

import is.xyz.ui.board.Tile;
import javafx.scene.image.ImageView;

/**
 * Created by atimohyn on 10.06.2017.
 */
public abstract class Figure extends ImageView{
    private boolean isWhite;
    private Tile tile;

    public Figure(boolean isWhite, Tile tile) {
        this.isWhite = isWhite;
        this.tile = tile;
        getStyleClass().add("figure");
        if (tile.getBoard().isWhite() == isWhite){
            getStyleClass().add("myFigure");
        }
        setFitHeight(60);
        setFitWidth(60);
    }

    public Tile getTile() {
        return tile;
    }
    public boolean isWhite() {
        return isWhite;
    }


    public void move(Tile tile){
        if (tile.getFigure() != null) {
            kill(tile.getFigure());
        }
    }

    private void kill(Figure figure) {
        tile.getBoard().getCemetery().addFigure(figure);
        figure.getTile().setFigure(null);
    }
}
