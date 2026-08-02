package com.product_service.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;
@MappedSuperclass
@Data
public class AuditableEntity {

    @Column(nullable = false, updatable = false)
    private Instant created;

    @Column(nullable = false)
    private Instant modified;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.created = now;
        this.modified = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modified = Instant.now();
    }
}