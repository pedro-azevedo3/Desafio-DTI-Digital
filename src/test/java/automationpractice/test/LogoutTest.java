package automationpractice.test;

import automationpractice.dto.LoginDTO;
import automationpractice.factory.data.LoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static automationpractice.factory.selenium.Interactions.*;
import static automationpractice.page.LoginPage.*;
import static automationpractice.page.LogoutPage.btnSignout;
import static org.junit.Assert.assertEquals;
import static storys.LogoutStory.*;

@Epic(EPIC_LOGOUT)
@Story(USER_STORY_LOGOUT)
public class LogoutTest extends BaseTest{

    LoginData loginData = new LoginData();

    @Test
    @Description(CT_LOGOUT_01)
    public void testValidarLogout(){
        /*
        CT001: Realizar logout
        DADO que estou logado na aplicação
        E estou na página home
        QUANDO clico no botão "Sign out"
        ENTÃO a opção "Sign in" deve aparecer novamente.
        */
        LoginDTO loginDTO =  loginData.login();

        clicar(btnLogin);
        preencherCampo(campoEmail, loginDTO.getEmail());
        preencherCampo(campoSenha, loginDTO.getPassword());
        clicar(btnAcessar);

        clicar(btnSignout);

        assertEquals("Sign in", lerTexto(btnLogin));
    }
}
