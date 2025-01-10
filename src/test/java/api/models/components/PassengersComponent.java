package api.models.components;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PassengersComponent {
    private String type;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String birth;
    private String gender;
    private String citizenship;
    private String document_number;
    private String document_expire;
    private int save,
            index;

}