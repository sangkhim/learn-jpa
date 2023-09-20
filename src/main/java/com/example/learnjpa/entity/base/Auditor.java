package com.example.learnjpa.entity.base;

import jakarta.persistence.Embeddable;
import java.util.Date;
import lombok.Data;

@Embeddable
@Data
public class Auditor {
  private Date createdDate;
  private String createdBy;
  private Date lastModifiedDate;
  private String lastModifiedBy;
}
