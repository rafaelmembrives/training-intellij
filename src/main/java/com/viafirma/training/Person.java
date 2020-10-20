package com.viafirma.training;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "person")
public class Person {

    @Id
    String code;
    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
