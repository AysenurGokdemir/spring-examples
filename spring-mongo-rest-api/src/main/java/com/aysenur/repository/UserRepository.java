package com.aysenur.repository;

import com.aysenur.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

    /**
        2 tane type parametresi avr birincisi bir repository nesnesi yaratabilmem için hangi tabloya baglanacagımı
        nerden bilcem dediğinde baglanacagı collection veya veritabanı nesnesini belirtmiş oluyoruz ikincisi primary key tipi
    **/

public interface UserRepository extends MongoRepository<User, String> {

    //save delete vs. dısında bir metot yazmak istersen yaz onun dışında digerlerini MongoRepository interface'i saglıyor
}
