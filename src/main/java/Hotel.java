import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter



public class Hotel implements MyService{
    private int id;
    private ArrayList<User> users;
    private User currentUser;
    private ArrayList<AdditionalOption> additionalOptions;
    private ArrayList<Room> rooms;
    private ArrayList<Category> categories;
    private ArrayList<Order> bookings;
    private ArrayList<AdditionalOption> selectedAdditionalOptions;

    @Override
    public void viewRoomsByCategory(Category category) {

    }

    @Override
    public void book(Date startDate, Date endDate) {

    }

    @Override
    public int getTotalPrice(Room currentRoom, Date startDate, Date endDate) {
        return 0;
    }

    /*public void book(Date startDate, Date endDate){
        ArrayList<Room> availableRooms = getRooms();
        for(int i = 0; i < availableRooms.size(); i++){
            if(!checkDates(availableRooms.get(i),startDate,endDate)){
                availableRooms.remove(availableRooms.get(i));
            }
        }
        Room room = chooseRoom(availableRooms);
        Order order = new Order();// need add variables
        ArrayList<Order> userOrders = currentUser.getUserOrders();
        userOrders.add(order);
        currentUser.setUserOrders(userOrders);
        addBook(order);
    }

    private Room chooseRoom(ArrayList<Room> availableRooms){// need to rewrite
        return null;
    }

    private void viewBookings(){ //show all bookings, need to rewrite in next stage
        ArrayList<Order> userOrders = currentUser.getUserOrders();
        for(int i = 0; i < userOrders.size(); i++){
            System.out.println(userOrders.get(i));
        }
    }

    private boolean checkDates(Room room, Date startDate, Date endDate){
        ArrayList<Order> bookings= room.getBookings();
        for(int i = 0; i < bookings.size(); i++){
            Order book = bookings.get(i);
            if(!(book.getStartDate().getTime() < startDate.getTime()
                    && book.getEndDate().getTime() < endDate.getTime())){
                return false;
            }
        }
        return true;
    }

    public int getTotalPrice(Room currentRoom, Date startDate, Date endDate){
        int totalPrice = 0;
        for(int i = 0; i < selectedAdditionalOptions.size(); i++){
            totalPrice += selectedAdditionalOptions.get(i).getPrice();
        }
        return totalPrice + currentRoom.getPrice()*(getQuantityOfDays(startDate,endDate));
    }

    public int getQuantityOfDays(Date startDate, Date endDate) {
        return (int)((endDate.getTime() -
                startDate.getTime())/(1000*60*60*24));
    }

    public void addBook(Order order){
        bookings.add(order);
    }

    public void viewRoomsByCategory(Category category) {
        category.getAvailableRooms();
    }

     */
}
