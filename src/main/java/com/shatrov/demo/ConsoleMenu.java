package com.shatrov.demo;

import com.shatrov.demo.items.Item;

public class ConsoleMenu {
    private ConsoleInputOutput inputOutput;
    protected Item[] items;

    public ConsoleMenu(ConsoleInputOutput inputOutput, Item[] items) {
        this.inputOutput = inputOutput;
        this.items = items;
    }


    public void runMenu(){
        Item selected = null;
        do {
            for (int i = 0; i < items.length; i++) inputOutput.displayLine(i+1 + "." + items[i].displayedName());
            selected = items[inputOutput.getInteger("Введите номер пункта меню: ", 1, items.length+1) - 1];
            selected.perform();
        } while (!selected.isExit());
    }
}
