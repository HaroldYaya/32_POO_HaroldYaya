package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.Perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {
    private PerfilView view;

    public PerfilController(PerfilView view){
        this.view = view;
        view.getBtnMostrar().setOnAction(e -> mostrarPerfil());
        view.getBtnLimpiar().setOnAction(e -> limpiarCampos());
    }

    private void mostrarPerfil(){
        String nombre = view.getTxtNombre().getText();

        if (nombre == null || nombre.trim().isEmpty()) {
            view.getLblResultado().setStyle("-fx-text-fill: #cc0000; -fx-font-size: 14px;");
            view.getLblResultado().setText("⚠ El campo Nombre no puede estar vacío.");
            return;
        }

        String carrera = view.getTxtCarrera().getText();
        String semestre = view.getTxtSemestre().getText();
        String datoAdicional = view.getTxtDatoAdicional().getText();

        Perfil perfil = new Perfil(
                nombre,
                carrera,
                semestre,
                datoAdicional
        );

        view.getLblResultado().setStyle("-fx-text-fill: #333333; -fx-font-size: 14px;");
        view.getLblResultado().setText(perfil.obtenerPresentacion());
    }

    private void limpiarCampos(){
        view.getTxtNombre().clear();
        view.getTxtCarrera().clear();
        view.getTxtSemestre().clear();
        view.getTxtDatoAdicional().clear();
        view.getLblResultado().setText("");
    }
}