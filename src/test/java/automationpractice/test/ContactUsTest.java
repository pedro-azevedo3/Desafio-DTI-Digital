package automationpractice.test;

import automationpractice.dto.ContactUsDTO;
import automationpractice.factory.data.ContactUsData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static automationpractice.factory.selenium.Interactions.*;
import static automationpractice.page.ContactUsPage.*;
import static org.junit.Assert.assertEquals;
import static storys.ContactUsStory.*;

@Epic(EPIC_CONTACT_US)
@Story(USER_STORY_CONTACT_US)
public class ContactUsTest extends BaseTest{

    ContactUsData contactUsData = new ContactUsData();

    @Test
    @Description(CT_CONTACT_US_01)
    public void testEnviarMensagemUtilizandoDadosValidos(){
        /* CT001: Enviar mensagem utilizando dados válidos
    DADO que estou na pagina inicial
    E clico no botão "Contact us"
    E seleciono uma opção no "Subject Heading"
    E preencho o campo e-mail corretamente
    E preencho o campo "Order reference" corretamente
    E preencho o campo "Message" corretamente
    QUANDO clico no botão "Send"
    ENTÃO a mensagem "Your message has been successfully sent to our team." deve ser exibida na tela.
    */

        ContactUsDTO contactUsDTO = contactUsData.contactUsValido();

        clicar(btnContactUs);
        selectPorIndex(selectSubjectHeading, contactUsDTO.getSubjectHeading());
        preencherCampo(inputEmailAddress, contactUsDTO.getEmailAddress());
        preencherCampo(inputOrderReference, contactUsDTO.getOrderReference());
        preencherCampo(inputMessage, contactUsDTO.getMessage());
        clicar(btnSend);

        assertEquals("Your message has been successfully sent to our team.", lerTexto(msgSuccess));

    }

    @Test
    @Description(CT_CONTACT_US_02)
    public void testEnviarMensagemSemPreencherOCampoSubjectHeading(){
        /*CT002: Enviar mensagem sem preencher o campo "Subject Heading"
        DADO que estou na pagina inicial
        E clico no botão "Contact us"
        E não seleciono uma opção no "Subject Heading"
        E preencho o campo "E-mail address" corretamente
        E preencho o campo "Order reference" corretamente
        E preencho o campo "Message" corretamente
        QUANDO clico no botão "Send"
        ENTÃO a mensagem "Please select a subject from the list provided." deve ser exibida na tela.
         */
        ContactUsDTO contactUsDTO = contactUsData.contactUsValido();

        clicar(btnContactUs);
        preencherCampo(inputEmailAddress, contactUsDTO.getEmailAddress());
        preencherCampo(inputOrderReference, contactUsDTO.getOrderReference());
        preencherCampo(inputMessage, contactUsDTO.getMessage());
        clicar(btnSend);

        assertEquals("Please select a subject from the list provided.", lerTexto(msgErro));

    }

    @Test
    @Description(CT_CONTACT_US_03)
    public void testEnviarMensagemSemPreencherOCampoEmailAddress(){
        /*CT003: Enviar mensagem sem preencher o campo "E-mail address"
        DADO que estou na pagina inicial
        E clico no botão "Contact us"
        E seleciono uma opção no "Subject Heading"
        E deixo o campo "E-mail address" em branco
        E preencho o campo "Order reference" corretamente
        E preencho o campo "Message" corretamente
        QUANDO clico no botão "Send"
        ENTÃO a mensagem "Invalid email address." deve ser exibida na tela.
         */

        ContactUsDTO contactUsDTO = contactUsData.contactUsValido();

        clicar(btnContactUs);
        selectPorIndex(selectSubjectHeading, contactUsDTO.getSubjectHeading());
        preencherCampo(inputOrderReference, contactUsDTO.getOrderReference());
        preencherCampo(inputMessage, contactUsDTO.getMessage());
        clicar(btnSend);

        assertEquals("Invalid email address.", lerTexto(msgErro));

    }

    @Test
    @Description(CT_CONTACT_US_04)
    public void testEnviarMensagemSemPreencherOCampoMessage(){
        /*CT004: Enviar mensagem sem preencher o campo "Message"
        DADO que estou na pagina inicial
        E clico no botão "Contact us"
        E seleciono uma opção no "Subject Heading"
        E preencho o campo e-mail corretamente
        E preencho o campo "Order reference" corretamente
        E deixo o campo "Message" em branco
        QUANDO clico no botão "Send"
        ENTÃO a mensagem "The message cannot be blank." deve ser exibida na tela.
        */
        ContactUsDTO contactUsDTO = contactUsData.contactUsValido();

        clicar(btnContactUs);
        selectPorIndex(selectSubjectHeading, contactUsDTO.getSubjectHeading());
        preencherCampo(inputEmailAddress, contactUsDTO.getEmailAddress());
        preencherCampo(inputOrderReference, contactUsDTO.getOrderReference());
        clicar(btnSend);

        assertEquals("The message cannot be blank.", lerTexto(msgErro));

    }

    @Test
    @Description(CT_CONTACT_US_05)
    public void testEnviarMensagemUtilizandoEmailInvalido(){
        /*CT005: Enviar mensagem utilizando e-mail inválido
        DADO que estou na pagina inicial
        E clico no botão "Contact us"
        E seleciono uma opção no "Subject Heading"
        E preencho o campo e-mail inválido (sem "@")
        E preencho o campo "Order reference" corretamente
        E preencho o campo "Message" corretamente
        QUANDO clico no botão "Send"
        ENTÃO a mensagem "Invalid email address." deve ser exibida na tela.
         */
        ContactUsDTO contactUsDTO = contactUsData.contactUsComEmailInvalido();

        clicar(btnContactUs);
        selectPorIndex(selectSubjectHeading, contactUsDTO.getSubjectHeading());
        preencherCampo(inputEmailAddress, contactUsDTO.getEmailAddress());
        preencherCampo(inputOrderReference, contactUsDTO.getOrderReference());
        preencherCampo(inputMessage, contactUsDTO.getMessage());
        clicar(btnSend);

        assertEquals("Invalid email address.", lerTexto(msgErro));

    }
}
