import java.util.ArrayList;
import java.util.Date;

interface MyService {
    String echo (String message);
}

public class Hotel implements MyService{
    private ArrayList<User> users;
    private User currentUser;
    private ArrayList<AdditionalOption> additionalOptions;
    private ArrayList<Room> rooms;
    private ArrayList<Category> categories;
    private ArrayList<Order> bookings;
    private ArrayList<AdditionalOption> selectedAdditionalOptions;

    public String echo (String message) {
        return message;
    }

    void viewRoomsByCategories(Category category){
        category.getAvailableRooms();
    }

    public void book(Date startDate, Date endDate){
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

    public ArrayList<Room> getRooms() { // view all available rooms
        return rooms;
    }

    public ArrayList<Order> getBookings(){
        return bookings;
    }

    public void addBook(Order order){
        bookings.add(order);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setBookings(ArrayList<Order> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<AdditionalOption> getAdditionalOptions() {
        return additionalOptions;
    }

    public void setAdditionalOptions(ArrayList<AdditionalOption> additionalOptions) {
        this.additionalOptions = additionalOptions;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<AdditionalOption> getSelectedAdditionalOptions() {
        return selectedAdditionalOptions;
    }

    public void setSelectedAdditionalOptions(ArrayList<AdditionalOption> selectedAdditionalOptions) {
        this.selectedAdditionalOptions = selectedAdditionalOptions;
    }
}
