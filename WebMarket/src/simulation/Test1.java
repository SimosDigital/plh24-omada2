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
import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.TypedQuery;
import model.Store;
import model.BonusCheck;
import model.Customer;
import model.Product;
import model.Purchase;
import model.StoreProduct;
import model.ProductPurchase;

public class Test1 {
    static Scanner scan = new Scanner(System.in, "Cp1253");  
    static String choice = null;

    private static EntityManager em;
    static Random randCustomer = new Random();
    static Random randStore = new Random(); 
    static Random randProduct = new Random();
    static private Customer selectCustomer(List<Customer> customers, Integer maxCustomer) {
        Integer customerIndex = randCustomer.nextInt(maxCustomer);      
        Customer c = customers.get(customerIndex);
        return c;
    }
    static private Store selectStore(List<Store> stores, Integer maxStore) {
        Integer storeIndex = randStore.nextInt(maxStore);      
        Store s = stores.get(storeIndex);
      return s;
    }
    static private List<Product> selectStoreProducts(Store s) {
        TypedQuery<StoreProduct> storeProductsQuery = em.createNamedQuery("StoreProduct.findByStoreId", StoreProduct.class);
        storeProductsQuery.setParameter("storeId",s);
        List<StoreProduct> storeProducts = storeProductsQuery.getResultList();
        Collections.shuffle(storeProducts);   
// Ανακατεύουμε την λίστα για να πάρουμε τα προιόντα του store σε τυχαία σειρά

// Φτιάχνουμε μία λίστα με μέχρι 20 προιόντα απο τα προιόντα του store σε τυχαία σειρά
	ArrayList<Product> pl = new ArrayList<Product>();
	int i = randProduct.nextInt(20) + 1;
        for (StoreProduct sp : storeProducts)  {
		/*
           TypedQuery<Product> productQuery = em.createNamedQuery("Product.findByProductId", Product.class);
           productQuery.setParameter("productId",sp.getProductId());
           Product p = productQuery.getSingleResult();
		*/
System.out.println(sp.getProductId());
System.out.println("lista");
String sentence = scan.nextLine();
	   pl.add(sp.getProductId());
	   i--;
	   if (i == 0) {
	      break;
	   }
	}
        return pl;
    }
// Ελέγχουμε την καρτα
    static private Integer checkCard(Customer c) {
	 Integer ok = 0;  
	 return ok;
    }
    static private Purchase makePurchase(Integer ok, Customer c, Store s, List<Product> pl) {
	Integer pointsEarned = 0;
	Float   amount       = 0F;
// Δημιουργούμε μια παραγγελία με όλα τα προιόντα
// που λειτουργεί σαν καλάθι                     

          Purchase        pur  = new Purchase();
          ProductPurchase pp   = new ProductPurchase();
          ArrayList<ProductPurchase> ppList = new ArrayList<ProductPurchase>();
	  pointsEarned = 0;
	  amount       = 0F;
          for (Product p : pl) {
String sentence = scan.nextLine();
System.out.println(p);
             pp = new ProductPurchase();
    	     pp.setProductId(p);
	     pp.setPurchaseId(pur);
	     pp.setQuantity(1);
             ppList.add(pp);
	     pointsEarned += p.getPoints();
	     amount       += p.getPrice();
          }
    	  pur.setDatetime(Calendar.getInstance().getTime());
    	  pur.setCustomerId(c);
    	  pur.setStoreId(s);
    	  pur.setDelivery(0);
	  pur.setPointsEarned(pointsEarned);
	  pur.setAmount(amount);
System.out.println(pur);
System.out.println("before`");
String sentence = scan.nextLine();
	  em.getTransaction().begin();
          try {
            em.persist(pur);            
            em.getTransaction().commit();
          } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
          } 
System.out.println(pur);
System.out.println("after");
sentence = scan.nextLine();
	  return pur;
    }
    public static void main(String args[]) {
        File xmlFile = new File("C:\\test\\purchases.xml");
        PurchaseXMLManager purchaseXMLWriter = new PurchaseXMLManager(xmlFile);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        em = emf.createEntityManager();

// Διαβάζουμε τους πελάτες σε μία λίστα
        TypedQuery<Customer> allCustomersQuery = em.createNamedQuery("Customer.findAll", Customer.class);
        List<Customer> customers = allCustomersQuery.getResultList();
        int maxCustomer          = customers.size();

// Διαβάζουμε τα καταστηματα σε μία λίστα
        TypedQuery<Store> allStoresQuery = em.createNamedQuery("Store.findAll", Store.class);
        List<Store> stores = allStoresQuery.getResultList();
        int maxStore       = stores.size();
// Κάνω loop για 10 αγορές
	for (Integer i=0;i<10;i++) {
// Επιλέγω τυχαίο πελάτη απο την λίστα
	   Customer c = selectCustomer(customers,maxCustomer);
// Επιλέγω τυχαίο Κατάστημα απο την λίστα
	   Store    s = selectStore   (stores,   maxStore   );
// Επιλέγω τυχαία Προιόντα  απο τα προιόντα του καταστήματος
	   List<Product> pl = selectStoreProducts (s);
// Ελέγχω την κάρτα του πελάτη
	   Integer ok = checkCard(c);
// Πραγματοποιώ την αγορά     
	   Purchase pur = makePurchase(ok,c,s,pl);
// Γράφω το XML               
           purchaseXMLWriter.writeXML(pur, ok);

           System.out.println(s);
           System.out.println(pl);
           System.out.println(pur);
	}
	em.close();
	emf.close();
    }
}

