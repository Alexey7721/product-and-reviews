package com.shatrov.controller;

import com.shatrov.interfaces.ProgramFunctionality;
import com.shatrov.model.Product;
import com.shatrov.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FunctionsManagement implements ProgramFunctionality {
    private final SessionManagement sessionManagement;

    @Autowired
    public FunctionsManagement(SessionFactory sessionFactory) {
        this.sessionManagement = new SessionManagement(sessionFactory);
    }

    public void addProduct(Product product){
        Session session = sessionManagement.getSession();
        session.save(product);
        sessionManagement.sessionClose(session);
    }
    public void removeProduct(Product product) {
        Session session = sessionManagement.getSession();
        session.delete(product);
        sessionManagement.sessionClose(session);
    }
    public void removeReview(Review review) {
        Session session = sessionManagement.getSession();
        session.delete(review);
        sessionManagement.sessionClose(session);
    }

    public Product getProduct(int id){
        Session session = sessionManagement.getSession();
        Product product = session.get(Product.class, id);
        sessionManagement.sessionClose(session);
        return product;
    }
    public Review getReview(int id){
        Session session = sessionManagement.getSession();
        Review review = session.get(Review.class, id);
        sessionManagement.sessionClose(session);
        return review;
    }
    public List<Product> getListProduct(){
        Session session = sessionManagement.getSession();
        List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
        sessionManagement.sessionClose(session);
        return products;
    }

    public void addProductReview(int product_id, Review review){
        Session session = sessionManagement.getSession();
        Product product = session.get(Product.class, product_id);
        product.getReviews().add(review);
        review.setProduct(product);
        sessionManagement.sessionClose(session);
    }

    public List<Review> getProductReviews(int product_id){
        Session session = sessionManagement.getSession();
        Product product = session.get(Product.class, product_id);
        ArrayList<Review> reviews = new ArrayList<>(product.getReviews());
        sessionManagement.sessionClose(session);
        return reviews;
    }
    public void completion() {
        sessionManagement.sessionFactoryClose();
    }
}
