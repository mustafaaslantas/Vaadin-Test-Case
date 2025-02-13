package com.mustafaaslantas.testcase.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("About")
@Route("about")
public class AboutView extends VerticalLayout {
    public AboutView() {
        Text text = new Text("Bu proje Mustafa Aslantaş tarafından yapılmıştır.");
        Anchor mail = new Anchor("mailto:mustafaaslantas1@outlook.com", "mustafaaslantas1@outlook.com");
        Anchor linkedIn = new Anchor("https://www.linkedin.com/in/mustafaaslantas1/", "LinkedIn");
        linkedIn.setTarget("_blank");
        Anchor gitHub = new Anchor("https://github.com/mustafaaslantas", "GitHub");
        gitHub.setTarget("_blank");
        add(text, linkedIn, gitHub, mail);
    }


}
