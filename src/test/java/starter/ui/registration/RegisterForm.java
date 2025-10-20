package starter.ui.registration;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterForm {

    public static Target INPUT_NAME = Target.the("input name").locatedBy("//input[@id='name']");
    public static Target INPUT_LAST_NAME = Target.the("input last name").locatedBy("//input[@id='last-name']");
    public static Target INPUT_AGE = Target.the("input age").locatedBy("//input[@id='age']");
    public static Target SELECT_COUNTRY = Target.the("select country").locatedBy("//select[@id='country']");
    public static Target INPUT_EMAIL = Target.the("input email").locatedBy("//input[@type='email']");
    public static Target INPUT_SEX = Target.the("input sex").locatedBy("//input[@id='sex-m']");
    public static Target INPUT_MONDAY = Target.the("input monday").locatedBy("//input[@id='monday']");
    public static Target INPUT_PICTURE = Target.the("input picture").locatedBy("//input[@id='picture']");
    public static Target BUTTON_SAVE = Target.the("button save").locatedBy("//button[@id='save-btn']");
    public static Target ALERT_ALL_REQUIRED_FIELDS =  Target.the("Required fields alert")
            .locatedBy("//div[@role='alert']");

}