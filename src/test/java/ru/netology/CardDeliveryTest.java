package ru.netology;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    public void shouldSetForm() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Киров");
        $(".calendar-input__custom-control").click();
        $$("[data-day]").get(2).click();
        $("[data-test-id='name'] input").setValue("Петров Петр");
        $("[data-test-id='phone'] input").setValue("+79875674356");
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(20)).shouldHave(text("Успешно"));
        $("[class='notification__content']").shouldHave(text("Встреча успешно забронирована на " + $("[data-test-id=date] input").getValue()));

    }
}
