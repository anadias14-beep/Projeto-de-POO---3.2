package br.ufla.gct052.biblioteca.model;

// Classe base (mãe) para todos os usuários
public abstract class Usuario {
    
    // Matrícula do usuário
    private String matricula;
    // Nome do usuário
    private String nome;
    // Novo e-mail exigido no Projeto 3
    private String email;
    // Quantos livros ele tem emprestados no momento
    private int quantidadeEmprestada;

    // Construtor para registrar os dados básicos
    public Usuario(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.quantidadeEmprestada = 0; // Começa sem nenhum livro
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    // Soma 1 livro na conta do usuário
    public void pegarLivro() { 
        quantidadeEmprestada++; 
    }

    // Subtrai 1 livro na conta do usuário quando ele devolve
    public void devolverLivro() {
        if (quantidadeEmprestada > 0) quantidadeEmprestada--;
    }

    // Verifica se ele ainda não estourou o limite dele
    public boolean podePegarMaisLivros() {
        return quantidadeEmprestada < getLimiteEmprestimos();
    }

    // Método abstrato: cada filho vai dizer o seu limite (Polimorfismo)
    public abstract int getLimiteEmprestimos();
    public abstract String getId();
}