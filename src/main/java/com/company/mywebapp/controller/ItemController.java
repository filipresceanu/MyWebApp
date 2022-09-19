package com.company.mywebapp.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.company.mywebapp.model.Item;
import com.company.mywebapp.model.exception.ImageUtil;
import com.company.mywebapp.repository.IItemRepository;
import com.company.mywebapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public String showItemList(Model model)
    {
        List<Item> listitems=itemService.listAll();
        model.addAttribute("listItems",listitems);
        model.addAttribute("imageUtl",new ImageUtil());
        return "items";
    }
    @GetMapping(value = "/image/{id}")
    public void view(HttpServletResponse response, @PathVariable(name="id") int id) throws Exception {
        response.setHeader("content-type", "image/jpg");

        Item item = itemService.getByid(id).get(); // Get the item based on id;
        OutputStream o = response.getOutputStream();
        o.write(item.getImageTo_display());
        o.close();
    }
    @GetMapping("/items/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("item",new Item());
        model.addAttribute("pageTitle","Add New Item");
        return "items_form";
    }

    @PostMapping("/items/save")
    public String UploadPage(Item item, RedirectAttributes ra)
    {
       itemService.save(item);
       ra.addFlashAttribute("message","The user has been saved successfully");
        return "redirect:/items";
    }
}


