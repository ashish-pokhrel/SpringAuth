package com.user.springauth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(nullable = false)
    private String Type;

}
