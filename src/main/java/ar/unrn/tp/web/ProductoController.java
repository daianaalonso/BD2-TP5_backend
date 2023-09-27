package ar.unrn.tp.web;

import ar.unrn.tp.api.ProductoService;
import ar.unrn.tp.modelo.Producto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(){
        return new ResponseEntity<>(productoService.)
    }*/
    // crear ProductoDTO?
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> modificarProducto(@PathVariable Long id, String descripcion, String codigo, Double precio, Long idMarca, Long idCategoria) {
        productoService.modificarProducto(
                id,
                descripcion,
                codigo,
                precio,
                idMarca,
                idCategoria
        );
        Map<String, String> response = new HashMap<>();
        response.put("result", "Producto modificado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
