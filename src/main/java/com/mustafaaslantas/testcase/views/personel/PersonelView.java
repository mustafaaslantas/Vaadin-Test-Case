package com.mustafaaslantas.testcase.views.personel;

import com.mustafaaslantas.testcase.models.Personel;
import com.mustafaaslantas.testcase.presenter.PersonelPresenter;
import com.mustafaaslantas.testcase.services.PersonelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Personel")
@Route("personel")
public class PersonelView extends VerticalLayout {
    private final PersonelPresenter presenter;
    private final Grid<Personel> grid;
    private final TextField searchField;

    public PersonelView(PersonelService personelService) {
        this.presenter = new PersonelPresenter(personelService);
        this.grid = new Grid<>(Personel.class);
        this.searchField = new TextField("Search by name");

        grid.setDataProvider(presenter.getPersonelDataProvider());

        searchField.addValueChangeListener(event -> {
            presenter.filterPersonel(event.getValue());
        });

        Button refreshButton = new Button("Refresh", event -> {
            presenter.addNewPersonel();
            grid.getDataProvider().refreshAll();
        });
        refreshButton.getStyle().set("margin-left", "auto");


        add(searchField, grid, refreshButton);
    }



}
