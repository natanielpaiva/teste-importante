package org.example.service;

import org.example.domain.Livro;
import org.example.repository.LivroRepository;

import java.util.Optional;

public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public void adicionarLivro(Livro livro) {
        repository.salvar(livro);
    }

    public Optional<Livro> encontrarLivro(Long id) {
        return repository.buscarPorId(id);
    }

    public void removerLivro(Long id) {
        repository.deletar(id);
    }
}

