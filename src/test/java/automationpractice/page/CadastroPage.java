package automationpractice.page;

import org.openqa.selenium.By;

public class CadastroPage {

    public static final By btnSignIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    public static final By campoEmail = By.cssSelector("#email_create");
    public static final By btnCreateAccount = By.cssSelector("#SubmitCreate");
    public static final By radioTitle = By.cssSelector("#id_gender1");
    public static final By campoNome = By.cssSelector("#customer_firstname");
    public static final By campoLastName = By.cssSelector("#customer_lastname");
    public static final By campoPassword = By.cssSelector("#passwd");
    public static final By campoDia = By.cssSelector("#days");
    public static final By campoMes = By.cssSelector("#months");
    public static final By campoAno = By.cssSelector("#years");
    public static final By btnRegister = By.cssSelector("#submitAccount");
    public static final By msgSucesso = By.cssSelector("#center_column > p.alert.alert-success");
    public static final By msgErro = By.cssSelector("#center_column > div > ol > li");
    public static final By msgErroEmail = By.cssSelector("#create_account_error > ol > li");

}
