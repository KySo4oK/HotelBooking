import java.util.ArrayList;
import java.util.Date;

public class Room {
    public int number;
    public String category;
    private int price;
    public ArrayList<AdditionalOption> availableAdditionalOptions;
    public ArrayList<Order> bookings;

    public int getPrice() {
        return price;
    }
}
