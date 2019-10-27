import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
    private Room room;
    @Column(name = "user_id")
    private User user;
    @Column(name = "category")
    private Category category;
    private ArrayList<AdditionalOption> selectedAdditionalOptions;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    private int days;
    @Column(name = "totalPrice")
    private int totalPrice;
}
