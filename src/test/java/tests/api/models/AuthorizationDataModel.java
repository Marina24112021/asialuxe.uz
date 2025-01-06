package tests.api.models;

import lombok.Data;

@Data
public class AuthorizationDataModel {
    Integer user_id;
    String token,
            expire;
    Integer id;
}
