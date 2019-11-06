import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;


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
    private Set<Order> orders;
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Room))
            return false;
        Room other = (Room) obj;
        return this.number.intValue() == other.number.intValue();
    }

    @Override
    public int hashCode() {
        return number.intValue();
    }
}
