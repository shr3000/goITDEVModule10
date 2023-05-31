package planets;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;
    private String name;
    public Planet() {}
    public Planet(String id, String name) {
        setId(id);
        this.name = name;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id can't be null");
        }
        if (id.length() < 1 || id.length() > 500) {
            throw new IllegalArgumentException("id length must be between 1 and 500");
        }
        if (!id.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("id must contain only uppercase letters and digits");
        }
        this.id = id;
    }
}
