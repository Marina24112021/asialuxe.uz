package api.models.authorization;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorizationDataModel {
    Integer user_id;
    String token,
            expire;
    Integer id;
}
