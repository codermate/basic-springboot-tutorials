package com.denpaden.springdataredis;//package com.denpaden.springdataredis.repo;

import com.denpaden.springdataredis.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    public static final String HASH_KEY = "product";
    @Autowired
    RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public Product update(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> getAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product getById(int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String delete(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Product remove";
    }

}
