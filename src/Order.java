import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {
    public Room room;
    User user;
    public Category category;
    public ArrayList<AdditionalOption> selectedAdditionalOptions;
    public Date startDate;
    public Date endDate;
    private int days;
    public int totalPrice;
    public int getTotalPrice(){
        totalPrice = 0;
        for(int i = 0; i < selectedAdditionalOptions.size(); i++){
            totalPrice += selectedAdditionalOptions.get(i).price;
        }
        return totalPrice /*+ room.getPrice()*(getDays())*/;
    }

    public long getDays() {
        long days = TimeUnit.DAYS.convert(endDate.getTime() -
                startDate.getTime(), TimeUnit.MILLISECONDS);
        return days;
    }
}
