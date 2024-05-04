import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Libro> librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public void tomarPrestado(String nombreLibro) {
        for (Libro libro : Libro.getListaTotalLibros()) {
            if (libro.getTitulo().equals(nombreLibro) && libro.isDisponible()) {
                libro.marcarPrestado();
                this.librosPrestados.add(libro);
                System.out.println(this.nombre + " ha tomado prestado el libro '" + nombreLibro + "'");
                return;
            }
        }
        System.out.println("El libro '" + nombreLibro + "' no está disponible");
    }

    public void devolverLibro(String nombreLibro) {
        Libro libroARemover = null;
        for (Libro libro : this.librosPrestados) {
            if (libro.getTitulo().equals(nombreLibro)) {
                libroARemover = libro;
                libro.marcarDevuelto();
                System.out.println(this.nombre + " ha devuelto el libro '" + nombreLibro + "'");
                break;
            }
        }
        if (libroARemover != null) {
            this.librosPrestados.remove(libroARemover);
        } else {
            System.out.println(this.nombre + " no tiene el libro '" + nombreLibro + "'");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return this.librosPrestados;
    }

    public void imprimirEstado() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Libros prestados:");
        for (Libro libro : this.getLibrosPrestados()) {
            System.out.println("- " + libro.getTitulo());
        }
    }
}
