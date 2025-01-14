package automationpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CadastroDTO {
    private String email;
    private int title;
    private String firstName;
    private String lastName;
    private String password;
    private int birthDay;
    private int birthMounth;
    private int birthYear;
}
