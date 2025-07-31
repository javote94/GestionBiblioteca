import controllers.ApiResponse;
import controllers.LibroController;
import dao.DBHelper;
import dao.IDao;
import dao.impl.LibroDaoMySql;
import dtos.LibroDTO;
import entities.Libro;
import services.LibroService;
import services.impl.LibroServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear la tabla si no existe
        DBHelper.createTableIfNotExists();

        // Inicializar DAO, Service y Controller
        IDao<Libro> dao = new LibroDaoMySql();
        LibroService service = new LibroServiceImpl(dao);
        LibroController controller = new LibroController(service);

        System.out.println("------------------- AGREGAR LIBROS -------------------");
        LibroDTO libro1 = new LibroDTO(null, "El Principito", "Antoine de Saint-Exupéry", 1943, true);
        LibroDTO libro2 = new LibroDTO(null, "1984", "George Orwell", 1949, true);
        LibroDTO libro3 = new LibroDTO(null, "Cien años de soledad", "Gabriel García Márquez", 1967, true);
        ApiResponse<Void> res1 = controller.postLibro(libro1);
        ApiResponse<Void> res2 = controller.postLibro(libro2);
        ApiResponse<Void> res3 = controller.postLibro(libro3);
        printResponse("- POST [" + libro1.getTitulo() + "]: HTTP ", res1);
        printResponse("- POST [" + libro2.getTitulo() + "]: HTTP ", res2);
        printResponse("- POST [" + libro3.getTitulo() + "]: HTTP ", res3);


        System.out.println("\n------------------- CONSULAR LIBROS POR ID -------------------");
        ApiResponse<LibroDTO> get1 = controller.getLibro(1L);
        ApiResponse<LibroDTO> get2 = controller.getLibro(2L);
        ApiResponse<LibroDTO> get99 = controller.getLibro(99L);
        printResponse("- GET [ID 1]: HTTP ", get1);
        printResponse("- GET [ID 2]: HTTP ", get2);
        printResponse("- GET [ID 99]: HTTP ", get99);


        System.out.println("\n------------------- LISTAR TODOS LOS LIBROS -------------------");
        ApiResponse<List<LibroDTO>> all = controller.getAllLibros();
        printResponse("- GET [todos los libros]: HTTP ", all);


        System.out.println("\n------------------- ACTUALIZAR LIBRO -------------------");
        LibroDTO libroUpdate = new LibroDTO(1L, "El Principito (editado)", "Antoine de Saint-Exupéry", 1943, false);
        ApiResponse<Void> updateResponse = controller.putLibro(libroUpdate);
        printResponse("- PUT [ID 1]: HTTP ", updateResponse);

        // System.out.println("\n------------------- ELIMINAR LIBRO -------------------");
        // ApiResponse<Void> deleteResponse = controller.deleteLibro(2L);
        // printResponse("- DELETE [ID 2]: HTTP ", deleteResponse);

    }

    private static void printResponse(String label, ApiResponse response) {
        System.out.println(label + response.getStatusCode());

        Object data = response.getData();
        // Verificar si data es una lista o un único objeto LibroDTO
        if (data instanceof List<?> list) {
            list.stream()
                    .filter(LibroDTO.class::isInstance)
                    .map(LibroDTO.class::cast)
                    .forEach(Main::printLibro);
        } else if (data instanceof LibroDTO libro) {
            printLibro(libro);
        } else if (response.getError() != null) {
            System.out.println("Error: " + response.getError().getMessage());
        } else {
            System.out.println("Operación exitosa.");
        }
    }

    private static void printLibro(LibroDTO libro) {
        System.out.println("ID: " + libro.getId() +
                           " | Título: " + libro.getTitulo() +
                           " | Autor: " + libro.getAutor() +
                           " | Año: " + libro.getAnioPublicacion());
    }
}
