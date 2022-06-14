package com.user.springauth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogging {

    private long id;
    private String Topic;
    private String Description;
    private Date PostedOn;
    private Long PostedBy;
    private boolean isDeleted;
    private boolean TotalReactedBy;
}
