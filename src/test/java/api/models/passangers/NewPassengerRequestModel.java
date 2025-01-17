package api.models.passangers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewPassengerRequestModel {
    private String middle_name,
            first_name,
            last_name,
            country_birth,
            gender,
            citizenship,
            number,
            place_birth;
    private Integer save;
    private String type;
}
