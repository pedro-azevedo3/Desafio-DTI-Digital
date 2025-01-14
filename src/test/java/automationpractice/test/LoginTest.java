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

        /*
        CT001: Realizar login com dados válidos
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email com email cadastrado
        E preencho o campo senha com uma senha válida
        QUANDO clico no botão Sign in
        ENTÃO sou direcionado para a tela "My Account".
         */
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

        /* CT002: Realizar login com email inválido
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email com email não cadastrado
        E preencho o campo senha com uma senha válida
        QUANDO clico no botão Sign in
        ENTÃO a mensagem "Authentication failed." deve ser exibida na tela.
        */

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

        /* CT003: Realizar login com senha inválida
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email com email cadastrado
        E preencho o campo senha com uma senha inválida
        QUANDO clico no botão Sign in
        ENTÃO a mensagem "Authentication failed." deve ser exibida na tela.
        */

        LoginDTO loginDTO =  loginData.loginSenhaInvalida();

        clicar(btnLogin);
        preencherCampo(campoEmail, loginDTO.getEmail());
        preencherCampo(campoSenha, loginDTO.getPassword());
        clicar(btnAcessar);

        assertEquals("Authentication failed.", lerTexto(msgDadosIncorretos));
    }


}
