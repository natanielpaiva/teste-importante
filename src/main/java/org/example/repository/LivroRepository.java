package org.example.repository;

import org.example.domain.Livro;

import java.util.Optional;

public interface LivroRepository {
    void salvar(Livro livro);
    Optional<Livro> buscarPorId(Long id);
    void deletar(Long id);
}
