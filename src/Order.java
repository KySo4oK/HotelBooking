import java.util.ArrayList;
import java.util.Date;

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
    private Room room;
    private User user;
    private Category category;
    private ArrayList<AdditionalOption> selectedAdditionalOptions;
    private Date startDate;
    private Date endDate;
    private int days;
    private int totalPrice;

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Category getCategory() {
        return category;
    }

    public ArrayList<AdditionalOption> getSelectedAdditionalOptions() {
        return selectedAdditionalOptions;
    }

    public void setSelectedAdditionalOptions(ArrayList<AdditionalOption> selectedAdditionalOptions) {
        this.selectedAdditionalOptions = selectedAdditionalOptions;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDays() {
        return days;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
