import java.util.ArrayList;

public class MiembroPremium extends Usuario {
    private ArrayList<Libro> librosReservados;

    public MiembroPremium(String nombre) {
        super(nombre);
        this.librosReservados = new ArrayList<>();
    }

    public void reservarLibro(Libro libro) {
        if (libro.isDisponible()) {
            tomarPrestado(libro.getTitulo());
        } else {
            librosReservados.add(libro);
        }
    }

    @Override
    public void imprimirEstado() {
        super.imprimirEstado();
        System.out.println("Libros reservados por " + getNombre() + ":");
        for (Libro libro : librosReservados) {
            System.out.println(libro.getTitulo());
        }
    }
}

