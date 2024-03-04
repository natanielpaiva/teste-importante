package org.example.repository;

import org.example.domain.Livro;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LivroRepositoryImpl implements LivroRepository {
    private final Map<Long, Livro> livros = new HashMap<>();

    @Override
    public void salvar(Livro livro) {
        livros.put(livro.getId(), livro);
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        return Optional.ofNullable(livros.get(id));
    }

    @Override
    public void deletar(Long id) {
        livros.remove(id);
    }
}
