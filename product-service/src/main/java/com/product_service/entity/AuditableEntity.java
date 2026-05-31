package com.product_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;

import java.time.Instant;

public class AuditableEntity {

    private Instant created;

    private Instant modified;


    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.created=now;
        this.modified= now;
    }

}
