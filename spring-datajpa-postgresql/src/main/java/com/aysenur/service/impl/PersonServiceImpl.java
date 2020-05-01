package com.aysenur.service.impl;

import com.aysenur.dto.PersonDto;
import com.aysenur.entity.Adress;
import com.aysenur.entity.Person;
import com.aysenur.repo.AdressRepository;
import com.aysenur.repo.PersonRepository;
import com.aysenur.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //dependency injection içinde bir instance olusturması için
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AdressRepository adressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
       // Assert.isNull(personDto.getName(),"Adi alani zorunludurs");

        Person person=new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        final Person personDb= personRepository.save(person);
        List<Adress> adresseslist=new ArrayList<>();
        personDto.getAdresses().forEach(item ->{
            Adress adres=new Adress();
            adres.setAdress(item);
            adres.setAdressType(Adress.AdressType.OUTHOR);
            adres.setActive(true);
            adres.setPerson(personDb);
            adresseslist.add(adres);
        });
        adressRepository.saveAll(adresseslist);//elimizdeki listeyi kaydettiriyoruz
        personDto.setId(personDb.getId()); //personDto'ya,en son kaydedilen kişinin ıd'sini set ediyorum

        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> persons=personRepository.findAll();//tüm kayıtları lısteye aldık
        List<PersonDto> personDtos= new ArrayList<>();
        persons.forEach(it ->{ //kişi dto döndurmemiz lazım
            PersonDto personDto=new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setLastName(it.getLastName());
            personDto.setAdresses(it.getAdressList().stream().map(Adress::getAdress) //her bir item'ın bir sürü adresi var o adreslerin hepsinin sadece adres kolonlarını dödür
                    .collect(Collectors.toList()));
            personDtos.add(personDto);

        });

        return personDtos;
        /**
         * her bir item'ın bir sürü adresi var o adreslerin hepsinin sadece adres kolonlarını(column)
         * bir liste halinde DTO'nun adreslerine doldur ve bu kişilerin hepsini liste halinde döndür
         */
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
