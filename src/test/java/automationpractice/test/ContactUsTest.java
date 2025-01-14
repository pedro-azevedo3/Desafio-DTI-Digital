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
