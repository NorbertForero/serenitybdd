package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;
import starter.ui.registration.RegisterForm;

import java.net.URISyntaxException;

public class RegisterUser implements Task {

    private final String expectedName;
    private final String expectedLastName;
    private final String expectedAge;
    private final String expectedEmail;
    private final String expectedCountry;

    public RegisterUser(String expectedName, String expectedLastname, String expectedAge,
                        String expectedEmail, String expectedCountry
    ){

        this.expectedName = expectedName;
        this.expectedLastName = expectedLastname;
        this.expectedAge = expectedAge;
        this.expectedEmail = expectedEmail;
        this.expectedCountry = expectedCountry;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Enter.theValue(expectedName).into(RegisterForm.INPUT_NAME),
                    Enter.theValue(expectedLastName).into(RegisterForm.INPUT_LAST_NAME),
                    Enter.theValue(expectedAge).into(RegisterForm.INPUT_AGE),
                    SelectFromOptions.byVisibleText(expectedCountry).from(RegisterForm.SELECT_COUNTRY),
                    Click.on(RegisterForm.INPUT_SEX),
                    Enter.theValue(expectedEmail).into(RegisterForm.INPUT_EMAIL),
                    Click.on(RegisterForm.INPUT_MONDAY),
                    Upload.theClasspathResource("pictures/img.png")
                            .to(RegisterForm.INPUT_PICTURE),
                    Click.on(RegisterForm.BUTTON_SAVE)
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
