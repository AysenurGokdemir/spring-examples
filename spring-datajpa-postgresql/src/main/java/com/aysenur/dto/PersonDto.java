package com.aysenur.dto;

import com.aysenur.entity.Adress;
import lombok.Data;

import java.util.List;

@Data //ne zaman kullanılmaz -> içerdiği annotationların bazılarını kullanmayacaksan
public class PersonDto {

    private Long id;
    private String name;
    private String lastName;
    private List<String> adresses; //adresleri string listesi olarak istiyorum mobileden veya kullanan uygulamadan


}
