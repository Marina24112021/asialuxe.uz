package tests.api;

import api.models.passangers.ListOfPassengerDataModel;
import api.models.passangers.ListOfPassengersResponseModel;
import api.models.passangers.NewPassengerResponseModel;
import api.passangers.Passengers;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static api.passangers.Passengers.deletePassenger;
import static api.passangers.Passengers.updatePassenger;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;
import static specs.CodeAsiaLuxeSpec.failResponse402Spec;
import static specs.CodeAsiaLuxeSpec.successfulResponse200Spec;

@Owner("Marina Chen")
@Tag("api")
public class PassengerTest {
    @Test
    @DisplayName("Создать пассажира на странице Мой Профиль->Пассажиры")
    void positiveCreatePassengerTest() {
        NewPassengerResponseModel response = step("Создать пассажира", Passengers::createPassenger);
        Integer newId = response.getData().getId();
        ListOfPassengersResponseModel responseList = step("Получить полный список Ids пассажиров", Passengers::getListOfPassengers);
        List<ListOfPassengerDataModel> passengers = responseList.getData();
        List<Integer> ids = new ArrayList<>();
        for (ListOfPassengerDataModel passenger : passengers) {
            ids.add(passenger.getData().getId());
        }
        step("Созданный пассажир успешно найден в списке ", () -> assertTrue(ids.contains(newId)));
    }

    @Test
    @DisplayName("Удаление пассажира на странице Мой Профиль->Пассажиры")
    void positiveDeletePassengerTest() {
        NewPassengerResponseModel response = step("Создать пассажира", Passengers::createPassenger);
        Integer newId = response.getData().getId();
        step("Удалить пассажира", () -> deletePassenger(newId, successfulResponse200Spec));
        ListOfPassengersResponseModel responseList = step("Получить полный список Ids пассажиров", Passengers::getListOfPassengers);
        List<ListOfPassengerDataModel> passengers = responseList.getData();
        List<Integer> ids = new ArrayList<>();
        for (ListOfPassengerDataModel passenger : passengers) {
            ids.add(passenger.getData().getId());
        }
        step("Пассажир успешно удален. Пассажир не найден в списке", () -> assertFalse(ids.contains(newId)));
    }

    @Test
    @DisplayName("Редактирование данных пассажира")
    void positiveUpdatePassengerTest() {
        NewPassengerResponseModel response = step("Создать пассажира", Passengers::createPassenger);
        step("Обновить данные пассажира", () -> updatePassenger(response));
        step("Данные пассажира успешно обновлены", () -> assertEquals("success", response.getMessage()));
    }

    @Test
    @DisplayName("Удаление несуществующего пассажира")
    void negativeDeletePassengerTest() {
        Integer fakePassengerId = 0;
        Response response = step("Удалить пассажира с несуществующим Id ", () -> deletePassenger(fakePassengerId, failResponse402Spec));
        step("Отображается код ошибки и ошибка, а так же тип ошибки", () -> {
            assertEquals("404", response.jsonPath().getString("status"));
            assertEquals("Not Found", response.jsonPath().getString("name"));
            assertEquals("yii\\web\\NotFoundHttpException", response.jsonPath().getString("type"));
        });
    }
}
