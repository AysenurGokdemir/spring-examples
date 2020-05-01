package com.aysenur.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //eger idler birbirine esitse bu iki nesne aynı nesnedr
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name="seq_person_adress",allocationSize = 1)
    @GeneratedValue(generator="seq_person_adress", strategy = GenerationType.SEQUENCE)
    private  Long id;

    private String adress;

    @Enumerated
    private  AdressType adressType;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person; //otomatikman bu adres bir kişiye atanmıstır diyecek



    public enum AdressType{
        HOME_ADRESS,
        JOB_ADRESS,
        OUTHOR
    }


}
