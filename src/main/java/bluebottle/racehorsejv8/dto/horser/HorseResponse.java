package bluebottle.racehorsejv8.dto.horser;

import bluebottle.racehorsejv8.model.Account;
import bluebottle.racehorsejv8.model.Horse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class HorseResponse {
    private Long id;
    private String name;
    private Date foaled;
    private String color;
    private Set<Account> accounts;

    public HorseResponse(Horse horse) {
        BeanUtils.copyProperties(horse, this);
    }
}
