package automationpractice.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By btnLogin = By.cssSelector("#header nav > div.header_user_info > a");
    public static final By campoEmail =
            By.cssSelector("#email");
    public static final By campoSenha =
            By.cssSelector("#passwd");
    public static final By btnAcessar =
            By.cssSelector("#SubmitLogin");
    public static final By textMsgBtnLogout =
            By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    public static final By msgDadosIncorretos =
            By.cssSelector("#center_column > div.alert.alert-danger > ol > li");
}
