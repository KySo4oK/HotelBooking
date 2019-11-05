import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer userID;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "login")
    private String userLogin;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        return (this.userLogin == null && other.userLogin == null)
                || (this.userLogin != null && this.userLogin.equals(other.userLogin));
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (userLogin != null) {
            result = 31 * result + userLogin.hashCode();
        }
        if (userPassword != null) {
            result = 31 * result + userLogin.hashCode();
        }
        if (userID != null) {
            result = 31 * result + userLogin.hashCode();
        }
        return result;
    }
}
