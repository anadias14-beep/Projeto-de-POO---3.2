package br.ufla.gct052.biblioteca.model;

// Classe que representa a obra em si (ex: A história "Harry Potter")
public class Livro {
    
    // Identificador da obra (Substituindo o antigo ISBN)
    private String codigoDoLivro;
    // Título da obra
    private String titulo;

    // Construtor simples para preencher os dados do livro
    public Livro(String codigoDoLivro, String titulo) {
        this.codigoDoLivro = codigoDoLivro;
        this.titulo = titulo;
    }

    // Método para ler o código do livro
    public String getCodigoDoLivro() { 
        return codigoDoLivro; 
    }

    // Método para ler o título do livro
    public String getTitulo() { 
        return titulo; 
    }
}