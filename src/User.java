import java.util.ArrayList;
import java.util.Date;

public class User {
    Hotel hotel;
    public ArrayList<Order> userOrders;
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
}
