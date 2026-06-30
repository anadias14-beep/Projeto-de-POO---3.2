package br.ufla.gct052.biblioteca.model; // Declara o pacote onde a classe está localizada

import java.util.ArrayList; // Importa a classe ArrayList para trabalhar com listas dinâmicas ordenadas
import java.util.HashMap;   // Importa a classe HashMap para trabalhar com mapeamento de chave-valor
import java.util.Map;       // Importa a interface Map para garantir uma boa prática de abstração dos mapas

public class Biblioteca { // Declaração da classe pública principal do modelo de biblioteca

    // Listas para guardar as informações gravadas na memória
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>(); // Cria uma lista privada para armazenar os objetos de Usuários cadastrados
    private ArrayList<Exemplar> listaExemplares = new ArrayList<>(); // Cria uma lista privada para armazenar as cópias físicas dos livros (Exemplares)
    private ArrayList<Emprestimo> listaHistorico = new ArrayList<>(); // Cria uma lista privada para registrar todos os empréstimos efetuados

    // HashMaps acrescentados para indexação rápida
    private Map<String, Usuario> mapaUsuarios = new HashMap<>(); // Cria um mapa privado onde a chave é o ID (String) e o valor é o Usuário
    private Map<String, Exemplar> mapaExemplares = new HashMap<>(); // Cria um mapa privado onde a chave é o Código Físico (String) e o valor é o Exemplar

    // Adiciona um novo usuário na lista
    public void cadastrarUsuario(Usuario u) { // Método público para cadastrar usuário; recebe uma instância de Usuario como parâmetro
        listaUsuarios.add(u); // Insere o usuário recebido no final da lista tradicional (ArrayList)
        mapaUsuarios.put(u.getId(), u); // Insere o usuário no mapa indexado, usando o ID dele como chave de busca rápida
    } // Fim do método cadastrarUsuario

    // Adiciona uma nova cópia física na estante
    public void cadastrarExemplar(Exemplar e) { // Método público para cadastrar exemplar; recebe uma instância de Exemplar como parâmetro
        listaExemplares.add(e); // Insere o exemplar recebido no final da lista tradicional (ArrayList)
        mapaExemplares.put(e.getCodigoFisico(), e); // Insere o exemplar no mapa indexado, usando o código físico dele como chave de busca rápida
    } // Fim do método cadastrarExemplar

    // Lógica simples para realizar o empréstimo
    public Emprestimo realizarEmprestimo(String idUsuario, String codigoFisico) { // Método que processa o empréstimo; recebe o ID do usuário e o código do livro
        Usuario usuarioAchado = null; // Inicializa uma variável temporária de Usuário como nula (vazia)
        Exemplar exemplarAchado = null; // Inicializa uma variável temporária de Exemplar como nula (vazia)

        // Procura o usuário correspondente pelo ID
        for (Usuario u : listaUsuarios) { // Inicia um laço de repetição que percorre cada Usuário dentro da lista de usuários
            if (u.getId().equals(idUsuario)) { // Se o ID do usuário atual do laço for igual ao ID passado por parâmetro...
                usuarioAchado = u; // Guarda a referência desse usuário encontrado na variável temporária
            } // Fim do bloco de verificação do ID do usuário
        } // Fim do laço de repetição de usuários

        // Procura a cópia física correspondente pelo código físico
        for (Exemplar e : listaExemplares) { // Inicia um laço de repetição que percorre cada Exemplar dentro da lista de exemplares
            if (e.getCodigoFisico().equals(codigoFisico)) { // Se o código físico do exemplar atual for igual ao código passado por parâmetro...
                exemplarAchado = e; // Guarda a referência desse exemplar encontrado na variável temporária
            } // Fim do bloco de verificação do código do exemplar
        } // Fim do laço de repetição de exemplares

        // Se encontrou ambos no sistema, prossegue com as verificações
        if (usuarioAchado != null && exemplarAchado != null) { // Condicional que só avança se o usuário E o exemplar existirem no sistema
            
            // Verifica se o usuário tem vaga no limite dele E se o livro está na estante
            if (usuarioAchado.podePegarMaisLivros() && exemplarAchado.getStatus() == StatusExemplar.DISPONIVEL) { // Valida as regras de negócio da biblioteca
                
                // Atualiza o estado das duas entidades
                exemplarAchado.emprestar(); // Invoca o método interno do exemplar para alterar seu status interno para EMPRESTADO
                usuarioAchado.pegarLivro(); // Invoca o método interno do usuário para atualizar seu contador de livros emprestados
                
                // Cria e guarda o registro no histórico
                Emprestimo novoEmprestimo = new Emprestimo(usuarioAchado, exemplarAchado); // Instancia um novo registro de Emprestimo ligando o usuário e o livro
                listaHistorico.add(novoEmprestimo); // Adiciona esse novo registro gerado na lista geral de históricos da biblioteca
                
                // Retorna o sucesso do empréstimo
                return novoEmprestimo; // Devolve o objeto do empréstimo concluído para quem chamou o método
            } // Fim da validação das regras de negócio
        } // Fim da validação de existência das entidades
        // Retorna nulo se o usuário/livro não existirem, ou se as regras falharem
        return null; // Caso caia em qualquer validação negativa, interrompe o fluxo e retorna vazio significando que o empréstimo falhou
    } // Fim do método realizarEmprestimo
} // Fim da classe Biblioteca