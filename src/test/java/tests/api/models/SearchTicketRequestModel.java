package tests.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchTicketRequestModel {
    Integer onlyCharter,
            product_id,
            adult_qnt,
            child_qnt,
            infant_qnt;
    @JsonProperty("class")
    String type_of_class;
    String currency;
    Integer in_one_days,
            charter_three_days,
            only_baggage,
            sorting_price;
    List<SearchTicketDirectionsModel> directions;
}
