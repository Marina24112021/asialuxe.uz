package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckTariffModel {
    Integer product_id;
    String buy_id;
}
