package tikets;
/*
id - ідентифікатор квитка, первинний сурогатний ключ, автоінкрементне число.
created_at - TIMESTAMP в UTC, коли був створений цей квиток
client_id - ідентифікатор клієнта, якому належить цей квиток.
from_planet_id - ідентифікатор планети, звідки відправляється пасажир
to_planet_id - ідентифікатор планети, куди летить пасажир
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "tikets")
@Entity
@Data
@NoArgsConstructor
public class Tiket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private long created_at;
    @Column
    private int client_id;
    @Column
    private int from_planet_id;
    @Column
    private int to_planet_id;

    public Tiket(int id, long created_at, int client_id, int from_planet_id, int to_planet_id) {
        this.id = id;
        this.created_at = created_at;
        this.client_id = client_id;
        this.from_planet_id = from_planet_id;
        this.to_planet_id = to_planet_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public int getClient_id() {
        return client_id;
    }

}
