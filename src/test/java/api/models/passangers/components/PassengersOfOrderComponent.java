package api.models.passangers.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PassengersOfOrderComponent {
    private Integer id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String birth;
    private String gender;
    private String citizenship;
    private String document_type;
    private String document_number;
    private String document_expire;
    private String email;
    private String phone;
    private Integer order_id;
    private String type;
}
