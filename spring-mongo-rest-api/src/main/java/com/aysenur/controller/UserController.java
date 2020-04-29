package com.aysenur.controller;

import com.aysenur.entity.User;
import com.aysenur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
   public void init(){
        User user=new User();
        user.setName("Ayşenur");
        user.setLastName("GÖKDEMIR");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){ //kaydettikten sonra nesnenin kendisini geri dönmesi return etmesi için User tipinde metot olusturuyoruz
       return ResponseEntity.ok(userRepository.save(user));//userRepository'nin save metoduna userı ver

    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){  //findAll metodu List tipinde doner
        return ResponseEntity.ok(userRepository.findAll());
    }
}
