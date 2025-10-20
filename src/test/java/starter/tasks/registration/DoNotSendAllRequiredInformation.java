package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.registration.RegisterForm;

public class DoNotSendAllRequiredInformation implements Task {

    private final String expectedName;
    private final String expectedLastName;

    public DoNotSendAllRequiredInformation(String expectedName, String expectedLastName){
        this.expectedName = expectedName;
        this.expectedLastName = expectedLastName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(expectedName).into(RegisterForm.INPUT_NAME),
                Enter.theValue(expectedLastName).into(RegisterForm.INPUT_LAST_NAME),
                Click.on(RegisterForm.BUTTON_SAVE)
        );
    }
}
