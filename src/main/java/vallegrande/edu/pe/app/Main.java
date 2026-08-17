package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.controller.AutorController;
import vallegrande.edu.pe.controller.EditorialController;
import vallegrande.edu.pe.controller.GeneroLiterarioController;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.model.Autor;
import vallegrande.edu.pe.model.Editorial;
import vallegrande.edu.pe.model.GeneroLiterario;
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        AutorController autorController = new AutorController();
        EditorialController editorialController = new EditorialController();
        GeneroLiterarioController generoController = new GeneroLiterarioController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int idAutor = 1;
        int idEditorial = 1;
        int idGenero = 1;
        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Titulo:");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    //Validar datos
                    if (titulo.isEmpty() || autor.isEmpty() || anio <= 0) {
                        System.out.println("Datps no validos");
                    } else {
                        Libro libro = new Libro(id, titulo, autor, anio);
                        controller.agregarLibro(libro);
                    }
                    break;
                case 2:
                    controller.listarLibros();
                    break;
                case 3:
                    System.out.println("Ingrese Titulo o Autor");
                    String criterio = scanner.nextLine();
                    controller.buscarLibro(criterio);
                    break;
                case 4:
                    System.out.println("Nombre del autor:");
                    String nombreAutor = scanner.nextLine();

                    //Validar que el nombre no este vacio
                    if (nombreAutor.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio");
                    } else {
                        System.out.println("Nacionalidad:");
                        String nacionalidad = scanner.nextLine();
                        Autor nuevoAutor = new Autor(idAutor, nombreAutor, nacionalidad);
                        autorController.agregarAutor(nuevoAutor);
                        idAutor++;
                    }
                    break;
                case 5:
                    autorController.listarAutores();
                    break;
                case 6:
                    System.out.println("Nombre de la editorial:");
                    String nombreEditorial = scanner.nextLine();

                    //Validar que el nombre no este vacio
                    if (nombreEditorial.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio");
                    } else {
                        System.out.println("Pais:");
                        String pais = scanner.nextLine();
                        Editorial nuevaEditorial = new Editorial(idEditorial, nombreEditorial, pais);
                        editorialController.agregarEditorial(nuevaEditorial);
                        idEditorial++;
                    }
                    break;
                case 7:
                    editorialController.listarEditoriales();
                    break;
                case 8:
                    System.out.println("Nombre del genero:");
                    String nombreGenero = scanner.nextLine();

                    //Validar que el nombre no este vacio
                    if (nombreGenero.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio");
                    } else {
                        System.out.println("Descripcion:");
                        String descripcion = scanner.nextLine();
                        GeneroLiterario nuevoGenero = new GeneroLiterario(idGenero, nombreGenero, descripcion);
                        generoController.agregarGenero(nuevoGenero);
                        idGenero++;
                    }
                    break;
                case 9:
                    generoController.listarGeneros();
                    break;
                case 10:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 10);
        scanner.close();
    }

}