/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;
/**
 *
 * @author user0
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;
import model.Store;
import model.BonusCheck;
import model.Customer;
import model.Product;
import model.Purchase;
import model.StoreProduct;
import model.ProductPurchase;

public class Test1 {
    private static EntityManager em;
    private static javax.persistence.Query customersQuery;	
    private static javax.persistence.Query storesQuery;	
    private static javax.persistence.Query storeProductsQuery;	
    private static javax.persistence.Query productQuery;	
    static List<Customer> customersList;   
    static List<Store>    storesList;   
    static List<StoreProduct>  storeProductsList;   
    static List<Product>  productsList;   
//  static StoreProduct sp;   
    static int    value;
    static Random randCustomer;
    static Random randStore;
    static Random randProduct;
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        em = emf.createEntityManager(); 
        customersQuery = em.createQuery("SELECT c FROM Customer c");
        storesQuery    = em.createQuery("SELECT s FROM Store s");
        storeProductsQuery = em.createQuery("SELECT sp.productId FROM StoreProduct sp WHERE sp.storeId=:storeId");
        productQuery = em.createQuery("SELECT p FROM Product p WHERE p.productId = :productId");
// Διαβάζουμε τους πελάτες
        customersList = customersQuery.getResultList();
	int cCount    = customersList.size();
	randCustomer = new Random(); 
// Διαβάζουμε τα καταστηματα
	storesList = storesQuery.getResultList();
	int sCount = customersList.size();
	int pCount;
        int loopCustomers = cCount;
// Κάνουμε τόσες αγορές όσοι και οι πελάτες
	while (loopCustomers > 0) {
          value = randCustomer.nextInt(cCount) +1;	
	  Customer c = customersList.get(value);
       System.out.println(c);
// Για κάθε αγορά διαλέγουμε στην τύχη ένα κατάστημα
	  randStore = new Random(); 
          value = randStore.nextInt(sCount) +1;	
	  Store s = storesList.get(value);
       System.out.println(s);
// Για κάθε κατάστημα διαβάζουμε τα προιόντα του
          storeProductsQuery.setParameter("storeId", s);
	  productsList = storeProductsQuery.getResultList();
	  pCount = productsList.size();
          for (Product p : productsList) { 
             System.out.println(p);
          }
	  loopCustomers -= 1;
	}

    }
}