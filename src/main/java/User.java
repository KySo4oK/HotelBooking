import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Setter
@Getter
public class User {
    private String userPassword;
    private String userLogin;
    private Hotel hotel;
    private ArrayList<Order> userOrders;
}
