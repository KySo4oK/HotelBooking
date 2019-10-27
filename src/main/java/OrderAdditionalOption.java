import javax.persistence.*;

@Entity
@Table(name = "orderAdditionalOptions")
public class OrderAdditionalOption {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "additionaloptions_id")
    AdditionalOption additionalOption;
}
