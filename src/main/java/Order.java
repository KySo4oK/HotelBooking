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
    @JoinTable(
            name = "orderAdditionalOptions",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "additionalOptions_id"))
    private Set<AdditionalOption> additionalOptions;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startDate")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endDate")
    private Date endDate;
    @Transient
    @Setter(AccessLevel.NONE)
    private Integer days;
    @Column(name = "totalPrice")
    private Integer totalPrice;
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Order))
            return false;
        Order other = (Order) obj;
        if (!(this.room.equals(other.room)) ||
                !(this.user.equals(other.user)) ||
                !(this.additionalOptions.equals(other.additionalOptions)) ||
                !(this.endDate.equals(other.endDate)) ||
                !(this.startDate.equals(other.startDate))){
            return false;
        }
        return this.totalPrice.intValue() == other.totalPrice.intValue() &&
                this.orderID.intValue() == other.orderID.intValue();
    }

    @Override
    public int hashCode() {
        return orderID;
    }
}
