package is.xyz.ui.main;

import is.xyz.IValidator;

import java.util.regex.Pattern;

/**
 * Created by Admin on 11.06.2017.
 */
public class IPValidator implements IValidator<String> {

    private final Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public boolean validate(String... objects) {
        return pattern.matcher(objects[0]).matches();
    }
}
