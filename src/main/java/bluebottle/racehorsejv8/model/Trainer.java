package bluebottle.racehorsejv8.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Account account;
}
