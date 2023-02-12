package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Product;

import java.util.List;

public class ViewAllProducts extends Item{
    public ViewAllProducts(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Посмотреть все продукты";
    }

    @Override
    public void perform() {
        List<Product> listProduct = management.getListProduct();
//        inputOutput.display(listProduct.toString());
        listProduct.forEach((obj)->inputOutput.display(obj.toString() + "\n"));
    }
}
