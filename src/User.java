import java.util.ArrayList;
import java.util.Date;

public class User {
    private String userPassword;
    private String userLogin;
    private Hotel hotel;
    private ArrayList<Order> userOrders;

    public ArrayList<Order> getUserOrders() {
        return userOrders;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setUserOrders(ArrayList<Order> userOrders) {
        this.userOrders = userOrders;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
