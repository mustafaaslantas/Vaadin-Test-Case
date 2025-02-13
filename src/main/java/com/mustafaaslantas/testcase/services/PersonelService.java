package com.mustafaaslantas.testcase.services;

import com.github.javafaker.Faker;
import com.mustafaaslantas.testcase.models.Personel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PersonelService {
    private final Faker faker = new Faker();

    public List<Personel> getPersonelList() {
        return IntStream.range(0, 10)
                .mapToObj(i -> new Personel("00000000000" + i,
                        faker.name().firstName(), // Rastgele Ad
                        faker.name().lastName() // Rastgele Soyad
                        ))
                .collect(Collectors.toList());
    }
}