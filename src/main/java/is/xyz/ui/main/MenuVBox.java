package is.xyz.ui.main;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Created by Admin on 10.06.2017.
 */
public class MenuVBox extends VBox {

    public static final int SPACING = 10;
    public static final int PREF_WIDTH = 500;
    public static final int PREF_HEIGHT = 100;

    public MenuVBox() {
        super(SPACING);
        setAlignment(Pos.CENTER);
    }

    protected void change(MenuVBox newVBox) {
        final ObservableList<Node> children = ((VBox) getParent()).getChildren();
        children.remove(this);
        children.add(newVBox);
    }
}
