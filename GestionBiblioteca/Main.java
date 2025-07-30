import controllers.ApiResponse;
import controllers.LibroController;
import daos.LibroDAO;
import dtos.LibroDTO;
import services.LibroServiceImpl;

public class Main {
    public static void main(String[] args) {


        LibroDAO dao = new LibroDAO();
        LibroServiceImpl service = new LibroServiceImpl(dao);
        LibroController controller = new LibroController(service);


        System.out.println("Agregando libros...");
        ApiResponse res1 = controller.postLibro(new LibroDTO(null, "El Principito", "Saint-Exupéry", 1943));
        ApiResponse res2 = controller.postLibro(new LibroDTO(null, "1984", "George Orwell", 1949));
        ApiResponse res3 = controller.postLibro(new LibroDTO(null, "Sin título", "Desconocido", 2020));

        printResponse("POST libro 1", res1);
        printResponse("POST libro 2", res2);
        printResponse("POST libro 3", res3);


        System.out.println("\nConsultando libros por ID...");

        ApiResponse get1 = controller.getLibro(1);
        printResponse("GET libro ID 1", get1);

        ApiResponse get2 = controller.getLibro(2);
        printResponse("GET libro ID 2", get2);

        ApiResponse get99 = controller.getLibro(99);
        printResponse("GET libro ID 99 (no existe)", get99);
    }

    private static void printResponse(String label, ApiResponse response) {
        System.out.println(label + ": HTTP " + response.getStatusCode());

        if (response.getError() != null) {
            System.out.println("Error: " + response.getError().getMessage());
        } else if (response.getData() != null) {
            for (LibroDTO libro : response.getData()) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() +
                        " (" + libro.getAnioPublicacion() + ")");
            }
        } else {
            System.out.println("Operación exitosa.");
        }
    }
}
