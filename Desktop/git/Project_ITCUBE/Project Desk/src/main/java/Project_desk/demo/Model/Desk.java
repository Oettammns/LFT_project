package Project_desk.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "desk")
public class Desk {

    @Id
    private long id;
    @Column(name = "pos_x")
    private int pos_x;
    @Column(name = "pos_y")
    private int pos_y;


    public Desk() {
    }

    public long getId() {
        return id;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
}
