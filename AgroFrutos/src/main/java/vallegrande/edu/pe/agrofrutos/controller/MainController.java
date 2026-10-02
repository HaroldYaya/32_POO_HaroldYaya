package vallegrande.edu.pe.agrofrutoslambayeque.controller;

import javafx.scene.control.Alert;
import vallegrande.edu.pe.agrofrutoslambayeque.model.Contacto;
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

        view.getBtnRegistrar().setOnAction(e -> {

            Contacto c = view.leerFormulario();

            if (c.getNombre().isEmpty() || c.getApellido().isEmpty()
                    || c.getTelefono().isEmpty() || c.getCorreo().isEmpty()
                    || c.getMensaje().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Completa todos los campos").show();
                return;
            }

            if (dao.registrar(c)) {
                view.limpiarFormulario();
                view.mostrarContactos(dao.listarContactos());
            } else {
                new Alert(Alert.AlertType.ERROR, "No se pudo registrar el contacto").show();
            }
        });
    }
}