import br.ufla.gct052.biblioteca.model.*;
import javax.swing.JOptionPane;

// Classe que inicia e controla a tela do sistema
public class App {

    // Instancia a nossa biblioteca única global
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        
        // Guarda a opção escolhida pelo usuário em forma de texto
        String opcao = "";

        // Continua repetindo o menu enquanto o usuário não digitar 4 (Sair)
        while (!opcao.equals("4")) {
            
            // Texto legível que aparecerá dentro da caixinha de diálogo
            String menu = "==== MENU DA BIBLIOTECA ====\n"
                        + "1. Cadastrar Aluno\n"
                        + "2. Cadastrar Livro e Exemplar\n"
                        + "3. Realizar Empréstimo\n"
                        + "4. Sair do Sistema\n\n"
                        + "Selecione uma opção:";
                        
            // Abre o pop-up de entrada de dados exibindo o menu
            opcao = JOptionPane.showInputDialog(menu);

            // Se o usuário clicar em Cancelar ou fechar no "X", interrompe o loop
            if (opcao == null) break;

            // Tratamento da Opção 1: Cadastro do Aluno
            if (opcao.equals("1")) {
                String id = JOptionPane.showInputDialog("Digite a Matrícula:");
                String nome = JOptionPane.showInputDialog("Digite o Nome:");
                String email = JOptionPane.showInputDialog("Digite o E-mail:");
                String curso = JOptionPane.showInputDialog("Digite o Curso:");
                String periodo = JOptionPane.showInputDialog("Digite o Período:");

                Aluno novoAluno = new Aluno(id, nome, email, curso, periodo);
                biblioteca.cadastrarUsuario(novoAluno);
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            }
            
            // Tratamento da Opção 2: Cadastro do Livro (Obra + Cópia Física)
            else if (opcao.equals("2")) {
                String codLivro = JOptionPane.showInputDialog("Digite o código do Livro (Obra):");
                String titulo = JOptionPane.showInputDialog("Digite o Título do Livro:");
                Livro novoLivro = new Livro(codLivro, titulo);
                
                String codFisico = JOptionPane.showInputDialog("Digite o código de barras físico da estante:");
                Exemplar novoExemplar = new Exemplar(codFisico, novoLivro);
                
                biblioteca.cadastrarExemplar(novoExemplar);
                JOptionPane.showMessageDialog(null, "Livro cadastrado e inserido na estante!");
            }
            
            // Tratamento da Opção 3: Realização do Empréstimo
            else if (opcao.equals("3")) {
                String id = JOptionPane.showInputDialog("Matrícula do Aluno:");
                String codFisico = JOptionPane.showInputDialog("Código de barras físico do livro:");
                
                
                // Solicita o empréstimo para a biblioteca
                Emprestimo resultado = biblioteca.realizarEmprestimo(id, codFisico);
                
                // Verifica se o resultado deu certo (não voltou nulo)
                if (resultado != null) {
                    JOptionPane.showMessageDialog(null, "Empréstimo realizado!\n\n" + resultado.obterResumo());
                } else {
                    JOptionPane.showMessageDialog(null, "Falha no empréstimo! Verifique se os códigos estão certos, "
                                                      + "se o aluno não estourou o limite ou se o livro já foi emprestado.");
                }
            }
        }
        
        // Mensagem disparada após quebrar o laço de repetição
        JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema da Biblioteca!");
    }
}