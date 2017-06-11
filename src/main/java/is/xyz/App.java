package is.xyz;

import is.xyz.ui.board.BoardParent;
import is.xyz.ui.main.MainParent;
import is.xyz.ui.main.MainScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {

    private static final double ASPECT_RATIO = 16.0 / 9;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("images/Chess.png")));
//        VBox root = new VBox(10);
//        Label height = new Label();
//        Label width = new Label();
//        root.getChildren().add(height);
//        root.getChildren().add(width);
//        System.out.println(primaryStage.getIcons().size());
//        final Scene scene = new Scene(root, 1280, 720);
//        scene.getStylesheets().add(getClass().getClassLoader().getResource("app.css").toExternalForm());
//        height.textProperty().bind(scene.heightProperty().asString());
//        width.textProperty().bind(scene.widthProperty().asString());
//        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println(newValue.doubleValue() * ASPECT_RATIO);
//            primaryStage.setWidth(newValue.doubleValue() * ASPECT_RATIO);
//        });
//        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> primaryStage.setHeight(newValue.doubleValue() / ASPECT_RATIO));
        primaryStage.setScene(new MainScene(new BoardParent()));
        primaryStage.show();
    }
}
