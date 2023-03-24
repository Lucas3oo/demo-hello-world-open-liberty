package com.example.rest.books;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedOn;
import org.apache.deltaspike.data.impl.audit.AuditEntityListener;

@Entity
@EntityListeners(AuditEntityListener.class)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "description" }))
public class BookEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "can not be empty")
  @Size(min = 1, max = 255)
  @Column(nullable = false, length = 255)
  private String description;

  // DeltaSpike doesn't support java.time.* classes for automatic audit.
  // Really want to use below or better use Instant but seems only supported with Hibernate but not JPA
//  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
//  private OffsetDateTime createdOn;

  @CreatedOn
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @ModifiedOn
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedOn;

  public BookEntity() {
  }

  public BookEntity(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
