import java.util.*;

public class Libro {
    private String titulo;
    private Autor autor;
    private boolean disponible;
    private static List<Libro> lista_total_libros = new ArrayList<>();


    public Libro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        lista_total_libros.add(this);
    }

    public void marcarPrestado() {
        this.disponible = false;
    }

    public void marcarDevuelto() {
        this.disponible = true;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public static List<Libro> getListaTotalLibros() {
        return lista_total_libros;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor.getNombre() + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
