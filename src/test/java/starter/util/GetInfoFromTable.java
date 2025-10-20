package starter.util;

import io.cucumber.datatable.DataTable;
import starter.models.LoginModel;
import starter.models.TransactionModel;

import java.util.List;

public class GetInfoFromTable {

    public static LoginModel getLoginCredentials(DataTable userLogin){

        List<List<String>> rows = userLogin.asLists(String.class);
        String username = "";
        String password = "";

        for(List<String> columns: rows){
            username = columns.get(0);
            password = columns.get(1);
        }

        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);

        return loginModel;
    }

    public static TransactionModel getTransactionData(DataTable transactionInfo){

        List<List<String>> rows = transactionInfo.asLists(String.class);

        String transactionDate = "";
        String transactionAmount = "";
        String transactionDescription = "";

        for(List<String> columns: rows){
            transactionDate = columns.get(0);
            transactionAmount = columns.get(1);
            transactionDescription = columns.get(2);
        }

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTransactionAmount(transactionAmount);
        transactionModel.setTransactionDate(transactionDate);
        transactionModel.setTransactionDescription(transactionDescription);

        return transactionModel;
    }
}
