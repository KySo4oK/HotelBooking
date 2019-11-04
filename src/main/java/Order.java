import lombok.*;
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
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    private Set<AdditionalOption> AdditionalOptions;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Transient
    @Setter(AccessLevel.NONE)
    private Integer days;
    @Column(name = "totalPrice")
    private Integer totalPrice;
}
