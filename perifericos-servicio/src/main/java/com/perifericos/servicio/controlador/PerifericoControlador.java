package com.perifericos.servicio.controlador;

import com.perifericos.servicio.entidades.Periferico;
import com.perifericos.servicio.servicio.PerifericoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/periferico")
@RestController
public class PerifericoControlador {

    @Autowired
    private PerifericoServicio perifericoServicio;

    @GetMapping
    public ResponseEntity<List<Periferico>> listarPerifericos(){
        List<Periferico> perifericos = perifericoServicio.getAll();
        if (perifericos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(perifericos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periferico> obtenerPeriferico(@PathVariable("id")int id){
        Periferico periferico = perifericoServicio.getPerifericoById(id);
        if (periferico == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(periferico);
    }

    @PostMapping
    public ResponseEntity<Periferico> guardarPeriferico(@RequestBody Periferico periferico){
        Periferico nuevoPeriferico = perifericoServicio.save(periferico);
        return ResponseEntity.ok(nuevoPeriferico);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Periferico>> listarPerifericosPorUsuarioId(@PathVariable("usuarioId")int id) {
        List<Periferico> perifericos =perifericoServicio.byUsuarioId(id);
        if (perifericos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(perifericos);
    }
}
