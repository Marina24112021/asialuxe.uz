package api.models.authorization;

import lombok.Data;

@Data
public class AuthorizationResponseModel {
    String code, message;
    AuthorizationDataModel data;
}
