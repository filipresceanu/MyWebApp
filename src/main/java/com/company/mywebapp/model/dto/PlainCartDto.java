package com.company.mywebapp.model.dto;

import com.company.mywebapp.model.Cart;
import lombok.Data;

@Data
public class PlainCartDto {
    private Integer id;

    public static PlainCartDto from(Cart cart)
    {
        PlainCartDto plainCartDto=new PlainCartDto();
        plainCartDto.setId(cart.getId());
        return plainCartDto;
    }
}
