import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Room> availableRooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableRooms(ArrayList<Room> availableRooms) {
        this.availableRooms = availableRooms;
    }

    public ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }
}
