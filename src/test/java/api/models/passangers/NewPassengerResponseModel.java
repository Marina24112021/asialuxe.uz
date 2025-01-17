package api.models.passangers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewPassengerResponseModel {
    private String code,
            message;
    private NewPassengerDataModel data;
}
