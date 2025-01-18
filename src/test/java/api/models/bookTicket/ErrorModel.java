package api.models.bookTicket;

import api.models.bookTicket.components.TypeOfErrorPhoneComponents;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorModel {
    String code,
    message;
    TypeOfErrorPhoneComponents errors;
}
