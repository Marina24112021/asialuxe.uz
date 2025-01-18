package api.models.prebookTour;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrebookTourRequestModule {
    Integer type,
            adults,
            childs;
    String tour_price,
            avia_price,
            total_price,
            date_from,
            date_to,
            star,
            from,
            to,
            tour_name;
    @JsonProperty("class")
    String class_fl;
    Boolean info_tour,
            umra_status;
}
