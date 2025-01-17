package api.models.searchTicket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTicketResponseModel {
    String code,
            message;
    SearchTicketDataModel data;
}
