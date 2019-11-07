import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "categories")

public class Category {
    @Id
    @Column(name = "categories_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer categoryID;
    @Column(name = "name")
    private String name;
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Category))
            return false;
        Category other = (Category) obj;
        return (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name)
                && this.categoryID.intValue()==other.categoryID.intValue());
    }

    @Override
    public int hashCode() {
        return categoryID;
    }
}
