package automationpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactUsDTO {
    private Integer subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String message;
}
