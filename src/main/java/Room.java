import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "rooms")

public class Room {
    @Column(name = "number")
    private int number;
    @Column(name = "category_id")
    private Category category;
    @Column(name = "price")
    private int price;
    private ArrayList<AdditionalOption> availableAdditionalOptions;
    private ArrayList<Order> bookings;
}
