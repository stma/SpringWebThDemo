package com.example.xyz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


class Product {
    private final String name;
    private final String price;
    private final String image;
    private final int id;

    public Product(int id, String name, String price) {
        this.id = id;
        this.image = String.format("https://picsum.photos/id/%d/200/300", id);
        this.name = name;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}

@Controller
public class ProductController {

    List<Product> products = new LinkedList<>(
            List.of(
                new Product(
                        (int)(Math.random() * 200) + 100,
                        "kiskacsa",
                        "345"
                ),
                new Product((int)(Math.random() * 200) + 100,"kiskacsa2", "345"),
                new Product((int)(Math.random() * 200) + 100,"kiskacsa3", "3345"),
                new Product((int)(Math.random() * 200) + 100,"kiskacsa4", "3445"),
                new Product((int)(Math.random() * 200) + 100,"Kalap", "46745")
            )
    );

    @GetMapping("/cart")
    public String getProduct(Model model) {
        model.addAttribute("products", products);
        return "cart-show";
    }

    @GetMapping("/new-product")
    public String getProductForm() {
        return "product-form";
    }

    @PostMapping("/new-product")
    public String addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") String price
    ) {
        this.products.add(
            new Product(
                (int)(Math.random() * 200) + 100,
                name,
                price
            )
        );
        return "redirect:/cart";
    }
}
