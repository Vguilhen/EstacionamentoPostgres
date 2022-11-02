package org.example.dao;

import org.example.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroDaoInterface {

    Carro save(Carro carro);

    Carro update(Carro carro);

    void delete(Long id);

    List<Carro> findAll();

    Optional<Carro> findById(Long id);

    Optional<Carro> findByPlaca(String placa);
}
