package com.perifericos.servicio.repositorio;

import com.perifericos.servicio.entidades.Periferico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerifericoRepositorio extends JpaRepository<Periferico, Integer> {

    List<Periferico> findByUsuarioId(int usuarioId);


}
