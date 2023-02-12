package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;

public class ExitItem extends Item {
    public ExitItem(ConsoleInputOutput inputOutput){super(inputOutput);}

    @Override
    public  String displayedName() {
        return "Exit";
    }

    @Override
    public void perform() {
        management.sessionFactoryClose();
        context.close();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
