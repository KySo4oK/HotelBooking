import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Column(name = "user_id")
    private int userID;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "login")
    private String userLogin;
    private Hotel hotel;
    private ArrayList<Order> userOrders;
}
