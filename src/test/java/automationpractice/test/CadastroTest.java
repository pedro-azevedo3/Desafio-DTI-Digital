package automationpractice.test;

import automationpractice.dto.CadastroDTO;
import automationpractice.dto.LoginDTO;
import automationpractice.factory.data.CadastroData;
import automationpractice.factory.data.LoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static automationpractice.factory.selenium.Interactions.*;
import static automationpractice.page.CadastroPage.*;
import static org.junit.Assert.assertEquals;
import static storys.CadastroStory.*;

@Epic(EPIC_CADASTRO)
@Story(USER_STORY_CADASTRO)
public class CadastroTest extends BaseTest{

    CadastroData cadastroData = new CadastroData();
    LoginData loginData = new LoginData();

    @Test
    @Description(CT_CADASTRO_01)
    public void testRealizarCadastro(){
        /* CT001: Realizar cadastro
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email em "Create an account"
        E clico no botão "Create an account"
        E seleciono uma opção em "Title"
        E preencho o campo "First name"
        E preencho o campo "Last name"
        E preencho o campo "Password"
        E preencho o dia de nascimento
        E preenhco o mês de nascimento
        E preencho o ano de nascimento
        QUANDO clico no botão "Register"
        ENTÃO a mensagem "Your account has been created." deve ser exibida na tela.
        */
        CadastroDTO cadastroDTO = cadastroData.cadastro();

        clicar(btnSignIn);
        preencherCampo(campoEmail, cadastroDTO.getEmail());
        clicar(btnCreateAccount);

        clicar(radioTitle);
        preencherCampo(campoNome, cadastroDTO.getFirstName());
        preencherCampo(campoLastName, cadastroDTO.getLastName());
        preencherCampo(campoPassword, cadastroDTO.getPassword());
        select(campoDia, String.valueOf(cadastroDTO.getBirthDay()));
        select(campoMes, String.valueOf(cadastroDTO.getBirthMounth()));
        select(campoAno, String.valueOf(cadastroDTO.getBirthYear()));

        clicar(btnRegister);

        assertEquals("Your account has been created.", lerTexto(msgSucesso));
    }

    @Test
    @Description(CT_CADASTRO_02)
    public void testRealizarCadastroSemPreencherNome(){
        /* CT002: Realizar cadastro sem preencher nome
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email em "Create an account"
        E clico no botão "Create an account"
        E seleciono uma opção em "Title"
        E deixo o campo "First name" em branco
        E preencho o campo "Last name"
        E preencho o campo "Password"
        E preencho o dia de nascimento
        E preenhco o mês de nascimento
        E preencho o ano de nascimento
        QUANDO clico no botão "Register"
        ENTÃO a mensagem "firstname is required." deve ser exibida na tela.
        */
        CadastroDTO cadastroDTO = cadastroData.cadastro();

        clicar(btnSignIn);
        preencherCampo(campoEmail, cadastroDTO.getEmail());
        clicar(btnCreateAccount);

        clicar(radioTitle);
        preencherCampo(campoLastName, cadastroDTO.getLastName());
        preencherCampo(campoPassword, cadastroDTO.getPassword());
        select(campoDia, String.valueOf(cadastroDTO.getBirthDay()));
        select(campoMes, String.valueOf(cadastroDTO.getBirthMounth()));
        select(campoAno, String.valueOf(cadastroDTO.getBirthYear()));

        clicar(btnRegister);

        assertEquals("firstname is required.", lerTexto(msgErro));
    }

    @Test
    @Description(CT_CADASTRO_03)
    public void testRealizarCadastroSemPreencherSenha(){
        /* CT003: Realizar cadastro sem preencher senha
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email em "Create an account"
        E clico no botão "Create an account"
        E seleciono uma opção em "Title"
        E preencho o campo "First name"
        E preencho o campo "Last name"
        E deixo o campo "Password" em branco
        E preencho o dia de nascimento
        E preenhco o mês de nascimento
        E preencho o ano de nascimento
        QUANDO clico no botão "Register"
        ENTÃO a mensagem "passwd is required" deve ser exibida na tela.
        */
        CadastroDTO cadastroDTO = cadastroData.cadastro();

        clicar(btnSignIn);
        preencherCampo(campoEmail, cadastroDTO.getEmail());
        clicar(btnCreateAccount);

        clicar(radioTitle);
        preencherCampo(campoNome, cadastroDTO.getFirstName());
        preencherCampo(campoLastName, cadastroDTO.getLastName());
        select(campoDia, String.valueOf(cadastroDTO.getBirthDay()));
        select(campoMes, String.valueOf(cadastroDTO.getBirthMounth()));
        select(campoAno, String.valueOf(cadastroDTO.getBirthYear()));

        clicar(btnRegister);

        assertEquals("passwd is required.", lerTexto(msgErro));
    }

    @Test
    @Description(CT_CADASTRO_04)
    // Em caso esse teste falhar durante execução de toda a pasta, é necessário que seja reexecutado, desta vez executando apenas a classe "CadastroTest"!
    public void testRealizarCadastroComEmailDuplicado(){
        /* CT004: Realizar cadastro com e-mail duplicado
        DADO que estou na página home
        E clico no botao "Sign in"
        E preencho o campo email em "Create an account"
        QUANDO clico no botão "Create an account"
        ENTÃO a mensagem "An account using this email address has already been registered.
        Please enter a valid password or request a new one." deve ser exibida na tela.
        */

        LoginDTO loginDTO = loginData.login();

        clicar(btnSignIn);
        preencherCampo(campoEmail, loginDTO.getEmail());
        clicar(btnCreateAccount);

        assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", lerTexto(msgErroEmail));
    }

}
