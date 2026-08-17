package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {

    //Lista Contactos ( Almacenar )
    private ArrayList <Contacto> contactos;

    //Constructor
    public AgendaController(){
        contactos = new ArrayList<>();
    }

    //Agregar Contacto
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente");
    }

    //Listar Contactos
    public void listarContactos(){
        System.out.println("LISTA DE CONTACTOS");
        for ( Contacto contacto : contactos){
            contacto.mostrarContacto();
        }
    }

    //Buscar Contacto por nombre
    public void buscarContacto(String nombreBuscado){
        boolean encontrado = false;

        for (Contacto contacto : contactos){
            if (contacto.getNombres().equalsIgnoreCase(nombreBuscado)){
                contacto.mostrarContacto();
                encontrado = true;
            }
        }

        if (encontrado == false){
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    //Eliminar Contacto por nombre
    public void eliminarContacto(String nombreBuscado){
        boolean eliminado = false;

        for (int i = 0; i < contactos.size(); i++){
            if (contactos.get(i).getNombres().equalsIgnoreCase(nombreBuscado)){
                contactos.remove(i);
                eliminado = true;
                break;
            }
        }

        if (eliminado == true){
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }
}