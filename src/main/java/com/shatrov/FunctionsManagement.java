package com.shatrov;

import com.shatrov.model.Product;
import com.shatrov.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FunctionsManagement {
    private SessionFactory sessionFactory;

    @Autowired
    public FunctionsManagement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product){
        Session session = getSession(sessionFactory);
        session.save(product);
        sessionClose(session);
    }

    public Product getProduct(int id){
        Session session = getSession(sessionFactory);
        Product product = session.get(Product.class, id);
        sessionClose(session);
        return product;
    }
    public List<Product> getListProduct(){
        Session session = getSession(sessionFactory);
        List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
        sessionClose(session);
        return products;
    }

    public void addProductReview(int product_id, Review review){
        Session session = getSession(sessionFactory);
        Product product = session.get(Product.class, product_id);
        product.getReviews().add(review);
        review.setProduct(product);
        sessionClose(session);
    }

    public List<Review> getProductReviews(int product_id){
        Session session = getSession(sessionFactory);
        Product product = session.get(Product.class, product_id);
        ArrayList<Review> reviews = new ArrayList<>(product.getReviews());
        sessionClose(session);
        return reviews;
    }

    private Session getSession(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    private void sessionClose(Session session) {
        session.getTransaction().commit();
        session.close();
    }
    public void sessionFactoryClose() {
        sessionFactory.close();
    }
}
