package vallegrande.edu.pe.agrofrutoslambayeque.controller;

import vallegrande.edu.pe.agrofrutoslambayeque.model.ContactoDAO;
import vallegrande.edu.pe.agrofrutoslambayeque.view.MainView;

public class MainController {

    private MainView view;
    private ContactoDAO dao;

    public MainController(MainView view) {
        this.view = view;
        this.dao = new ContactoDAO();
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInicio().setOnAction(
                e -> view.mostrarInicio()
        );

        view.getBtnContactos().setOnAction(
                e -> view.mostrarContactos(
                        dao.listarContactos()
                )
        );
    }
}