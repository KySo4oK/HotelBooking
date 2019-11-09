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
        User other = (User) obj;
        return this.userID.intValue() == other.userID.intValue();
    }

    @Override
    public int hashCode() {
        return userID;
    }
}
