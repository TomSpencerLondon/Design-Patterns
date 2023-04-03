package org.example.template;

import org.example.template.solution.strategy.Task;
import org.example.template.solution.strategy.TransferMoneyTask;

public class Main {

    public static void main(String[] args) {
        // Transfer money
        // Generate report
        // ...

        Task task = new TransferMoneyTask();

        task.execute();
    }
}
