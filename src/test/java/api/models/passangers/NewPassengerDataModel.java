package api.models.passangers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewPassengerDataModel {
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
            phone,
            country_issue_document,
            country_validity_document,
            document_type,
            whom_by,
            foreigner_document,
            place_issue_document,
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
