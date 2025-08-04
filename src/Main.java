import controllers.ApiResponse;
import controllers.LibroController;
import controllers.PrestamoController;
import controllers.UsuarioController;
import dao.DBHelper;
import dao.IDao;
import dao.impl.LibroDaoMySql;
import dao.impl.UsuarioDaoMySql;
import dtos.LibroDTO;
import dtos.PrestamoDTO;
import dtos.UsuarioDTO;
import entities.Libro;
import entities.Usuario;
import services.LibroService;
import services.PrestamoService;
import services.UsuarioService;
import services.impl.LibroServiceImpl;
import services.impl.PrestamoServiceImpl;
import services.impl.UsuarioServiceImpl;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear la tabla si no existe
        DBHelper.createTables();

        // Inicialización de DAOs
        IDao<Libro> libroDao = new LibroDaoMySql();
        IDao<Usuario> usuarioDao = new UsuarioDaoMySql();

        // Inicialización de Servicios
        LibroService libroService = new LibroServiceImpl(libroDao);
        UsuarioService usuarioService = new UsuarioServiceImpl(usuarioDao);
        PrestamoService prestamoService = new PrestamoServiceImpl(libroDao, usuarioDao);

        // Inicialización de Controladores
        LibroController libroController = new LibroController(libroService);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        PrestamoController prestamoController = new PrestamoController(prestamoService);

        System.out.println("------------------- AGREGAR USUARIOS -------------------");
        ApiResponse<UsuarioDTO> resUsuario1 = usuarioController.postUsuario(new UsuarioDTO(null, "Juan", "Pérez", "12345678", "juan@mail.com", "111-222-333"));
        ApiResponse<UsuarioDTO> resUsuario2 = usuarioController.postUsuario(new UsuarioDTO(null, "Ana", "Gómez", "87654321", "ana@mail.com", "444-555-666"));
        ApiResponse<UsuarioDTO> resUsuario3 = usuarioController.postUsuario(new UsuarioDTO(null, "Luis", "Martínez", "11223344", "luis@mail.com", "777-888-999"));
        ApiResponse<UsuarioDTO> resUsuarioError = usuarioController.postUsuario(new UsuarioDTO(null, "Carlos", "Sánchez", "99887766", "carlosmail.com", "000-111-222"));
        printResponse("- POST Usuario: HTTP ", resUsuario1);
        printResponse("- POST Usuario: HTTP ", resUsuario2);
        printResponse("- POST Usuario: HTTP ", resUsuario3);
        printResponse("- POST Usuario: HTTP ", resUsuarioError);


        System.out.println("------------------- AGREGAR LIBROS -------------------");
        ApiResponse<LibroDTO> resLibro1 = libroController.postLibro(new LibroDTO(null, "El Padrino", "Mario Puzo", 1969, true));
        ApiResponse<LibroDTO> resLibro2 = libroController.postLibro(new LibroDTO(null, "Harry Potter", "J.K. Rowling", 1997, true));
        ApiResponse<LibroDTO> resLibro3 = libroController.postLibro(new LibroDTO(null, "El Señor de los Anillos", "J.R.R. Tolkien", 1954, true));
        printResponse("- POST Libro: HTTP ", resLibro1);
        printResponse("- POST Libro: HTTP ", resLibro2);
        printResponse("- POST Libro: HTTP ", resLibro3);

        System.out.println("\n------------------- LISTAR LIBROS -------------------");
        ApiResponse<List<LibroDTO>> allLibros = libroController.getAllLibros();
        printResponse("- GET [todos los libros]: HTTP ", allLibros);


        System.out.println("\n------------------- PRESTAR LIBROS A USUARIOS -------------------");
        ApiResponse<Void> prestamo1 = prestamoController.postPrestamo(new PrestamoDTO(1L, 1L)); // Juan toma El Padrino
        ApiResponse<Void> prestamo2 = prestamoController.postPrestamo(new PrestamoDTO(2L, 2L)); // Ana toma Harry Potter
        ApiResponse<Void> prestamo3 = prestamoController.postPrestamo(new PrestamoDTO(3L, 3L)); // Luis toma El Señor de los Anillos
        printResponse("- POST Prestamo: HTTP ", prestamo1);
        printResponse("- POST Prestamo: HTTP ", prestamo2);
        printResponse("- POST Prestamo: HTTP ", prestamo3);

        System.out.println("\n------------------- DEVOLVER LIBROS -------------------");
        ApiResponse<Void> devolucion1 = prestamoController.devolver(1L); // Juan devuelve El Padrino
        ApiResponse<Void> devolucion2 = prestamoController.devolver(2L); // Ana devuelve Harry Potter
        printResponse("- POST Devolución: HTTP ", devolucion1);
        printResponse("- POST Devolución: HTTP ", devolucion2);

        System.out.println("\n------------------- OBTENER LIBRO POR ID -------------------");
        ApiResponse<LibroDTO> libroPorId = libroController.getLibro(3L); // Obtener El Señor de los Anillos
        printResponse("- GET Libro por ID: HTTP ", libroPorId);

    }

    private static void printResponse(String label, ApiResponse response) {
        System.out.println(label + response.getStatusCode());

        if (response.getError() != null) {
            System.out.println("Error: " + response.getError().getMessage());
            return;
        }

        Object data = response.getData();

        if (data instanceof List<?> list) {
            list.forEach(System.out::println);
        } else if (data != null) {
            System.out.println(data);
        } else {
            System.out.println("Operación exitosa.");
        }
    }

}
