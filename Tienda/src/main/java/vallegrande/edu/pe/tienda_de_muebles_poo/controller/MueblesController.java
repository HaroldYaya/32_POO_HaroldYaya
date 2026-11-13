package vallegrande.edu.pe.tienda_de_muebles_poo.controller;

import javafx.collections.ObservableList;
import vallegrande.edu.pe.tienda_de_muebles_poo.model.Muebles;
import vallegrande.edu.pe.tienda_de_muebles_poo.model.MueblesDao;

public class MueblesController {

    private final MueblesDao dao = new MueblesDao();

    public void registrarMueble(Muebles m) { dao.registrar(m); }

    public ObservableList<Muebles> listarMuebles() { return dao.listar(); }

    public void actualizarMueble(Muebles m) { dao.actualizar(m); }

    public void eliminarMueble(int id) { dao.eliminar(id); }
}
