package api.models.bookTicket.components;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataOfOrdersComponent {
    Integer code;
    String message;
    DataOfOrderDetailComponent data;
}
