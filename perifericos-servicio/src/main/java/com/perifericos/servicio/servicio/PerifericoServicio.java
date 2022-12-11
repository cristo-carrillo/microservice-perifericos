package com.perifericos.servicio.servicio;

import com.perifericos.servicio.entidades.Periferico;
import com.perifericos.servicio.repositorio.PerifericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerifericoServicio {

    @Autowired
    private PerifericoRepositorio perifericoRepositorio;

    public List<Periferico> getAll(){
        return perifericoRepositorio.findAll();
    }

    public Periferico getPerifericoById(int id){
        return perifericoRepositorio.findById(id).orElse(null);
    }

    public Periferico save(Periferico periferico){
        Periferico nuevoPeriferico = perifericoRepositorio.save(periferico);
        return nuevoPeriferico;
    }

    public List<Periferico> byUsuarioId(int usuarioId){
        return perifericoRepositorio.findByUsuarioId(usuarioId);
    }
}