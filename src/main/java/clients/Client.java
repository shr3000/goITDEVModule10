package clients;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Client")
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private long id;

    @Column()
    private String name;
}
