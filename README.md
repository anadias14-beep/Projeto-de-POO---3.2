# Projeto-de-POO---3.2
# Sistema de Biblioteca Universitária — Trabalho Final GCT052 (POO)

Este repositório contém o desenvolvimento do Sistema de Gestão de Biblioteca Universitária, projetado como requisito avaliativo final para a disciplina **GCT052 - Programação Orientada a Objetos** na Universidade Federal de Lavras (UFLA).

---

## Integrantes do Grupo
* **Milena Duarte Costa** — Graduação em Bacharelado Interdisciplinar em Ciência, Tecnologia e Inovação (BICTI) / Engenharia de Software.
* **Ana Maria Granja Dias** — Graduação em Bacharelado Interdisciplinar em Ciência, Tecnologia e Inovação (BICTI) / Engenharia de Software.

**Professor Orientador:** Prof. Dr. Alysson Naves

---

## 1. Descrição do Sistema
O sistema consiste em uma aplicação Java voltada ao gerenciamento operacional completo de uma biblioteca de ambiente acadêmico. O software automatiza os processos de:
1. **Cadastro e Consulta de Usuários:** Segmentado por categorias com regras de concessões distintas.
2. **Controle de Acervo:** Divisão lógica clara entre a obra literária abstrata e suas cópias físicas correspondentes.
3. **Fluxo de Empréstimos e Devoluções:** Validação de regras impeditivas de negócio diretamente associadas aos perfis dos usuários e verificação de integridade e disponibilidade dos exemplares.

O principal objetivo do projeto não é a extensão volumétrica de telas, mas sim demonstrar o **estrito domínio prático das boas práticas e pilares da Engenharia de Software Orientada a Objetos**, operando com baixo acoplamento, alta coesão e encapsulamento rigoroso.

---

## 2. Conceitos de POO Utilizados

O desenvolvimento do ecossistema de classes reflete a aplicação real dos pilares fundamentais de POO:

* **Encapsulamento:** Todos os atributos críticos das entidades de domínio foram declarados com modificador de acesso estrito (`private`). O acesso e a mutabilidade dos estados dos objetos ocorrem de forma segura por meio de métodos seletores e modificadores públicos (`getters` e `setters`), além de construtores parametrizados.
* **Classes Abstratas:** A entidade `Usuario` foi modelada como uma classe abstrata (`abstract class`). Isso impede que o sistema crie um usuário genérico diretamente em memória, forçando a criação específica de suas extensões e definindo um contrato comportamental obrigatório.
* **Herança:** Aplicada estruturalmente com as classes filhas `Aluno`, `Professor` e `Servidor` estendendo as propriedades comuns herdadas de `Usuario` através do termo reservado `extends`.
* **Polimorfismo e Sobrescrita de Métodos:** Utilizado para calcular os limites operacionais de empréstimo. Por meio da anotação `@Override`, o método abstrato `obterLimiteEmprestimos()` da classe mãe é reescrito polimorficamente por cada classe filha, aplicando as regras vigentes:
  * **Aluno:** Limite máximo de **3 livros** simultâneos.
  * **Servidor:** Limite máximo de **4 livros** simultâneos.
  * **Professor:** Limite máximo de **5 livros** simultâneos.
* **Associação e Composição:** Estabelece vínculos lógicos entre as classes. Um `Exemplar` possui uma associação direta obrigatória com um `Livro`. A classe `Emprestimo` orquestra a composição unindo as referências dinâmicas de um `Usuario` e um `Exemplar` ativo.
* **Coleções e Generics (Collections API):** Estruturas de dados avançadas da biblioteca padrão do Java foram utilizadas no gerenciamento de memória. Usamos `ArrayList` para a indexação sequencial de históricos e `HashMap` para pesquisas otimizadas do tipo chave-valor ao rastrear usuários e exemplares de forma instantânea por ID.

---

## 3. Explicação das Principais Classes

### 3.1 Camada de Domínio / Model (`br.ufla.gct052.biblioteca.model`)
* `Usuario.java`: Superclasse abstrata que centraliza atributos transversais (ID, Nome, Email) e o contador interno de livros locados (`Emprestada`).
* `Aluno.java`, `Professor.java`, `Servidor.java`: Subclasses que herdam de `Usuario` e especializam as regras e limites de cota para empréstimos.
* `Livro.java`: Representa a obra intelectual pura, armazenando o título, autor, editora e ano de publicação.
* `Exemplar.java`: Instancia a cópia física que habita a estante da biblioteca. Controla seu estado atual por meio do enum `StatusExemplar` (`DISPONIVEL` ou `EMPRESTADO`).
* `Emprestimo.java`: Entidade associativa que registra as datas e o andamento de cada locação usando o enum `StatusEmprestimo`.

### 3.2 Camada de Serviço  (`br.ufla.gct052.biblioteca.service`)
* `Biblioteca.java`: Atua como o núcleo lógico de regras corporativas do sistema. Centraliza as coleções em listas e mapas, executa varreduras estruturadas e implementa o método controlador `realizarEmprestimo()`. O método avalia simultaneamente se o exemplar está livre e se o usuário possui margem em sua cota polimórfica para concluir o empréstimo com sucesso.

### 3.3 Camada de Aplicação / Interface (`br.ufla.gct052.biblioteca.app`)
* `App.java`: Ponto de entrada operacional do sistema contendo o método público `main`. Instancia as estruturas da biblioteca, efetua um pré-carregamento controlado de dados de teste (seed) e invoca a repetição do laço do menu interativo que se comunica visualmente com o usuário por caixas de diálogo nativas do `JOptionPane`.

---

## 4. Como Executar o Projeto

# 4.1 Pré-requisitos
* Java Development Kit (JDK) instalado na versão **17** ou superior.
* Uma IDE de desenvolvimento Java (como IntelliJ IDEA, Eclipse ou VS Code).
