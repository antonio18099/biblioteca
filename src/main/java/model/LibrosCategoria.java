package model;


/**
 *
 * @author Antonio Sanchez
 */
public class LibrosCategoria {

    private int idLibro;
    private int idCategoria;

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public LibrosCategoria(int idLibro, int idCategoria) {
        this.idLibro = idLibro;
    }
}
