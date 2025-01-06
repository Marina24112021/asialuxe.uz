package tests.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchTicketDirectionsModel {
    private String dep_type,
            arr_type,
            departure_code,
            arrival_code,
            date;

}
