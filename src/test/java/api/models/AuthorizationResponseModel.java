package api.models;

import lombok.Data;

@Data
public class AuthorizationResponseModel {
    String code, message;
    AuthorizationDataModel data;
}
