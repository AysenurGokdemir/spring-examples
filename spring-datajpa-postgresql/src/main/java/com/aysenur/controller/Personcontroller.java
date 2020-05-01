package com.aysenur.controller;

import com.aysenur.dto.PersonDto;
import com.aysenur.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //bu dısarı acacagım bir api oldugu için ekliyorum
@RequestMapping("/Person") //apiyi yayınlayacagım adres
@RequiredArgsConstructor
public class Personcontroller {
    private  final PersonService personService;



    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){ //kaydettikten sonra nesnenin kendisini geri dönmesi return etmesi için User tipinde metot olusturuyoruz
        return ResponseEntity.ok(personService.save(personDto));//userRepository'nin save metoduna userı ver

    }
    @GetMapping //sunucudan kayıtları istiyorsak bu getMappingdir
    public ResponseEntity<List<PersonDto>> getAll(){  //findAll metodu List tipinde doner
        return ResponseEntity.ok(personService.getAll());
    }
}
