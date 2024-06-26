package model;


/**
 *
 * @author Antonio Sanchez
 */
public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio_publicacion;
    private String isbn;

    public Libro(int id, String titulo, String autor, String editorial, int anio_publicacion, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio_publicacion = anio_publicacion;
        this.isbn = isbn;
    }

    public Libro(String titulo, String autor, String editorial, int anio_publicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio_publicacion = anio_publicacion;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
