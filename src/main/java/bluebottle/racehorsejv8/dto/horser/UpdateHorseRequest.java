package bluebottle.racehorsejv8.dto.horser;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateHorseRequest extends HorseRequest{
    private Long id;
}
