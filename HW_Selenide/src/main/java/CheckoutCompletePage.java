import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage {
    private final SelenideElement completeTitle = $x("//h2[@class='complete-header']");

    public void checkCompleteTitle() {
        completeTitle.shouldBe(visible).shouldHave(exactText("THANK YOU FOR YOUR ORDER"));
    }
}
