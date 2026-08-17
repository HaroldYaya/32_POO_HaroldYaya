package vallegrande.edu.pe.view;

public class BibliotecaView {
    //TITULO
    public void mostrarTitulo(){
        System.out.println("=================");
        System.out.println("SISTEMA DE BIBLIOTECA VG");
        System.out.println("=================");
    }
    //MENU
    public void mostrarMenu(){
        System.out.println("1. Registrar Libro");
        System.out.println("2. Listar Libro");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Registrar Autor");
        System.out.println("5. Listar Autor");
        System.out.println("6. Registrar Editorial");
        System.out.println("7. Listar Editorial");
        System.out.println("8. Registrar Genero Literario");
        System.out.println("9. Listar Genero Literario");
        System.out.println("10. Salir");
        System.out.println("Seleccione una opcion");
    }
    //MENSAJE
    public void mostrarMensaje( String mensaje){
        System.out.println(mensaje);
    }
}