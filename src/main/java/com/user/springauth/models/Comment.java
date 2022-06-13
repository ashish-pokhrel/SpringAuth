package com.user.springauth.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private long id;
    private long BlogId;
    private String text;
    private Date PostedOn;
    private Long PostedBy;
    private boolean isDeleted;
    private boolean TotalReactedBy;
}
