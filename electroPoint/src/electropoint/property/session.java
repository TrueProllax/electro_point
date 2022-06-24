
package electropoint.property;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.PersistenceUnitLoadingException;


public class session {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("electroPointPU");
    private static final EntityManager em = emf.createEntityManager();

    public EntityManager getEm() {
        return em;
    }

    public session() {
        
    }
    
}
