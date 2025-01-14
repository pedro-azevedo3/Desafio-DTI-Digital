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

        LoginDTO loginDTO = loginData.login();

        clicar(btnSignIn);
        preencherCampo(campoEmail, loginDTO.getEmail());
        clicar(btnCreateAccount);

        assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", lerTexto(msgErroEmail));
    }

}
