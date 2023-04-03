package org.example.template.solution.strategy;

import org.example.template.AuditTrail;

public class TransferMoneyTask extends Task {

    @Override
    protected void doExecute() {
        System.out.println("Transfer Money");
    }
}
