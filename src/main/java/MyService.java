import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface MyService {
    void viewRoomsByCategory(Category category);
    void book(Date startDate, Date endDate);
    int getTotalPrice(Room currentRoom, Date startDate, Date endDate);
    List<Room> getAllRooms();
    List<Category> getAllCategories();
    List<AdditionalOption> getAllAdditionalOptions();
}
