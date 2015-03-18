/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Clients;
import model.Productions;
import model.Products;
import model.Users;
/**
 *
 * @author Alexandru
 */
public class DBAccess {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private DBAccess() {
        emf = Persistence.createEntityManagerFactory("BrutariePU");
        em = emf.createEntityManager();
    }
    
    public static DBAccess getInstance() {
        //if (DBAccessHolder.INSTANCE == null)
        //{
        //    DBAccessHolder.INSTANCE = new DBAccess ();
        //}
        return DBAccessHolder.INSTANCE;
    }

    public Users login(Users user) {
        Users result = null;
        List<Users> users = new ArrayList<> ();
        em.getTransaction().begin();
        users = em.createNamedQuery("Users.findByUsernameAndPassword").setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).getResultList();
        if ( users.size() > 0 )
        {
            result= users.get(0);
        }
        em.getTransaction().commit();
        return result;
    }
    
    public void shutDown()
    {
        em.close();
        emf.close();
    }

    public List<Clients> getAllClients() {
        em.getTransaction().begin();
        List <Clients> clients = new ArrayList<Clients> ();
        Query query = em.createQuery("SELECT c FROM Clients C");
        clients = query.getResultList();
        em.getTransaction().commit();
        if ( clients.size() > 0 )
        {
            return clients;
        }
        return null;
    }

    public List<Productions> getAllCategories() {
        
    em.getTransaction().begin();
        List <Productions> categories = new ArrayList<Productions> ();
        Query query = em.createQuery("SELECT p FROM Productions P");
        categories = query.getResultList();
        em.getTransaction().commit();
        if ( categories.size() > 0 )
        {
            return categories;
        }
        return null;
    }

    public List<Products> getAllProducts() {
       em.getTransaction().begin();
        List < Products > products = new ArrayList<Products> ();
        Query query = em.createQuery("SELECT p FROM Products P");
        products = query.getResultList();
        em.getTransaction().commit();
        if ( products.size() > 0 )
        {
            return products;
        }
        return null;
    }
    private static class DBAccessHolder {

        private static final DBAccess INSTANCE = new DBAccess();
    }
}
