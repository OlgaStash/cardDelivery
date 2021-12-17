package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    public void shouldSetForm() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Киров");
        $(".calendar-input__custom-control").click();
        $$("[data-day]").get(1).click();
        $("[data-test-id='name'] input").setValue("Петров Петр");
        $("[data-test-id='phone'] input").setValue("+79875674356");
        $(".checkbox__box").click();
        $("[type='button'] [class=button__text]").click();
//        $("[data-test-id='notification']").shouldBe(appear);
        $("[class='notification__title']").shouldHave(exactText("Успешно!"));
        $("[class='notification__content']").shouldHave(text("Встреча успешно забронирована на " + $("[data-test-id=date] input").getValue()));
//        $(withText("Успешно!")).shouldBe(Condition.appear, Duration.ofSeconds(5));
//        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на"));
    }
}
