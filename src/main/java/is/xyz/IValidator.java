package is.xyz;

/**
 * Created by Admin on 11.06.2017.
 */
public interface IValidator<T> {
    boolean validate(T... objects);
}
