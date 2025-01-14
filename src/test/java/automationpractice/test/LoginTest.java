package automationpractice.test;

import automationpractice.dto.LoginDTO;
import automationpractice.factory.data.LoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static automationpractice.factory.selenium.Interactions.*;
import static automationpractice.page.LoginPage.*;
import static org.junit.Assert.assertEquals;
import static storys.LoginStory.*;

@Epic(EPIC_LOGIN)
@Story(USER_STORY_LOGIN)
public class LoginTest extends BaseTest {

    LoginData loginData = new LoginData();

    @Test
    @Description(CT_LOGIN_01)
    public void testValidarLogin(){

        LoginDTO loginDTO =  loginData.login();

        clicar(btnLogin);
        preencherCampo(campoEmail, loginDTO.getEmail());
        preencherCampo(campoSenha, loginDTO.getPassword());
        clicar(btnAcessar);

        assertEquals("Sign out", lerTexto(textMsgBtnLogout));
    }

    @Test
    @Description(CT_LOGIN_02)
    public void testValidarLoginComEmailInvalido(){

        LoginDTO loginDTO =  loginData.loginEmailInvalido();

        clicar(btnLogin);
        preencherCampo(campoEmail, loginDTO.getEmail());
        preencherCampo(campoSenha, loginDTO.getPassword());
        clicar(btnAcessar);

        assertEquals("Invalid email address.", lerTexto(msgDadosIncorretos));
    }

    @Test
    @Description(CT_LOGIN_03)
    public void testValidarLoginComSenhaInvalida(){

        LoginDTO loginDTO =  loginData.loginSenhaInvalida();

        clicar(btnLogin);
        preencherCampo(campoEmail, loginDTO.getEmail());
        preencherCampo(campoSenha, loginDTO.getPassword());
        clicar(btnAcessar);

        assertEquals("Authentication failed.", lerTexto(msgDadosIncorretos));
    }


}
