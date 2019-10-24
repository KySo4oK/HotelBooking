import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class Category {
    private String name;
    private ArrayList<Room> availableRooms;
}
