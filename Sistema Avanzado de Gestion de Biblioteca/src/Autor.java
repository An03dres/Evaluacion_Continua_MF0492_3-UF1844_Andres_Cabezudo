import java.util.ArrayList;

public class Autor {
    private String nombre;
    private ArrayList<Libro> libros;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();

    }

    public Libro agregarLibro(String titulo) {
        Libro libro =  new Libro(titulo, this);
        this.libros.add(libro);
        System.out.println("El libro '" + titulo + "' ha sido publicado por " + this.getNombre());
        return libro;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public void imprimirEstado() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Libros publicados:");
        for (Libro libro : this.getLibros()) {
            System.out.println("- " + libro.getTitulo());
        }
    }
}