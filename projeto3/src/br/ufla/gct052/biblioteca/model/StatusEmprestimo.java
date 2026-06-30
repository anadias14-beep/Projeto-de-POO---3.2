package br.ufla.gct052.biblioteca.model;

// Cria um tipo especial com opções fixas para o empréstimo
public enum StatusEmprestimo {
    // Opção 1: O usuário ainda está com o livro
    ATIVO,      
    // Opção 2: O usuário já devolveu o livro
    DEVOLVIDO   
}