package api.models.passangers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListOfPassengerDataModel {
    Integer code;
    String message;
    ListOfPassengersDataModel data;
}
