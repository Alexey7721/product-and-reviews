package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Product;
import com.shatrov.model.Review;

public class AddReviewToProduct extends Item{
    public AddReviewToProduct(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Добавить отзыв к продукту";
    }

    @Override
    public void perform() {
        int id = inputOutput.getInteger("Введите ID продукта: ");
        Product product = functionsManagement.getProduct(id);
        if(product == null) {
            inputOutput.display("Продукта с таким ID не найдено в БД!!!");
        } else {
            String description = inputOutput.getString("Напишите отзыв: ");
            int stars = inputOutput.getInteger("Введите оценку: ");
            Review review = new Review(description, stars);
            functionsManagement.addProductReview(id, review);
        }


    }
}
