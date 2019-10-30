import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "rooms")

public class Room {
    @Id
    @Column(name="number")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer number;
    @Column(name = "category_id")
    private Integer category_id;
    @Column(name = "price")
    private Integer price;
}
