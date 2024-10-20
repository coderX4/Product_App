package com.ProductApp.dao;

import com.ProductApp.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Integer r = (Integer) session.save(product);
        session.flush();
        return r;
    }

    @Transactional
    public Product getProduct(int Uid) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,Uid);
        session.flush();
        return product;
    }

    @Transactional
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        String qry = "select * from Product";
        List<Product> productList = session.createNativeQuery(qry, Product.class).list();
        session.flush();
        return productList;
    }

    @Transactional
    public int deleteProduct(int PId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,PId);
        if(product!=null) {
            session.remove(product);
            session.flush();
        }
        else{
            System.out.println("Failed to delete product with id: " + PId);
        }
        return PId;
    }

    @Transactional
    public int updateProduct(int Uid, Product product) {
        Session session = sessionFactory.getCurrentSession();
        product.setId(Uid);
        session.update(product);
        session.flush();
        return Uid;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
