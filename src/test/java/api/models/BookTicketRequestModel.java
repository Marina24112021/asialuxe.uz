package api.models;

import api.models.components.PassengersComponent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookTicketRequestModel {
    private String full_name;
    private String email;
    private String phone;
    private String reservation_id;
    private int product_id;
    private String comment;
    private List<PassengersComponent> passengers;
    private List<String> tariff;
    private String promoCode;

}
