package api.models.passangers;

import api.models.bookTicket.components.MetaOfOrderComponent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListOfPassengersResponseModel {
    List<PassengerDataModel> data;
    @JsonProperty("code")
    private Integer code_val;
    private String message;
    private MetaOfOrderComponent meta;
}
