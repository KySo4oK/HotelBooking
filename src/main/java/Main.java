import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory emf;
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        System.out.println(hotel.getAllAdditionalOptions().get(0).getName());
//        emf = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT_NAME");
//        EntityManager em = getEntityManager();
//        AdditionalOption additionalOption = getAddOP();
//        additionalOption.setPrice(11);
//        additionalOption.setOptionID(1);
//        additionalOption.setName("good");
//        em.getTransaction().begin();
//        em.merge(additionalOption);
//        em.getTransaction().commit();

    }
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static AdditionalOption getAddOP(){
        return new AdditionalOption();
    }
}
