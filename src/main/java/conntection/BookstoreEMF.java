package conntection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookstoreEMF {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstore16jpa");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();

    }
}
