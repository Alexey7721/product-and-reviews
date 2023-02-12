package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Product;

public class AddProduct extends Item{
    public AddProduct(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Добавить товар";
    }

    @Override
    public void perform() {
        String name = inputOutput.getString("Название продукта: ");
        String description = inputOutput.getString("Описание продукта: ");
        int price = inputOutput.getInteger("Цена: ");
        Product product = new Product(name, description, price);
        management.addProduct(product);
    }
}
