import java.util.ArrayList;
import java.util.Date;

public class Room {
    private int number;
    private Category category;
    private int price;
    private ArrayList<AdditionalOption> availableAdditionalOptions;
    private ArrayList<Order> bookings;

    public int getPrice() {
        return price;
    }

    public ArrayList<Order> getBookings() {
        return bookings;
    }

    public Category getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<AdditionalOption> getAvailableAdditionalOptions() {
        return availableAdditionalOptions;
    }

    public void setAvailableAdditionalOptions(ArrayList<AdditionalOption> availableAdditionalOptions) {
        this.availableAdditionalOptions = availableAdditionalOptions;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookings(ArrayList<Order> bookings) {
        this.bookings = bookings;
    }
}
