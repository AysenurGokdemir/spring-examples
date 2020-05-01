package com.aysenur.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //eger idler birbirine esitse bu iki nesne aynı nesnedr
@ToString
public class Person {
    @Id
    @SequenceGenerator(name="seq_person",allocationSize = 1)
    @GeneratedValue(generator="seq_person", strategy = GenerationType.SEQUENCE)
    private  Long id;

    private String adress;
    private String name;
    private String lastName;

    //db ye bağlanma şeyleri yok bunun onlar olmadan da bu sekilde hata vermemesi lazım o yuzden calıştırmamıstım düzelme görmeyince. onlar olmadan hata verir bu şekilde db ye bağlanmaya çalışıyor şuan. kodu yazdığımızda egitimde hata göstermiyor ama
    @OneToMany
    @JoinColumn(name ="person_adress_id") //bu isimde bir kolonla baglıycaz
    private List<Adress> adressList;



}
