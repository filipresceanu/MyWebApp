package com.company.mywebapp.model.dto;

import com.company.mywebapp.model.Cart;
import com.company.mywebapp.model.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {
    private Integer id;
    private List<ItemDto>itemDtos =new ArrayList<>();

    public static CartDto from(Cart cart)
    {
        CartDto cartDto=new CartDto();
        cartDto.setId(cartDto.getId());
        cartDto.setItemDtos(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));
        return cartDto;
    }

}
