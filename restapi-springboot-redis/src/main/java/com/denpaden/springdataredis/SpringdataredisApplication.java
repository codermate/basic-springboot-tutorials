package com.denpaden.springdataredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/redis/product")
public class SpringdataredisApplication {

    @Autowired
    ProductDao productDao;

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productDao.getById(id);
    }


    @GetMapping("/all")
    public List<Product> getAll() {
        return productDao.getAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdataredisApplication.class, args);
    }

}
