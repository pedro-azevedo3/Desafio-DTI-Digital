package automationpractice.page;

import org.openqa.selenium.By;

public class ContactUsPage {
    public static final By btnContactUs = By.cssSelector("#contact-link > a");
    public static final By selectSubjectHeading = By.cssSelector("#id_contact");
    public static final By inputEmailAddress = By.cssSelector("#email");
    public static final By inputOrderReference = By.cssSelector("#id_order");
    public static final By inputMessage = By.cssSelector("#message");
    public static final By btnSend = By.cssSelector("#submitMessage");
    public static final By msgSuccess = By.cssSelector("#center_column > p");
    public static final By msgErro = By.cssSelector("#center_column > div > ol > li");
}
