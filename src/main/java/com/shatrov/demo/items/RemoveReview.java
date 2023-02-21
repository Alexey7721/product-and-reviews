package com.shatrov.demo.items;

import com.shatrov.demo.ConsoleInputOutput;
import com.shatrov.model.Review;

public class RemoveReview extends Item{
    public RemoveReview(ConsoleInputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Удалить коментарий";
    }

    @Override
    public void perform() {
        int id = inputOutput.getInteger("Введите ID коментария: ");
        Review review = functionsManagement.getReview(id);
        if(review == null) {
            inputOutput.display("Коментария с таким ID не найдено в БД!!!");
        } else {
            functionsManagement.removeReview(review);
        }
    }
}
