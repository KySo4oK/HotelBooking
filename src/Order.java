import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {
    Order(){}
    Order(Room room, User user, Category category, Date startDate,
          Date endDate, ArrayList<AdditionalOption> selectedAdditionalOptions){
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.room = room;
        this.category = category;
        this.selectedAdditionalOptions = selectedAdditionalOptions;
    }
    public Room room;
    User user;
    public Category category;
    public ArrayList<AdditionalOption> selectedAdditionalOptions;
    private Date startDate;
    private Date endDate;
    private int days;
    public int totalPrice;
    public int getTotalPrice(){
        totalPrice = 0;
        for(int i = 0; i < selectedAdditionalOptions.size(); i++){
            totalPrice += selectedAdditionalOptions.get(i).price;
        }
        return totalPrice + room.getPrice()*(getDays());
    }

    public int getDays() {
        return (int)((endDate.getTime() -
                startDate.getTime())/(1000*60*60*24));
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
