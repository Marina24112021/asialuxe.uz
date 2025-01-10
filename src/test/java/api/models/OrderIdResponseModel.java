package api.models;

import api.models.components.DataOfOrdersComponent;
import api.models.components.MetaOfOrderComponent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderIdResponseModel {
    Integer code;
    String message;
    List<DataOfOrdersComponent> data;
    MetaOfOrderComponent meta;
}
