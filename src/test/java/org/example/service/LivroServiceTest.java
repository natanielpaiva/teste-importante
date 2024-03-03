package org.example.service;

import static org.mockito.Mockito.*;

import org.example.domain.Livro;
import org.example.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
// me siga em @natanieltech
public class LivroServiceTest {

    @Test
    public void testAdicionarLivro() {
        LivroRepository repositoryMock = mock(LivroRepository.class);
        LivroService service = new LivroService(repositoryMock);

        Livro novoLivro = new Livro();
        novoLivro.setTitulo("Test Driven Development");
        novoLivro.setAutor("Kent Beck");
        service.adicionarLivro(novoLivro);
        verify(repositoryMock).salvar(novoLivro);
    }

    @Test
    public void testEncontrarLivro() {
        LivroRepository repositoryMock = mock(LivroRepository.class);
        LivroService service = new LivroService(repositoryMock);

        Long livroId = 1L;
        Livro livro = new Livro();
        livro.setId(livroId);
        livro.setTitulo("Refactoring");
        livro.setAutor("Martin Fowler");
        when(repositoryMock.buscarPorId(livroId)).thenReturn(Optional.of(livro));
        Optional<Livro> encontrado = service.encontrarLivro(livroId);
        verify(repositoryMock).buscarPorId(livroId);
        assert(encontrado.isPresent() && encontrado.get().getId().equals(livroId));
    }

    @Test
    public void testRemoverLivro() {
        LivroRepository repositoryMock = mock(LivroRepository.class);
        LivroService service = new LivroService(repositoryMock);
        Long livroId = 2L;
        service.removerLivro(livroId);
        verify(repositoryMock).deletar(livroId);
    }
}

