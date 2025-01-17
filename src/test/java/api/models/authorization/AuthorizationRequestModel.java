package api.models.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationRequestModel {
    String phone_or_email, password;
}
