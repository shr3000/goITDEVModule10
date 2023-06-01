package planets;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Planet {

    @Id
    @Column(nullable = false, length = 50)
    private String id;

    @Column(length = 500)
    private String name;
}
