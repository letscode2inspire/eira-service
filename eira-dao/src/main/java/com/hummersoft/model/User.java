package com.hummersoft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String address;
    private String location;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;


}
