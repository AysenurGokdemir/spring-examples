package com.aysenur.repository;

import com.aysenur.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,String> { //person diye bir typedan gelir nasıl bir id si vardır stringdir

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}") //boolean olarak örtüşmeli name degeri sadece adı ortusen gelsin
    List<Person> getByCustomQuery(String search);



}
