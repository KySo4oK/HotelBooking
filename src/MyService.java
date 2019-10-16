import java.util.ArrayList;
import java.util.Date;

public interface MyService {
    void viewRoomsByCategory(Category category);
    void book(Date startDate, Date endDate);
    int getTotalPrice(Room currentRoom, Date startDate, Date endDate);
}
