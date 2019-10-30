import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer orderID;
    @Column(name = "room_id")
    private Integer room_id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "category")
    private Integer category_id;
    @OneToMany(mappedBy = "order")
    private Set<OrderAdditionalOption> selectedAdditionalOptions;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    private Integer days;
    @Column(name = "totalPrice")
    private Integer totalPrice;
}
