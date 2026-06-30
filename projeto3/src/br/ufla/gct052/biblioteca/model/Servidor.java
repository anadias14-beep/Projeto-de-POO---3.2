package br.ufla.gct052.biblioteca.model; // Declara o pacote correspondente à estrutura de pastas do projeto

// Servidor também herda de Usuario através da palavra-chave extends
public class Servidor extends Usuario {

    // Dados específicos do Servidor declarados como atributos privados da classe
    private String id;    // Variável para armazenar o identificador único do servidor (ex: "123456")
    private String nome;  // Variável para armazenar o nome do servidor (ex: "Maria Oliveira")
    private String email; // Variável para armazenar o e-mail corporativo do servidor
    private String setor; // Variável para armazenar o setor de lotação (ex: "Biblioteca Central")
    private String cargo; // Variável para armazenar a função exercida (ex: "Bibliotecário", "Técnico")

    // Construtor que recebe os dados necessários para inicializar um objeto Servidor
    public Servidor(String id, String nome, String email, String setor, String cargo) {
        super(id, nome, email); // Repassa obrigatoriamente o id, nome e e-mail para o construtor da classe mãe (Usuario)

        // Validação de segurança: Impede a criação de um objeto com setor inválido (nulo ou em branco)
        if (setor == null || setor.isBlank()) // Se o setor não foi informado ou está totalmente em branco...
            throw new IllegalArgumentException("Setor não pode ser vazio."); // Dispara um erro interrompendo o programa imediatamente

        // Validação de segurança: Impede a criação de um objeto com cargo inválido (nulo ou em branco)
        if (cargo == null || cargo.isBlank()) // Se o cargo não foi informado ou está totalmente em branco...
            throw new IllegalArgumentException("Cargo não pode ser vazio."); // Dispara um erro interrompendo o programa imediatamente

        // Atribui os parâmetros recebidos no construtor diretamente às variáveis locais da classe (O que estava faltando)
        this.id = id;       // Guarda o parâmetro id na variável de instância local id
        this.nome = nome;   // Guarda o parâmetro nome na variável de instância local nome
        this.email = email; // Guarda o parâmetro email na variável de instância local email
        this.setor = setor; // Guarda o parâmetro setor na variável de instância local setor
        this.cargo = cargo; // Guarda o parâmetro cargo na variável de instância local cargo
    } // Fim do construtor de Servidor

    // Método público getter para dar acesso de leitura ao setor fora da classe
    public String getSetor() { return setor; } // Devolve o conteúdo da variável privada setor
    
    // Método público getter para dar acesso de leitura ao cargo fora da classe
    public String getCargo() { return cargo; } // Devolve o conteúdo da variável privada cargo

    @Override // Indica ao compilador que estamos sobrescrevendo o método getId da classe mãe
    public String getId(){ // Método público que devolve a identificação única do Servidor
        return id; // Retorna o valor contido na variável local id (que agora não é mais nula)
    } // Fim do método getId

    // Servidor pode ter no máximo 4 livros ao mesmo tempo
    @Override // Indica ao compilador que estamos sobrescrevendo o método getLimiteEmprestimos da classe mãe
    public int getLimiteEmprestimos() { // Método público que estabelece o limite máximo de livros que o servidor pode pegar
        return 4; // Retorna o valor fixo de 4 empréstimos simultâneos
    } // Fim do método getLimiteEmprestimos
} // Fim da classe Servidor