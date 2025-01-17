package api.models.passangers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePassengerRequestModel {
    private String middle_name,
            first_name,
            last_name,
            country_birth,
            gender,
            citizenship,
            number,
            place_birth,
            type,
            shen_gen_status,
            series,
            email,
            birth,
            expire,
            given_date;
    private Integer document_issue_date,
            created_at,
            updated_at,
            created_by,
            updated_by,
            user_id,
            id;
}
