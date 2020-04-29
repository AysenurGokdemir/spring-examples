package com.aysenur.controller;

import com.aysenur.entity.Person;
import com.aysenur.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

//hangi field'lar gerekiyorsa onu kullan demek için
@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    //Repository'e baglanacak ve onun uzerinden calısıcak bu yuzden ;

    private PersonRepository personRepository;


    /*public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
      bu constructer yerine @RequiredArgsConstructor annotationI kullanıyorum

    }
    */
    @PostConstruct
    public void init(){
        Person p = new Person();
        p.setName("Ayşenur");
        p.setLastName("GÖKDEMİR");
        p.setAdress("test");
        p.setBirthday(Calendar.getInstance().getTime());
        p.setId("K0001");


        personRepository.save(p);

    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>>getPerson(@PathVariable String search){
      List<Person> persons= personRepository.getByCustomQuery(search); //arama sonucunda dönecek kişiler
        return ResponseEntity.ok(persons);

    }

    }

