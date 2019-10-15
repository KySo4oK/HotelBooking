import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Room> rooms;
    public ArrayList<Category> categories;
    void viewRoomsByCategories(Category category){
        category.getAvailableRooms();
    }

    public ArrayList<Room> getRooms() { // view all available rooms
        return rooms;
    }
}
