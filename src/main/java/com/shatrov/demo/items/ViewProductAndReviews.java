package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Product;
import com.shatrov.model.Review;

import java.util.List;

public class ViewProductAndReviews extends Item{

    public ViewProductAndReviews(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Просмотреть товар и его отзывы";
    }

    @Override
    public void perform() {
        int id = inputOutput.getInteger("Введите ID продукта: ");
        Product product = management.getProduct(id);
        if(product == null) {
            inputOutput.display("Продукта с таким ID не найдено в БД!!!");
        } else {
            List<Review> productReviews = management.getProductReviews(product.getId());
            inputOutput.display(product.toString() + productReviews + "\n");
        }
    }
}
