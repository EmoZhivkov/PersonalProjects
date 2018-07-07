package com.simplewebservice;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id = 0l;

    public String getName() {
        return name;
    }

    private @NonNull
    String name;

    public void setName(String name) {
        this.name = name;
    }

}