package com.dncoder.springopenapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer age;

    public Customer() {

    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

   
}
