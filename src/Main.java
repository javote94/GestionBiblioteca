import controllers.ApiResponse;
import controllers.LibroController;
import dao.IDao;
import dao.impl.LibroDaoMySql;
import dtos.LibroDTO;
import entities.Libro;
import services.LibroService;
import services.impl.LibroServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IDao<Libro> dao = new LibroDaoMySql();
        LibroService service = new LibroServiceImpl(dao);
        LibroController controller = new LibroController(service);

        System.out.println("Agregando libros...");
        ApiResponse<Void> res1 = controller.postLibro(new LibroDTO(null, "El Principito", "Saint-Exupéry", 1943, true));
        ApiResponse<Void> res2 = controller.postLibro(new LibroDTO(null, "1984", "George Orwell", 1949, true));
        ApiResponse<Void> res3 = controller.postLibro(new LibroDTO(null, "Sin título", "Desconocido", 2020, true));

        printResponse("POST libro 1", res1);
        printResponse("POST libro 2", res2);
        printResponse("POST libro 3", res3);

        System.out.println("\nConsultando libros por ID...");

        ApiResponse<LibroDTO> get1 = controller.getLibro(1L);
        printResponse("GET libro ID 1", get1);

        ApiResponse<LibroDTO> get2 = controller.getLibro(2L);
        printResponse("GET libro ID 2", get2);

        ApiResponse<LibroDTO> get99 = controller.getLibro(99L);
        printResponse("GET libro ID 99 (no existe)", get99);


        // Listar todos los libros
        ApiResponse<List<LibroDTO>> all = controller.getAllLibros();
        printResponse("GET todos los libros", all);

        // Actualizar libro
        LibroDTO actualizado = new LibroDTO(1L, "El Principito (Editado)", "Saint-Exupéry", 1943, true);
        ApiResponse<Void> update = controller.putLibro(actualizado);
        printResponse("PUT libro 1", update);

        // Eliminar libro
        ApiResponse<Void> delete = controller.deleteLibro(2L);
        printResponse("DELETE libro 2", delete);


    }

    private static void printResponse(String label, ApiResponse response) {
        System.out.println(label + ": HTTP " + response.getStatusCode());

        if (response.getError() != null) {
            System.out.println("Error: " + response.getError().getMessage());
        } else if (response.getData() != null) {
            Object data = response.getData();
            if (data instanceof LibroDTO libro) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAnioPublicacion() + ")");
            } else {
                System.out.println("Operación exitosa.");
            }
        } else {
            System.out.println("Operación exitosa.");
        }
    }
}
