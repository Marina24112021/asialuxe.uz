package tests.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchFreeRoomRequestModel {
    String hotel_id,
            begin_date,
            end_date,
            currency;
    Integer adult;
    List<Integer> child_age;
    Integer product_id;
    String type,
            lang,
            transfer,
            insurance;
}
