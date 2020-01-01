import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter



public class Hotel implements MyService{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT_NAME");
    private static EntityManager em = getEntityManager();

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

    @Override
    public List<Room> getAllRooms() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> rootEntry = cq.from(Room.class);
        CriteriaQuery<Room> all = cq.select(rootEntry);

        TypedQuery<Room> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public List<Category> getAllCategories() {
        return em.createQuery("SELECT a FROM Category a", Category.class).getResultList();
    }

    @Override
    public List<AdditionalOption> getAllAdditionalOptions() {
        return em.createQuery("SELECT a FROM AdditionalOption a", AdditionalOption.class).getResultList();
    }

    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
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

    public void addBook(Order order){
        bookings.add(order);
    }

    public void viewRoomsByCategory(Category category) {
        category.getAvailableRooms();
    }
}
