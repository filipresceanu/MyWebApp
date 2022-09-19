package com.company.mywebapp.model;


import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private List<Item> items=new ArrayList<Item>();

    public void addItem(Item item){items.add(item);}

    public void removeItem(Item item){items.remove(item);}
}
