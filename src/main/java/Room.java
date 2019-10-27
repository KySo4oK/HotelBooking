import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "rooms")

public class Room {
    @Id
    @Column(name="number")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int number;
    @Column(name = "category_id")
    private Category category;
    @Column(name = "price")
    private int price;
    private ArrayList<AdditionalOption> availableAdditionalOptions;
    private ArrayList<Order> bookings;
}
