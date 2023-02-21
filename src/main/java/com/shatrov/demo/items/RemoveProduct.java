package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Product;

public class RemoveProduct extends Item{
    public RemoveProduct(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Удалить продукт";
    }

    @Override
    public void perform() {
        int id = inputOutput.getInteger("Введите ID продукта: ");
        Product product = functionsManagement.getProduct(id);
        if(product == null) {
            inputOutput.display("Продукта с таким ID не найдено в БД!!!");
        } else {
            functionsManagement.removeProduct(product);
        }
    }
}
