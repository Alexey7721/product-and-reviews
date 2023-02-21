package com.shatrov.interfaces;

import com.shatrov.model.Product;
import com.shatrov.model.Review;
import java.util.List;
/**
 * Интерфейс, в котором описаны возможности приложения
 */
public interface ProgramFunctionality {
    /**
     * Метод, который добавляет продукт в базу данных
     * @param product - продукт, который нужно добавить(информация о продукте вводится с консоли)
     */
    public void addProduct(Product product);
    /**
     * Метод, который удаляет продукт из базы данных
     * @param product - продукт, который нужно удалить
     */
    public void removeProduct(Product product);
    /**
     * Метод, который удаляет отзыв из базы данных
     * @param review - отзыв, который нужно удалить
     */
    public void removeReview(Review review);
    /**
     * Метод, который позволяет получить продукт из базы данных
     * @param id - id продукта
     */
    public Product getProduct(int id);
    /**
     * Метод, который позволяет получить отзыв из базы данных
     * @param id - id отзыва
     */
    public Review getReview(int id);
    /**
     * Метод, который позволяет получить все продукты из базы данных
     */
    public List<Product> getListProduct();
    /**
     * Метод, который позволяет оставить отзыв на продукт
     * @param product_id - id продукта, на который нужно оставить отзыв
     * @param review - отзыв, который нужно добавить
     */
    public void addProductReview(int product_id, Review review);
    /**
     * Метод, который позволяет получить все отзывы на определенный продукт
     * @param product_id - id продукта
     */
    public List<Review> getProductReviews(int product_id);
    /**
     * Метод, который завершает работу приложения
     */
    public void completion();
}
