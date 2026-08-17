package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.GeneroLiterario;
import java.util.ArrayList;

public class GeneroLiterarioController {

    //Lista donde almacenaremos nuestros generos
    private ArrayList<GeneroLiterario> generos;

    //Constructor
    public GeneroLiterarioController(){
        generos = new ArrayList<>();
    }

    //Registrar
    public void agregarGenero(GeneroLiterario genero){
        generos.add(genero);
        System.out.println("Genero literario registrado correctamente");
    }

    //Listar
    public void listarGeneros(){
        if(generos.isEmpty()){
            System.out.println("No hay generos registrados");
            return;
        }
        System.out.println("LISTA DE GENEROS LITERARIOS");
        for (GeneroLiterario genero : generos){
            genero.mostrarGenero();
        }
    }
}