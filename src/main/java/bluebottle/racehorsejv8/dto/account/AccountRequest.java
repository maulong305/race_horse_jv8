package bluebottle.racehorsejv8.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequest {
    private String username;
    private String password;
    private Long status;
}
