package org.example.template.mysolution;

public class Main {

    public static void main(String[] args) {
        Task task = new GenerateReportTask();
        task.execute();

        task = new TransferMoneyTask();
        task.execute();
    }
}
