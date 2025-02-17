package com.mustafaaslantas.testcase.presenter;

import com.mustafaaslantas.testcase.models.Personel;
import com.mustafaaslantas.testcase.services.PersonelService;
import com.vaadin.flow.data.provider.ListDataProvider;


public class PersonelPresenter {
    private final PersonelService personelService;
    private ListDataProvider<Personel> personelDataProvider;

    public PersonelPresenter(PersonelService personelService) {
        this.personelService = personelService;
        this.personelDataProvider = new ListDataProvider<>(personelService.getPersonelList());
    }

    public ListDataProvider<Personel> getPersonelDataProvider() {
        return personelDataProvider;
    }

    public void filterPersonel(String searchTerm){
        personelDataProvider.setFilter(
                personel -> {
                    String ad = personel.getAd().toLowerCase();
                    String soyad = personel.getSoyad().toLowerCase();
                    String adSoyad = ad + soyad;
                    String search = searchTerm.toLowerCase();
                    return ad.contains(search) || soyad.contains(search) || adSoyad.contains(search);
                }
        );
    }

    public void addNewPersonel() {
        personelService.addPersonel();
        personelDataProvider.refreshAll();

    }
}
