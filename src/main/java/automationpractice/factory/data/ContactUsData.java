package automationpractice.factory.data;

import automationpractice.dto.ContactUsDTO;
import com.github.javafaker.Faker;

public class ContactUsData {

    private static final Faker faker = new Faker();

    public ContactUsDTO contactUsValido(){
        return new ContactUsDTO(
                2,
                faker.internet().emailAddress(),
                faker.commerce().promotionCode(),
                faker.lorem().sentence()
        );
    }

    public ContactUsDTO contactUsComEmailInvalido(){
        return new ContactUsDTO(
                2,
                faker.internet().emailAddress().split("@")[0],
                faker.commerce().promotionCode(),
                faker.lorem().sentence()
        );
    }
}
