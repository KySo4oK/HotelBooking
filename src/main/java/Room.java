import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;


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
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy = "room")
    private List<Order> orders;
}
