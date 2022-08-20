package com.denpaden.rabbitmqpublisher.repo;


import com.denpaden.rabbitmqpublisher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DenPaden on 18/08/2022.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User getByUsername(String username);

}
