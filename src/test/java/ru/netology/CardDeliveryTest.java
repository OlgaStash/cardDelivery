package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    String planningDate = generateDate(3);

    @Test
    public void shouldSetForm() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Киров");
        $(".calendar-input__custom-control").click();
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue("Петров Петр");
        $("[data-test-id='phone'] input").setValue("+79875674356");
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Успешно"));
        $("[class='notification__content']").shouldHave(text("Встреча успешно забронирована на " + planningDate));
    }
}
