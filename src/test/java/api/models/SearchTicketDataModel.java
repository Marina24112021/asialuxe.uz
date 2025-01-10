package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTicketDataModel {
    String request_id,
            expire,
            get_time;
    Integer limit;
}
