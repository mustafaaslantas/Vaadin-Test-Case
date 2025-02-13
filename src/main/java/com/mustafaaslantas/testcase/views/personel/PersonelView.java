package com.mustafaaslantas.testcase.views.personel;

import com.mustafaaslantas.testcase.models.Personel;
import com.mustafaaslantas.testcase.services.PersonelService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;
@PageTitle("Personel")
@Route("personel")
public class PersonelView extends VerticalLayout {
    private final PersonelService personelService;
    private final ListDataProvider<Personel> dataProvider;


    public PersonelView(PersonelService personelService) {
        this.personelService = personelService;

        Grid<Personel> grid = new Grid<>(Personel.class);
        grid.setItems(personelService.getPersonelList());

        List<Personel> personelList = personelService.getPersonelList();
        dataProvider = new ListDataProvider<>(personelList);
        grid.setDataProvider(dataProvider);

        TextField searchField = new TextField("Search by name");
        searchField.addValueChangeListener(event -> filterGrid(event.getValue()));


        add(searchField, grid);
    }
    private void filterGrid(String searchTerm) {
        dataProvider.setFilter(Personel::getAd, ad ->
                ad.toLowerCase().contains(searchTerm.toLowerCase()));
    }
}
