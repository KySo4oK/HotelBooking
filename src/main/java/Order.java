import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Room room;
    private User user;
    private Category category;
    private ArrayList<AdditionalOption> selectedAdditionalOptions;
    private Date startDate;
    private Date endDate;
    private int days;
    private int totalPrice;
}
