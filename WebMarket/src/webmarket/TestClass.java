/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
//import model.*;
//import java.util.Date;



/**
 *
 * @author Simos
 */
public class TestClass {
    
    private static EntityManager em;
    private static javax.persistence.Query query1;
    private static javax.persistence.Query query2;
    private static javax.persistence.Query query3;
    private static javax.persistence.Query query4;
    private static javax.persistence.Query query5;
    private static javax.persistence.Query query6;
    private static javax.persistence.Query query7;
    
   
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        em = emf.createEntityManager(); 
         
        query1 = em.createQuery("SELECT s FROM Store s WHERE s.storeId = :storeId");
        query1.setParameter("storeId", 3);
        List<Store> stlist = query1.getResultList();
        System.out.println("store : " + stlist.get(0).getName());
        
        query2 = em.createQuery("SELECT p FROM Product p WHERE p.productId = :productId");
        query2.setParameter("productId", 2);
        List<Product> pdlist = query2.getResultList();
        System.out.println("product : " + pdlist.get(0).getName());
     
        query3 = em.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId");
        query3.setParameter("customerId", 2);
        List<Customer> ctlist = query3.getResultList();
        System.out.println("customer : " + ctlist.get(0).getFirstName());
        
        query4 = em.createQuery("SELECT s FROM StoreProduct s WHERE s.productStoreId = :productStoreId");
        query4.setParameter("productStoreId", 2);
        List<StoreProduct> splist = query4.getResultList();
        System.out.println("store_product : " + splist.get(0).getProductId());
        

        query5 = em.createQuery("SELECT b FROM BonusCheck b WHERE b.checkId = :checkId");
        query5.setParameter("checkId", 1);
        List<BonusCheck> bclist = query5.getResultList();
        System.out.println("bonus_check : " + bclist.get(0).getAmount());
     
        query6 = em.createQuery("SELECT p FROM ProductPurchase p WHERE p.productPurchaseId = :productPurchaseId");
        query6.setParameter("productPurchaseId", 1);
        List<ProductPurchase> pplist = query6.getResultList();
        System.out.println("product_purchase : " + pplist.get(0).getQuantity());
        
        query7 = em.createQuery("SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId");
        query7.setParameter("purchaseId", 1);
        List<Purchase> pulist = query7.getResultList();
        System.out.println("Purchase : " + pulist.get(0).getAmount());

    }
}