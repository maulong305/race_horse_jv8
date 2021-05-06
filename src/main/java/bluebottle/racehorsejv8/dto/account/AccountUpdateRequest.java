package bluebottle.racehorsejv8.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountUpdateRequest extends AccountRequest{
    private Long id;

}
