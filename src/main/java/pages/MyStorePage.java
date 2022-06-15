package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyStorePage {

    public SelenideElement searchInput() {
        return $("#search_block_top").as("строка поиска");
    }

    public SelenideElement productBlock() {
        return $("#homefeatured").as("раздел с товарами");
    }

    public SelenideElement addToCardButton() {
        return $("[data-id-product='2']").as("кнопка добавления в корзину");
    }

    public SelenideElement addProductModal() {
        return $(".layer_cart_product").as("модальное окно добавления в корзину");
    }

    public SelenideElement loginButton() {
        return $(".login").as("кнопка 'Sign In'");
    }

    public SelenideElement emailInput() {
        return $("#email").as("поле ввода email");
    }

    public SelenideElement passwordInput() {
        return $("#passwd").as("поле ввода пароля");
    }

    public SelenideElement myAccountText() {
        return $(".page-heading").as("текст 'My Account'");
    }

    public SelenideElement mySettingsButton() {
        return $(".icon-user").as("кнопка 'My personal information'");
    }

    public SelenideElement oldPasswordInput() {
        return $("#old_passwd").as("поле ввода старого пароля");
    }

    public SelenideElement newPasswordInput() {
        return $("#passwd").as("поле ввода нового пароля");
    }

    public SelenideElement confirmationPasswordInput() {
        return $("#confirmation").as("поле ввода подтверждения нового пароля");
    }

    public SelenideElement saveButton() {
        return $("[name='submitIdentity']").as("кнопка 'Сохранить'");
    }

    public SelenideElement alertText() {
        return $(".alert-danger").as("сообщение о неуспешной смене пароля");
    }

    public SelenideElement submitButton() {
        return $("#SubmitLogin").as("кнопка входа");
    }

    public SelenideElement logoutButton() {
        return $(".logout").as("кнопка выхода");
    }

    public SelenideElement deleteButton() {
        return $(".cart_delete.text-center").as("кнопка удаления на странице чекаута");
    }

    public SelenideElement checkoutButton() {
        return $(".button-medium").as("кнопка перехода в чекаут");
    }
}
