package api.models.passangers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassengerDataModel {
    Integer code;
    String message;
    PassengerInfoDataModel data;
}
