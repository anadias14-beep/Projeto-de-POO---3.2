package br.ufla.gct052.biblioteca.model;

// Classe que representa a cópia física em papel na estante
public class Exemplar {
    
    // Código de barras colado no livro físico
    private String codigoFisico;
    // Qual obra/livro este objeto de papel representa
    private Livro livro;
    // Se está disponível ou emprestado
    private StatusExemplar status;

    // Construtor simples para criar a cópia física
    public Exemplar(String codigoFisico, Livro livro) {
        this.codigoFisico = codigoFisico;
        this.livro = livro;
        // Todo exemplar novo guardado na estante começa como DISPONIVEL
        this.status = StatusExemplar.DISPONIVEL;
    }

    // Retorna o código de barras físico do exemplar
    public String getCodigoFisico() { 
        return codigoFisico; 
    }

    // Retorna a obra vinculada a este exemplar
    public Livro getLivro() { 
        return livro; 
    }

    // Retorna a situação atual (DISPONIVEL ou EMPRESTADO)
    public StatusExemplar getStatus() { 
        return status; 
    }

    // Método para mudar o status para EMPRESTADO
    public void emprestar() {
        this.status = StatusExemplar.EMPRESTADO;
    }

    // Método para mudar o status de volta para DISPONIVEL
    public void devolver() {
        this.status = StatusExemplar.DISPONIVEL;
    }
}