package automationpractice.factory.data;

import automationpractice.dto.CadastroDTO;
import com.github.javafaker.Faker;

public class CadastroData {

    private static final Faker faker = new Faker();

    public CadastroDTO cadastro(){
        return new CadastroDTO(
                faker.internet().emailAddress(),
                1,
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().password(),
                1,
                1,
                2000
        );
    }
}
