import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Category> categories;
    private ArrayList<Order> bookings;
    void viewRoomsByCategories(Category category){
        category.getAvailableRooms();
    }

    public ArrayList<Room> getRooms() { // view all available rooms
        return rooms;
    }
    public ArrayList<Order> getBookings(){
        return bookings;
    }
    public void addBook(Order order){
        bookings.add(order);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setBookings(ArrayList<Order> bookings) {
        this.bookings = bookings;
    }
}
