import java.util.ArrayList;
import java.util.Date;

public class Room {
    public int number;
    public String category;
    private int price;
    public ArrayList<AdditionalOption> availableAdditionalOptions;
    private ArrayList<Order> bookings;

    public int getPrice() {
        return price;
    }

    public ArrayList<Order> getBookings() {
        return bookings;
    }
}
