package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Editorial;
import java.util.ArrayList;

public class EditorialController {

    //Lista donde almacenaremos nuestras editoriales
    private ArrayList<Editorial> editoriales;

    //Constructor
    public EditorialController(){
        editoriales = new ArrayList<>();
    }

    //Registrar
    public void agregarEditorial(Editorial editorial){
        editoriales.add(editorial);
        System.out.println("Editorial registrada correctamente");
    }

    //Listar
    public void listarEditoriales(){
        if(editoriales.isEmpty()){
            System.out.println("No hay editoriales registradas");
            return;
        }
        System.out.println("LISTA DE EDITORIALES");
        for (Editorial editorial : editoriales){
            editorial.mostrarEditorial();
        }
    }
}