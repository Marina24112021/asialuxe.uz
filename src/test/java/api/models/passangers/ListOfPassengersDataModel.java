package api.models.passangers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListOfPassengersDataModel {
    Integer id,
            user_id;
    String shen_gen_status,
            first_name,
            last_name,
            middle_name,
            birth,
            gender,
            citizenship,
            series,
            number,
            expire,
            given_date,
            email,
            phone,
            type,
            document_type,
            whom_by,
            foreigner_document,
            place_issue_document,
            country_issue_document,
            document_issue_date,
            country_validity_document,
            country_birth,
            place_birth;
    Integer created_at,
            updated_at,
            created_by,
            updated_by;
}
