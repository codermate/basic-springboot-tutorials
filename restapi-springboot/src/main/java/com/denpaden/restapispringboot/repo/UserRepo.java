package com.denpaden.restapispringboot.repo;


import com.denpaden.restapispringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DenPaden on 18/08/2022.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
