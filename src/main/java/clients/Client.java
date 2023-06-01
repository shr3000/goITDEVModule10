package clients;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(length = 300)
    private String name;
}
