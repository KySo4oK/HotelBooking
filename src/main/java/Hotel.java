import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Setter
@Getter


public class Hotel implements MyService {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT_NAME");
    private static EntityManager em = getEntityManager();

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

    public void book(Date startDate, Date endDate, User currentUser) {
        List<Room> availableRooms = getAllRooms();
        for (int i = 0; i < availableRooms.size(); i++) {
            if (!checkDates(availableRooms.get(i), startDate, endDate)) {
                availableRooms.remove(availableRooms.get(i));
            }
        }
        Room room = chooseRoom(availableRooms);
        Order order = new Order();// need add variables
        Set<Order> userOrders = currentUser.getOrders();
        userOrders.add(order);
        currentUser.setOrders(userOrders);
        addBook(order);
    }

    private Room chooseRoom(List<Room> availableRooms) {// need to rewrite
        return null;
    }

    private void viewBookings(User currentUser) { //show all bookings, need to rewrite in next stage
        Set<Order> userOrders = currentUser.getOrders();
        Object[] userOrdersArray = userOrders.toArray();
        for (int i = 0; i < userOrdersArray.length; i++) {
            System.out.println(userOrdersArray[i]);
        }
    }

    private boolean checkDates(Room room, Date startDate, Date endDate) {
        Set<Order> bookings = room.getOrders();
        for (Iterator<Order> it = bookings.iterator(); it.hasNext(); ) {
            Order book = it.next();
            if (!(book.getStartDate().getTime() < startDate.getTime()
                    && book.getEndDate().getTime() < endDate.getTime())) {
                return false;
            }
        }
        return true;
    }

    public int getTotalPrice(Room currentRoom, Date startDate, Date endDate, Set selectedAdditionalOptions) {
        int totalPrice = 0;
        for (Iterator<AdditionalOption> it = selectedAdditionalOptions.iterator(); it.hasNext(); ) {
            totalPrice += it.next().getPrice();
        }
        return totalPrice + currentRoom.getPrice() * (getQuantityOfDays(startDate, endDate));
    }

    public int getQuantityOfDays(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() -
                startDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    public void addBook(Order order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public void viewRoomsByCategory(Category category) { // rewrite later
        getAllRooms();
    }
}
