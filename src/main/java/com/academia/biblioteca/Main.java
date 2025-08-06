package com.academia.biblioteca;

import com.academia.biblioteca.controllers.ApiResponse;
import com.academia.biblioteca.controllers.LibroController;
import com.academia.biblioteca.controllers.PrestamoController;
import com.academia.biblioteca.controllers.UsuarioController;
import com.academia.biblioteca.dao.hibernate.impl.LibroDaoHibernateMySql;
import com.academia.biblioteca.dao.hibernate.impl.UsuarioDaoHibernateMySql;
import com.academia.biblioteca.dao.IDao;
import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.dtos.PrestamoDTO;
import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.entities.Libro;
import com.academia.biblioteca.entities.Usuario;
import com.academia.biblioteca.services.LibroService;
import com.academia.biblioteca.services.PrestamoService;
import com.academia.biblioteca.services.UsuarioService;
import com.academia.biblioteca.services.impl.LibroServiceImpl;
import com.academia.biblioteca.services.impl.PrestamoServiceImpl;
import com.academia.biblioteca.services.impl.UsuarioServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicialización de DAOs
        IDao<Libro> libroDao = new LibroDaoHibernateMySql();
        IDao<Usuario> usuarioDao = new UsuarioDaoHibernateMySql();

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
        ApiResponse<Void> prestamo1 = prestamoController.postPrestamo(new PrestamoDTO(resLibro1.getData(), resUsuario1.getData())); // Juan toma El Padrino
        ApiResponse<Void> prestamo2 = prestamoController.postPrestamo(new PrestamoDTO(resLibro2.getData(), resUsuario2.getData())); // Ana toma Harry Potter
        ApiResponse<Void> prestamo3 = prestamoController.postPrestamo(new PrestamoDTO(resLibro3.getData(), resUsuario3.getData())); // Luis toma El Señor de los Anillos
        printResponse("- POST Prestamo: HTTP ", prestamo1);
        printResponse("- POST Prestamo: HTTP ", prestamo2);
        printResponse("- POST Prestamo: HTTP ", prestamo3);

        System.out.println("\n------------------- DEVOLVER LIBROS -------------------");
        ApiResponse<Void> devolucion1 = prestamoController.devolver(resLibro1.getData()); // Juan devuelve El Padrino
        ApiResponse<Void> devolucion2 = prestamoController.devolver(resLibro2.getData()); // Ana devuelve Harry Potter
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
