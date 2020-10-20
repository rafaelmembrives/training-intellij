package com.viafirma.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
class TrainingIntellijApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    void testIntelliJCodeInspection() {
        List<Person> persons = personService.findAll();
        Assertions.assertTrue(persons.isEmpty());
        List<Person> filteredPersons = persons.stream().filter(person -> person.getName().contains("Membrives")).collect(Collectors.toList());
        Assertions.assertTrue(filteredPersons.size() == 1);

        persons.stream().map(Person::getName).map(String::toLowerCase).filter("rafael membrives"::equals).findAny().isPresent();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ola k ase");
            }
        });
        thread.run();

        Optional<Person> me = personService.findById("rmembrives");
        Assertions.assertTrue(me.isPresent());

        String value = alwaysReturnNull();
        System.out.println(value.toLowerCase());
    }

    private String alwaysReturnNull() {
        return null;
    }
}
