package is.xyz.ui.main;


/**
 * Created by Admin on 11.06.2017.
 */
public class ConnectVBox extends MenuVBox {
    public ConnectVBox() {
        final MainTextField mainTextField = new MainTextField();
        final IPValidator validator = new IPValidator();
        getChildren().add(mainTextField);
        getChildren().add(new MainButton("Connect", event -> {
            if (validator.validate(mainTextField.getText())) {

            } else {
                mainTextField.setPromptText("Enter valid ip");
                mainTextField.getStyleClass().add("errorText");
                mainTextField.setText("");
            }
        }));
        getChildren().add(new MainButton("Back", event -> change(new MainVBox())));
    }
}
