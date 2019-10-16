import java.util.ArrayList;
import java.util.Date;

public class User {
    private String userPassword;
    private String userLogin;
    private Hotel hotel;
    private ArrayList<Order> userOrders;
    public void book(Date startDate, Date endDate){
        ArrayList<Room> availableRooms = hotel.getRooms();
        for(int i = 0; i < availableRooms.size(); i++){
            if(!checkDates(availableRooms.get(i),startDate,endDate)){
                availableRooms.remove(availableRooms.get(i));
            }
        }
        Room room = chooseRoom(availableRooms);
        Order order = new Order();// need add variables
        userOrders.add(order);
        hotel.addBook(order);
    }
    private Room chooseRoom(ArrayList<Room> availableRooms){// need to rewrite
        return null;
    }
    private void viewBookings(){ //show all bookings, need to rewrite in next stage
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

    public ArrayList<Order> getUserOrders() {
        return userOrders;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setUserOrders(ArrayList<Order> userOrders) {
        this.userOrders = userOrders;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
