import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("LyaylyaMiftakhova")

public class MyStoreTest {

    @BeforeEach
    public void setup() {
        open("http://automationpractice.com/index.php");
        TestPages.myStorePage.searchInput()
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void addToCartTest() {
        step("Нажать на кнопку быстрого добавления в корзину и проверить сообщение об успешном добавлении", () -> {
            TestPages.myStorePage.productBlock()
                    .scrollTo();
            TestPages.myStorePage.addToCardButton()
                    .click();
            TestPages.myStorePage.addProductModal()
                    .shouldBe(visible)
                    .shouldHave(text("Product successfully added to your shopping cart"));
        });

        step("Перейти в чекаут и проверить наличие добавленного товара", () -> {
            TestPages.myStorePage.checkoutButton()
                    .click();
            TestPages.myStorePage.deleteButton()
                    .shouldBe(visible);
        });
    }

    @MethodSource("passwordChecks")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Негативные кейсы для смены пароля")
    public void passwordСhangeTest(String type, String oldPassword, String newPassword) {
        step("Авторизоваться и проверить вход в аккаунт", () -> {
            TestPages.myStorePage.loginButton()
                    .click();
            TestPages.myStorePage.emailInput()
                    .sendKeys("natli.d26.l8@gmail.com");
            TestPages.myStorePage.passwordInput()
                    .sendKeys("123456789");
            TestPages.myStorePage.submitButton()
                    .scrollTo()
                    .click();
            TestPages.myStorePage.myAccountText()
                    .shouldBe(visible);
        });

        step("Перейти в настройки аккаунта", () -> {
            TestPages.myStorePage.mySettingsButton()
                    .click();
            TestPages.myStorePage.oldPasswordInput()
                    .scrollTo()
                    .shouldBe(visible);
        });

        step("Ввести данные для смены пароля и проверить, что пароль не изменился", () -> {
            TestPages.myStorePage.oldPasswordInput()
                    .scrollTo()
                    .shouldBe(visible);
            TestPages.myStorePage.oldPasswordInput()
                    .sendKeys(oldPassword);
            TestPages.myStorePage.newPasswordInput()
                    .sendKeys(newPassword);
            TestPages.myStorePage.confirmationPasswordInput()
                    .sendKeys(newPassword);
            TestPages.myStorePage.saveButton()
                    .click();
            TestPages.myStorePage.alertText()
                    .shouldBe(visible)
                    .shouldHave(text("There is 1 error"));
        });

        step("Выйти из аккаунта", () -> {
            TestPages.myStorePage.logoutButton()
                    .click();
            TestPages.myStorePage.emailInput()
                    .shouldBe(visible);
        });

    }

    static Stream<Arguments> passwordChecks() {
        return Stream.of(
                arguments(
                        "неверный старый пароль",
                        "rfreferfefr",
                        "fvfvfvf56"
                ),
                arguments(
                        "несовпадающие пароли",
                        "ываываы@mail.ru",
                        "vfvfddd43"
                ),
                arguments(
                        "незаполненный пароль",
                        " ",
                        "rererer12"
                )
        );
    }
}
