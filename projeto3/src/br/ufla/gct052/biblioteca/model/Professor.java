package br.ufla.gct052.biblioteca.model; // Declara o pacote correspondente à estrutura de pastas do projeto

// Professor também herda tudo de Usuario através da palavra-chave extends
public class Professor extends Usuario {

    // Dados específicos do Professor declarados como atributos privados da classe
    private String id;           // Variável para armazenar o identificador único do professor (ex: "123456")
    private String nome;         // Variável para armazenar o nome do professor (ex: "João da Silva")
    private String email;        // Variável para armazenar o e-mail do professor
    private String departamento; // Variável para armazenar o departamento em que leciona (ex: "Ciência da Computação")
    private String titulacao;    // Variável para armazenar o nível acadêmico (ex: "Doutor", "Mestre")

    // Construtor que recebe os dados necessários para inicializar um objeto Professor
    public Professor(String id, String nome, String email, String departamento, String titulacao) {
        super(id, nome, email); // Repassa obrigatoriamente o id, nome e e-mail para o construtor da classe mãe (Usuario)

        // Validação de segurança: Impede a criação de um departamento inválido (nulo ou em branco)
        if (departamento == null || departamento.isBlank()) // Se o departamento não foi informado ou está vazio...
            throw new IllegalArgumentException("Departamento não pode ser vazio."); // Dispara uma exceção interrompendo o programa com uma mensagem de erro

        // Validação de segurança: Impede a criação de uma titulação inválida (nula ou em branco)
        if (titulacao == null || titulacao.isBlank()) // Se a titulação não foi informada ou está vazia...
            throw new IllegalArgumentException("Titulação não pode ser vazia."); // Dispara uma exceção interrompendo o programa com uma mensagem de erro

        // Atribui os parâmetros recebidos no construtor diretamente às variáveis locais da classe (O que estava faltando)
        this.id = id;                     // Guarda o parâmetro id na variável de instância local id
        this.nome = nome;                 // Guarda o parâmetro nome na variável de instância local nome
        this.email = email;               // Guarda o parâmetro email na variável de instância local email
        this.departamento = departamento; // Guarda o parâmetro departamento na variável de instância local departamento
        this.titulacao    = titulacao;    // Guarda o parâmetro titulacao na variável de instância local titulacao
    } // Fim do construtor de Professor

    // Método público getter para dar acesso de leitura ao departamento fora da classe
    public String getDepartamento() { return departamento; } // Devolve o conteúdo da variável privada departamento
    
    // Método público getter para dar acesso de leitura à titulação fora da classe
    public String getTitulacao()    { return titulacao; } // Devolve o conteúdo da variável privada titulacao

    @Override // Indica ao compilador que estamos sobrescrevendo o método getId da classe mãe
    public String getId(){ // Método público que devolve a identificação única do Professor
        return id; // Retorna o valor contido na variável local id (que agora não é mais nula)
    } // Fim do método getId

    // Professor pode ter no máximo 5 livros ao mesmo tempo
    @Override // Indica ao compilador que estamos sobrescrevendo o método getLimiteEmprestimos da classe mãe
    public int getLimiteEmprestimos() { // Método público que estabelece o limite máximo de livros que o professor pode pegar
        return 5; // Retorna o valor fixo de 5 empréstimos simultâneos
    } // Fim do método getLimiteEmprestimos
} // Fim da classe Professor