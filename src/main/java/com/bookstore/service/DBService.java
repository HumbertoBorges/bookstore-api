package com.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repositories.CategoriaRepository;
import com.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 =  new Categoria(null, "Informática,", "Livros de TI");
		Categoria cat2 =  new Categoria(null, "Ficção Científica,", "Ficção Científica");
		Categoria cat3 =  new Categoria(null, "Biografia,", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Eng. Software", "Louis V. Gerstner", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "Spring Boot", "Michelli Brito", "Lorem Ipsum", cat2);
		Livro l4 = new Livro(null, "Angular", "Loiane Gronner", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "Javascript", "CFB Cursos", "Lorem Ipsum", cat2);
		
		cat1.getLivro().addAll(Arrays.asList(l1, l2));
		cat2.getLivro().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
