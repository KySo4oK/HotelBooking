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

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof AdditionalOption))
            return false;
        AdditionalOption other = (AdditionalOption) obj;
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        return this.price.intValue() == other.price.intValue() && nameEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (price != null) {
            result = 31 * result + price.hashCode();
        }
        return result;
    }
}
