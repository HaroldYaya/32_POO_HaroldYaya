package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AgendaView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Crear los componentes
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();
        Scanner sc = new Scanner(System.in);

        //Mostrar Informacion
        view.mostrarTitulo();

        //Crear contactos (mínimo 5 para la tarea)
        Contacto contacto1 = new Contacto(1, "Ana", "Torres", "Cañete", "983745656", "ana@gmail.com");
        Contacto contacto2 = new Contacto(2, "Carlos", "Perez", "Imperial", "951264456", "carlos@gmail.com");
        Contacto contacto3 = new Contacto(3, "Maria", "Fernandez", "San Vicente", "965432109", "maria@gmail.com");
        Contacto contacto4 = new Contacto(4, "Pedro", "Sanchez", "Nuevo Imperial", "954321098", "pedro@gmail.com");
        Contacto contacto5 = new Contacto(5, "Carla", "Rojas", "Cerro Azul", "943210987", "carla@gmail.com");

        //Agregar contactos
        controller.agregarContacto(contacto1);
        controller.agregarContacto(contacto2);
        controller.agregarContacto(contacto3);
        controller.agregarContacto(contacto4);
        controller.agregarContacto(contacto5);

        //Ciclo del menú
        int opcion = 0;

        while (opcion != 5){

            opcion = view.mostrarMenu();

            if (opcion == 1){
                //Registrar
                System.out.print("Nombres: ");
                String nombres = sc.nextLine();
                System.out.print("Apellidos: ");
                String apellidos = sc.nextLine();
                System.out.print("Direccion: ");
                String direccion = sc.nextLine();
                System.out.print("Telefono: ");
                String telefono = sc.nextLine();
                System.out.print("Correo: ");
                String correo = sc.nextLine();

                Contacto nuevo = new Contacto(6, nombres, apellidos, direccion, telefono, correo);
                controller.agregarContacto(nuevo);

            } else if (opcion == 2){
                //Listar
                controller.listarContactos();

            } else if (opcion == 3){
                //Buscar
                System.out.print("Escribe el nombre a buscar: ");
                String nombreBuscado = sc.nextLine();
                controller.buscarContacto(nombreBuscado);

            } else if (opcion == 4){
                //Eliminar
                System.out.print("Escribe el nombre del contacto a eliminar: ");
                String nombreEliminar = sc.nextLine();
                controller.eliminarContacto(nombreEliminar);

            } else if (opcion == 5){
                view.mostrarMensaje("Saliendo del programa...");

            } else {
                view.mostrarMensaje("Opción inválida, intenta de nuevo.");
            }
        }
    }
}