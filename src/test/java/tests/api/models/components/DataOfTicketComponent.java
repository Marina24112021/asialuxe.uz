package tests.api.models.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataOfTicketComponent {
    Integer user_id,
            status,
            status_pay;
    Double price,
            tariff_price;
    String currency;
    Integer all_pax;
    @JsonProperty("class")
    String type_of_class;
    String email,
            phone,
            full_name;
    Integer product_id,
            provider_id,
            provider_order_id,
            provider_book_id,
            provider_buy_id;
    String provider_pnr;
    Integer provider_order_status,
            org_id;
    String platform;
    Double price_usd;
    String debt;
    String created_at,
            updated_at,
            created_by,
            updated_by,
            payment_provider,
            skit_for_agent,
            sub_agent_id,
            base;
    Integer id;
    String gds;
    String data_json,
            ex_value,
            ex_value_uzs,
            auth_token;
}
