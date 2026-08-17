package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Autor;
import java.util.ArrayList;

public class AutorController {

    //Lista donde almacenaremos nuestros autores
    private ArrayList<Autor> autores;

    //Constructor
    public AutorController(){
        autores = new ArrayList<>();
    }

    //Registrar
    public void agregarAutor(Autor autor){
        autores.add(autor);
        System.out.println("Autor registrado correctamente");
    }

    //Listar
    public void listarAutores(){
        if(autores.isEmpty()){
            System.out.println("No hay autores registrados");
            return;
        }
        System.out.println("LISTA DE AUTORES");
        for (Autor autor : autores){
            autor.mostrarAutor();
        }
    }
}