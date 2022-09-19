package com.company.mywebapp.model.dto;

import com.company.mywebapp.model.Item;
import lombok.Data;

import javax.persistence.Id;
import java.util.Objects;

@Data
public class ItemDto {
    private Integer id;
    private byte[] imageTo_display;
    private Long price;
    private PlainCartDto plainCartDto;

    public static ItemDto from(Item item)
    {
        ItemDto itemDto=new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setImageTo_display(item.getImageTo_display());
        itemDto.setPrice(item.getPrice());
        if(Objects.nonNull(item.getCart()))
        {
            itemDto.setPlainCartDto(PlainCartDto.from(item.getCart()));
        }

        return itemDto;

    }


}
