package starter.ui.addtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddTransactionPage {
    public static Target BUTTON_ADD_TRANSACTION = Target.the("Add transaction button").locatedBy("//button[@data-target='#transactionModal']");
    public static Target INPUT_DATE = Target.the("input date").locatedBy("//input[@type='date']");
    public static Target INPUT_AMOUNT = Target.the("input amount").located(By.id("amount"));
    public static Target INPUT_DESCRIPTION = Target.the("input amount").located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("input amount").locatedBy("//button[contains(., 'Guardar')]");
    public static Target TRANSACTIONS_TABLE = Target.the("Transactions table")
            .located(By.xpath("//tbody[@id='transactions-list']"));

    public static String TRANSACTIONS_TABLE_XPATH = "//tbody[@id='transactions-list']";

}
