package com.kusumotolab.starter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    @Getter
    @Setter
    @NonNull
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    @JsonIgnore
    @Getter
    @Setter
    @NonNull
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    @Getter
    @Setter
    @NonNull
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    @Getter
    @Setter
    @NonNull
    private Instant lastModifiedDate = Instant.now();

    @LastModifiedDate
    @Column(name = "disabled", columnDefinition = "boolean default false", nullable = false)
    @JsonIgnore
    @Getter
    @Setter
    @NonNull
    private Boolean disabled = false;

}

