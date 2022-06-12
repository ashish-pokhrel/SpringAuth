package com.user.springauth.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Admin")
public class Admin extends User {
}
