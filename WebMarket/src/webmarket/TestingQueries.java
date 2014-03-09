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
    private static javax.persistence.Query query2;
    private static javax.persistence.Query storeProductQuery;
    static List<Product> storeProductList;
    
    
    
   
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        em = emf.createEntityManager(); 
        
        query1 = em.createQuery("SELECT s FROM Store s WHERE s.storeId=:storeId");
        query1.setParameter("storeId", 3);
        List<Store> selectedStore = query1.getResultList();
        Store selStore = selectedStore.get(0);
        
        storeProductQuery = em.createQuery("SELECT s.productId FROM StoreProduct s WHERE s.storeId=:storeId").setParameter("storeId", selectedStore.get(0));
        storeProductList = storeProductQuery.getResultList();
      
//      query2 = em.createQuery("SELECT s FROM StoreProduct s JOIN Product p ON s.productId = p.productId WHERE s.storeId=:storeId");
//      query2 = em.createQuery("SELECT p FROM Product p JOIN s FROM StoreProduct s WHERE Store.Product s WHERE p.productId=:p.productId AND s.storeId=:storeId\");+ \" pproductId=selprods.productId");                
//      query2 = em.createQuery("SELECT p FROM Product p JOIN selprods WHERE pproductId=selprods.productId");        
//      query2 = em.createQuery("SELECT p FROM Product p JOIN StoreProduct s ON p.productId=s.productId WHERE s.storeId=:storeId");
//      query2.setParameter("storeId", selStore);

        
   query2 = em.createQuery("SELECT s.productId FROM StoreProduct s WHERE s.storeId=:storeId").setParameter("storeId", selStore);
      List<Product> selProduct = query2.getResultList();
        
        
 


//        Store delStore = delstlist.get(0);
//        
//        query1.setParameter("storeId", 3);
//        List<Store> stlist = query1.getResultList();
//        Store tempStore = stlist.get(0);

        System.out.println("\nΚατάστημα : " + selStore.getName() + ".\nΑρ. προϊόντων : " + selProduct.size()+ "\n");
        
        for (Product pr : selProduct) {
            System.out.println(pr.getName());
        }
        
        System.out.println("\nΚατάστημα : " + selStore.getName() + ".\nΑρ. προϊόντων : " + selProduct.size()+ "\n");
        
                
        for (Product pr : storeProductList) {
            System.out.println(pr.getName());
        }
        


//        if (tempStore.getPurchaseList().size() >0) {
//            for (Purchase pu : tempStore.getPurchaseList()) {
//                pu.setStoreId(delStore);
//                em.persist(pu);
//            }
//            tempStore.setPurchaseList(null);
//        }
//        Store temp = em.merge(tempStore);
//        em.remove(temp);     
//        em.getTransaction().begin();
//        em.getTransaction().commit();        

    
    
    
    }
}