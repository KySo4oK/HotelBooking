import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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
    private int orderID;
    @Column(name = "room_id")
    private int room_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "category")
    private int category_id;
    @OneToMany(mappedBy = "order")
    private Set<OrderAdditionalOption> selectedAdditionalOptions;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    private int days;
    @Column(name = "totalPrice")
    private int totalPrice;
}
