package br.ufla.gct052.biblioteca.model; // Declara o pacote correspondente à estrutura de pastas do projeto

// Aluno herda tudo o que a classe Usuario tem através da palavra-chave extends
public class Aluno extends Usuario {

    // Atributos privados específicos da classe Aluno para armazenar seus dados em memória
    private String matricula; // Variável para armazenar o número de matrícula do aluno
    private String nome;      // Variável para armazenar o nome completo do aluno
    private String email;     // Variável para armazenar o endereço de e-mail do aluno
    private String curso;     // Variável para armazenar o nome do curso do aluno
    private String periodo;   // Variável para armazenar o período/semestre atual do aluno

    // Construtor que recebe as informações necessárias para inicializar um objeto Aluno
    public Aluno(String matricula, String nome, String email, String curso, String periodo) {
        super(matricula, nome, email); // Repassa obrigatoriamente a matrícula, nome e e-mail para o construtor da classe mãe (Usuario)
        
        // Atribui os parâmetros recebidos no construtor diretamente às variáveis locais da classe filha (O que estava faltando)
        this.matricula = matricula; // Guarda o parâmetro matricula na variável de instância local matricula
        this.nome = nome;           // Guarda o parâmetro nome na variável de instância local nome
        this.email = email;         // Guarda o parâmetro email na variável de instância local email
        this.curso = curso;         // Guarda o parâmetro curso na variável de instância local curso
        this.periodo = periodo;     // Guarda o parâmetro periodo na variável de instância local periodo
    } // Fim do construtor de Aluno

    @Override // Indica ao compilador que estamos sobrescrevendo o método getId da classe mãe
    public String getId(){ // Método público que devolve a identificação única do Aluno
        return matricula; // Retorna o valor contido na variável local matricula (que agora não é mais nula)
    } // Fim do método getId

    // Define que o limite do Aluno são 3 livros
    @Override // Indica ao compilador que estamos sobrescrevendo o método getLimiteEmprestimos da classe mãe
    public int getLimiteEmprestimos(){ // Método público que estabelece o limite máximo de livros que este tipo de usuário pode pegar
        return 3; // Retorna o valor fixo de 3 empréstimos simultâneos
    } // Fim do método getLimiteEmprestimos
} // Fim da classe Aluno