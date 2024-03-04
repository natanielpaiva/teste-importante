package org.example;

import org.example.domain.Livro;
import org.example.repository.LivroRepositoryImpl;
import org.example.service.LivroService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        LivroService livroService = new LivroService(new LivroRepositoryImpl());
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("aaa");
        livro.setAutor("Nataniel Paiva");
        livroService.adicionarLivro(livro);

        Optional<Livro> livroEncontrado = livroService.encontrarLivro(1L);


        System.out.println(livroEncontrado.get().getAutor());
    }
}