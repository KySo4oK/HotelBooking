import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Room> rooms;
    public ArrayList<Category> categories;
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

}
