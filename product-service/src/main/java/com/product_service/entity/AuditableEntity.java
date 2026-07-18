package com.product_service.entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;
import java.util.UUID;

@Data
@EntityListeners(AuditableEntity.class)
public class AuditableEntity {

    @CreatedDate
    private Instant created;

    @LastModifiedDate
    private Instant modified;

    @CreatedBy
    private UUID createdBy;

    @LastModifiedBy
    private UUID modifiedBy;


    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.created=now;
        this.modified= now;
    }

}
