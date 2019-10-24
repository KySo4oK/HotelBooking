import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter

public class Room {
    private int number;
    private Category category;
    private int price;
    private ArrayList<AdditionalOption> availableAdditionalOptions;
    private ArrayList<Order> bookings;
}
