public class Main {
    public static void main(String[] args) {
        // Crear autores
        Autor autor1 = new Autor("Gabriel García Márquez");
        Autor autor2 = new Autor("J.K. Rowling");
        // [{nombre: "Gabriel García Márquez", libros: []}, {nombre: "J.K. Rowling", libros: []}]

        // Crear libros
        Libro libro1 = autor1.agregarLibro("Cien años de soledad");
        Libro libro2 = autor1.agregarLibro("El amor en los tiempos del cólera");
        Libro libro3 = autor2.agregarLibro("Harry Potter y la piedra filosofal");
        // [{nombre: "Gabriel García Márquez", libros: [{titulo: "Cien años de soledad", autor: "Gabriel García Márquez", disponible: true}, {titulo: "El amor en los tiempos del cólera", autor: "Gabriel García Márquez", disponible: true}]}, {nombre: "J.K. Rowling", libros: [{titulo: "Harry Potter y la piedra filosofal", autor: "J.K. Rowling", disponible: true}]}]

        // Crear usuarios
        Usuario usuario = new Usuario("Omar");
        MiembroPremium miembroPremium = new MiembroPremium("Luis");
        // [{nombre: "Omar", librosPrestados: {}}, {nombre: "Luis", librosPrestados: {}, librosReservados: {}}]

        // Usuario toma prestado y devuelve un libro
        usuario.tomarPrestado(libro1.getTitulo());
        usuario.devolverLibro(libro1.getTitulo());

        // MiembroPremium reserva un libro no disponible
        miembroPremium.reservarLibro(libro2);

        // MiembroPremium va a reservar un libro que se encuentra disponible y por lo tanto lo toma prestado
        miembroPremium.reservarLibro(libro3);

        // Imprimir los libros reservados por miembroPremium
        miembroPremium.imprimirEstado();

        // Mostrar cada vez que un libro está disponible o deja de estarlo
        Libro[] libros = {libro1, libro2, libro3};
        for (Libro libro : libros) {
            System.out.println("El libro '" + libro.getTitulo() + "' está " + (libro.isDisponible() ? "disponible" : "no disponible"));
        }
        // Crear arrays de autores y usuarios
        Autor[] autores = {autor1, autor2};
        Usuario[] usuarios = {usuario, miembroPremium};

        // Imprimir el estado del sistema
        System.out.println("\nEstado actual del sistema:");
        System.out.println("\nAutores:");
        for (Autor autor : autores) {
            autor.imprimirEstado();
        }
        System.out.println("\nUsuarios:");
        for (Usuario usr : usuarios) {
            usr.imprimirEstado();
        }
    }
}
