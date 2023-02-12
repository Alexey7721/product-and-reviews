package com.shatrov.demo.items;

import com.shatrov.FunctionsManagement;
import com.shatrov.configuration.MyConfig;
import com.shatrov.demo.ConsoleInputOutput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class Item {

    protected ConsoleInputOutput inputOutput;
    protected static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    protected static FunctionsManagement management = context.getBean("functionsManagement", FunctionsManagement.class);

    public Item(ConsoleInputOutput inputOutput) {
        this.inputOutput = inputOutput;
    }

    public abstract String displayedName();

    public abstract void perform();

    public boolean isExit(){
        return false;
    }

}
