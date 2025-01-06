package tests.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import tests.api.models.components.DataOfOrdersComponent;
import tests.api.models.components.MetaOfOrderComponent;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderIdResponseModel {
    Integer code;
    String message;
    List<DataOfOrdersComponent> data;
    MetaOfOrderComponent meta;
}
