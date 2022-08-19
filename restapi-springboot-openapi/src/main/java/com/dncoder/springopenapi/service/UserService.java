package com.dncoder.springopenapi.service;


import com.dncoder.springopenapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Service
public interface UserService {
    public User save(User user);

    public List<User> getAll();

}
