package api.models.searchTicket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchTicketDataModel {
    String request_id,
            expire,
            get_time;
    Integer limit;
}
