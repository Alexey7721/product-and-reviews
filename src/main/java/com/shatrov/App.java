package com.shatrov;

import com.shatrov.configuration.MyConfig;
import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.demo.ConsoleMenu;
import com.shatrov.demo.items.*;
import com.shatrov.model.Product;
import com.shatrov.model.Review;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ConsoleInputOutput inputOutput = new ConsoleInputOutput();

        ConsoleMenu menu = new ConsoleMenu(inputOutput, new Item[]{
                new AddProduct(inputOutput),
                new AddReviewToProduct(inputOutput),
                new ViewAllProducts(inputOutput),
                new ViewProductAndReviews(inputOutput),
                new ExitItem(inputOutput)});
        menu.runMenu();








//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(MyConfig.class);
//
//        FunctionsManagement  management = context.getBean("functionsManagement", FunctionsManagement.class);
//
//        Product product = new Product("Iphone 12", "Blue color", 50000);
//
//        management.sessionFactoryClose();
//        context.close();
    }
}
