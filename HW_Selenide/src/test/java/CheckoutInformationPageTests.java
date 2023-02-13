import org.junit.jupiter.api.Test;

public class CheckoutInformationPageTests {

    @Test
    void checkCheckoutPossibility() {
        /*
         * Проверка что есть возможность заполнить форму и продолжить оформление заказа
         * Нужно заполнить поля формы и выполнить нажатие на кнопку continue
         * Проверить что на странице CheckoutOverviewPage размер списка товаров = 6 (в пререквизите добавьте все 6 товаров)
         * */
    }

    @Test
    void checkErrorDueToBlankFirstNameInForm() {
        /*
         * Проверка что при пустом поле FirstName отдается соответствующая ошибка
         * */
    }

    @Test
    void checkErrorDueToBlankLastNameInForm() {
        /*
         * Проверка что при пустом поле LastName отдается соответствующая ошибка
         * */
    }

    @Test
    void checkErrorDueToBlankPostalCodeInForm() {
        /*
         * Проверка что при пустом поле PostalCode отдается соответствующая ошибка
         * */
    }
}
