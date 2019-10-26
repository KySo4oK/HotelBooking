import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "categories")

public class Category {
    @Column(name = "categories_id")
    private int categoryID;
    @Column(name = "name")
    private String name;
    private ArrayList<Room> availableRooms;
}
