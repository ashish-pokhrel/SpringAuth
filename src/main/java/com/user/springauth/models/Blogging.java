package com.user.springauth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogging {
    @Id
    @GeneratedValue
    private long id;
    private String Topic;
    @Lob
    private String Description;
    private Date PostedOn;
    private Long PostedBy;
    private boolean isDeleted;
    private boolean TotalReactedBy;
}
