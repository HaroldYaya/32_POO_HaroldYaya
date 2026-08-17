package vallegrande.edu.pe.view;

import java.util.Scanner;

public class AgendaView {

    Scanner sc = new Scanner(System.in);

    //Mostrar Titulo
    public void mostrarTitulo() {
        System.out.println("---------------------------");
        System.out.println("AGENDA DE CONTACTOS");
        System.out.println("---------------------------");
    }

    //Mostrar Mensaje
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    //Mostrar el menú y devolver la opción elegida
    public int mostrarMenu(){
        System.out.println("");
        System.out.println("1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar el enter que queda pendiente
        return opcion;
    }
}