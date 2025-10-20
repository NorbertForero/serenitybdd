package starter.ui.login;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static Target INPUT_USERNAME = Target.the("username input").located(By.id("username"));
    public static Target INPUT_PASSWORD = Target.the("password input").located(By.id("password"));
    public static Target BUTTON_LOG_IN = Target.the("login button").located(By.xpath("//button[@type='submit']"));
}
