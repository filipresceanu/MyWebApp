package com.company.mywebapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Lob
    private byte[] imageTo_display;
    private Long price;
    @ManyToOne
    private Cart cart;


}
