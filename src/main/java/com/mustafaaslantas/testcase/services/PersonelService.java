package com.mustafaaslantas.testcase.services;

import com.github.javafaker.Faker;
import com.mustafaaslantas.testcase.models.Personel;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PersonelService {
   private final List<Personel> personelList;
   private final ListDataProvider<Personel> dataProvider;
   private final Faker faker;

   public PersonelService() {
       this.personelList = new ArrayList<>();
       this.dataProvider = new ListDataProvider<>(personelList);
       this.faker = new Faker(new Locale("tr"));

       initializePersonelList();
   }

   private void initializePersonelList() {
       IntStream.range(0,10).forEach(i -> personelList.add(generateRandomPersonel()));
   }
    private Personel generateRandomPersonel() {
        return new Personel(
                faker.idNumber().invalid(),
                faker.name().firstName(),
                faker.name().lastName()
        );
    }

   public List<Personel> getPersonelList() {
       return personelList;
   }
   public ListDataProvider<Personel> getDataProvider() {
       return dataProvider;
   }
   public void addPersonel(){
       Personel newPersonel = generateRandomPersonel();
       personelList.add(newPersonel);
       dataProvider.refreshAll();
   }

}