package api.models.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataOfOrderDetailComponent {
    Integer id,
            user_id,
            agent_id,
            sub_agent_id,
            status,
            status_pay;
    Double price;
    String skit_for_agent;
    Integer tariff_price;
    String currency;
    Integer all_pax;
    @JsonProperty("class")
    String type_of_class;
    String debt;
    String email,
            phone,
            full_name,
            created_at,
            updated_at,
            created_by,
            updated_by;
    Integer product_id,
            provider_id;
    String provider_pnr;
    Integer provider_order_id;
    String provider_order_status;
    String payment_provider;
    Double price_usd;
    String comment;
    Integer parent_id;
    String promo_code,
            discount_value,
            discount_type,
            seat_data;
    @JsonProperty("passengers")
    List<PassengersOfOrderComponent> passengers;
}
