package webmarket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import model.Store;
import model.BonusCheck;
import model.Customer;
import model.Product;
import model.Purchase;
import model.StoreProduct;
import model.ProductPurchase;



public class TestingQueries {
    
    private static EntityManager em;
    private static javax.persistence.Query query1;
   
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        em = emf.createEntityManager(); 
         
        query1 = em.createQuery("SELECT s FROM Store s WHERE s.storeId = :storeId");
        query1.setParameter("storeId", 1);
        List<Store> delstlist = query1.getResultList();
        Store delStore = delstlist.get(0);
        
        query1.setParameter("storeId", 3);
        List<Store> stlist = query1.getResultList();
        Store tempStore = stlist.get(0);
        
        if (tempStore.getPurchaseList().size() >0) {
            for (Purchase pu : tempStore.getPurchaseList()) {
                pu.setStoreId(delStore);
                em.persist(pu);
            }
            tempStore.setPurchaseList(null);
        }
        Store temp = em.merge(tempStore);
        em.remove(temp);     
        em.getTransaction().begin();
        em.getTransaction().commit();        
    }
}