package br.ufla.gct052.biblioteca.model;

// Importa a biblioteca de data simples do Java (Exigido no Projeto 3)
import java.time.LocalDate;

// Classe que anota quem pegou o que e quando
public class Emprestimo {
    
    // Usuário que fez o empréstimo
    private Usuario usuario;
    // Cópia física do livro pego
    private Exemplar exemplar;
    // Data em que a operação aconteceu
    private LocalDate dataDoEmprestimo;
    // Situação do empréstimo (ATIVO ou DEVOLVIDO)
    private StatusEmprestimo status;

    // Construtor para registrar o empréstimo
    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        // Pega automaticamente a data de hoje no computador
        this.dataDoEmprestimo = LocalDate.now();
        // O empréstimo começa marcado como ATIVO
        this.status = StatusEmprestimo.ATIVO;
    }
    
    // Gera um texto explicativo para mostrar na tela do JOptionPane
    public String obterResumo() {
        return "Usuário: " + usuario.getNome() + "\nLivro: " + exemplar.getLivro().getTitulo() + "\nData: " + dataDoEmprestimo;
    }
}