package is.xyz.chess.figures;

import is.xyz.chess.borad.Tile;
import javafx.scene.image.Image;

/**
 * Created by atimohyn on 10.06.2017.
 */
public abstract class Figure {
    private boolean isWhite;
    private Image image;
    private Tile tile;

    public Figure(boolean isWhite, Image image, Tile tile) {
        this.isWhite = isWhite;
        this.image = image;
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }
    public boolean isWhite() {
        return isWhite;
    }
    public Image getImage() {
        return image;
    }

    public void theMove(Tile tile){
        if (tile.getFigure() != null) {
            kill(tile.getFigure());
        }
    }

    private void kill(Figure figure) {
        tile.getBoard().getCemetery().addFigure(figure);
        figure.getTile().setFigure(null);
    }
}
