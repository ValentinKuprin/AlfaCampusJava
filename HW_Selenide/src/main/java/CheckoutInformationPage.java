import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutInformationPage {
    private final SelenideElement firstNameInput = $x("//input[@id='first-name']");
    private final SelenideElement lastNameInput = $x("//input[@id='last-name']");
    private final SelenideElement zipPostalCodeInput = $x("//input[@id='postal-code']");
    private final SelenideElement continueButton = $x("//input[@id='continue']");
    private final SelenideElement errorMessageEmptyInputField = $x("//h3[@data-test='error']");

    private CheckoutInformationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    private CheckoutInformationPage setLastname(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    private CheckoutInformationPage setZipPostalCode(String zipPostalCode) {
        zipPostalCodeInput.setValue(zipPostalCode);
        return this;
    }

    private void clickContinueButton() {
        continueButton.click();
    }

    public CheckoutOverviewPage addYourInformation(String firstName, String lastName, String zipPostalCode) {
        this.setFirstName(firstName)
                .setLastname(lastName)
                .setZipPostalCode(zipPostalCode)
                .clickContinueButton();
        return new CheckoutOverviewPage();
    }

    public void addYourInformationWithoutFirstName(String lastName, String zipPostalCode) {
        this.setLastname(lastName)
                .setZipPostalCode(zipPostalCode)
                .clickContinueButton();
    }

    public void addYourInformationWithoutLastName(String firstName, String zipPostalCode) {
        this.setFirstName(firstName)
                .setZipPostalCode(zipPostalCode)
                .clickContinueButton();
    }

    public void addYourInformationWithoutZipPostalCode(String firstName, String lastName) {
        this.setFirstName(firstName)
                .setLastname(lastName)
                .clickContinueButton();
    }

    public void checkErrorMessageDueToBlankFirstNameInForm() {
        errorMessageEmptyInputField.shouldBe(visible).shouldHave(exactText("Error: First Name is required"));
    }

    public void checkErrorMessageDueToBlankLastNameInForm() {
        errorMessageEmptyInputField.shouldBe(visible).shouldHave(exactText("Error: Last Name is required"));
    }

    public void checkErrorMessageDueToBlankZipPostalCodeInForm() {
        errorMessageEmptyInputField.shouldBe(visible).shouldHave(exactText("Error: Postal Code is required"));
    }
}
