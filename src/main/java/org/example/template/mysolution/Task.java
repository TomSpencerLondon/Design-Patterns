package org.example.template.mysolution;

import org.example.template.AuditTrail;

public abstract class Task {
    private AuditTrail auditTrail;

    public Task() {
        this.auditTrail = new AuditTrail();
    }

    abstract void completeTask();

    public final void execute() {
        auditTrail.record();
        completeTask();
    }
}
