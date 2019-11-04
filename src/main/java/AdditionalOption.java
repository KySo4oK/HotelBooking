import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "additional_options")
public class AdditionalOption {
    @Id
    @Column(name="option_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer optionID;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
}
