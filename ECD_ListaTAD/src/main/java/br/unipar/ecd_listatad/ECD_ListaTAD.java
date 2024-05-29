package br.unipar.ecd_listatad;

import java.util.Scanner;

public class ECD_ListaTAD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("================");
            System.out.println("Menu Principal: ");
            System.out.println("1 - Exercicio 01");
            System.out.println("2 - Exercicio 02");
            System.out.println("3 - Exercicio 03");
            System.out.println("4 - Exercicio 04");
            System.out.println("5 - Exercicio 05");
            System.out.println("================");
            
            System.out.print("Escolha uma opção: ");
            int opcaoPrincipal = s.nextInt();
            
            switch (opcaoPrincipal) {
                case 1:
                    exercicio01(s);
                    break;
                case 2:
                    exercicio02(s);
                    break;
                case 3:
                    exercicio03(s);
                    break;
                case 4:
                    exercicio04(s);
                    break;
                case 5:
                    exercicio05(s);
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    public static void exercicio01(Scanner s) {
        Ex1_Fila fila = new Ex1_Fila(20);
        while (true) {
            System.out.println("Menu Exercicio 01:");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar proximo paciente");
            System.out.println("3 - Voltar ao menu principal");
            
            System.out.print("Escolha uma opcao: ");
            int opcao = s.nextInt();
            s.nextLine(); // Consume newline
            
            switch (opcao) {
                case 1:
                    if (!fila.isFull()) {
                        System.out.print("Informe seu nome: ");
                        String nome = s.nextLine();
                        fila.enqueue(nome);
                        System.out.println("Paciente " + nome + " adicionado a fila.");
                    } else {
                        System.out.println("A fila esta cheia. Nao e possivel adicionar mais pacientes.");
                    }
                    break;
                case 2:
                    if (!fila.isEmpty()) {
                        String nome = fila.dequeue();
                        System.out.println("Proximo paciente: " + nome);
                    } else {
                        System.out.println("A fila esta vazia. Nenhum paciente para chamar.");
                    }
                    break;
                case 3:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    public static void exercicio02(Scanner s) {
        Ex2_Fila filaPrioritaria = new Ex2_Fila(100);
        Ex2_Fila filaNormal = new Ex2_Fila(100);
        int senha = 1;
        int contadorPrioritarios = 0;

        while (true) {
            System.out.println("Menu Exercicio 02:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar cliente");
            System.out.println("3 - Voltar ao menu principal");
            
            System.out.print("Escolha uma opcao: ");
            int opcao = s.nextInt();
            s.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    if (!filaPrioritaria.isFull() && !filaNormal.isFull()) {
                        System.out.print("Informe seu nome: ");
                        String nome = s.nextLine();
                        System.out.print("Informe seu ano de nascimento: ");
                        int anoNascimento = s.nextInt();
                        s.nextLine(); // Consume newline
                        
                        Ex2_Cliente ex2_Cliente = new Ex2_Cliente(senha++, nome, anoNascimento);
                        
                        if (ex2_Cliente.getIdade(2024) >= 65) {
                            filaPrioritaria.enqueue(ex2_Cliente);
                            System.out.println("Cliente " + nome + " adicionado a fila prioritaria.");
                        } else {
                            filaNormal.enqueue(ex2_Cliente);
                            System.out.println("Cliente " + nome + " adicionado  fila normal.");
                        }
                    } else {
                        System.out.println("A fila esta cheia.");
                    }
                    break;
                case 2:
                    if (contadorPrioritarios < 2 && !filaPrioritaria.isEmpty()) {
                        Ex2_Cliente clienteAtendido = filaPrioritaria.dequeue();
                        System.out.println("Atendendo cliente prioritario: " + clienteAtendido);
                        contadorPrioritarios++;
                    } else if (!filaNormal.isEmpty()) {
                        Ex2_Cliente clienteAtendido = filaNormal.dequeue();
                        System.out.println("Atendendo cliente normal: " + clienteAtendido);
                        contadorPrioritarios = 0;
                    } else if (!filaPrioritaria.isEmpty()) {
                        Ex2_Cliente clienteAtendido = filaPrioritaria.dequeue();
                        System.out.println("Atendendo cliente prioritario: " + clienteAtendido);
                    } else {
                        System.out.println("Nenhum cliente na fila.");
                    }
                    break;
                case 3:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
    
    public static void exercicio03(Scanner s){
        Ex3_Pilha<String> pilha = new Ex3_Pilha<>(100); //cria uma pilha de 100 posicoes
        
        while(true){
            System.out.println("Menu Exercicio 03:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Lista de livros");
            System.out.println("3 - Retirar livro");
            System.out.println("4 - Voltar ao menu principal");
            
            System.out.println("Escolha uma opcao: ");
            int opcao = s.nextInt();
            
            switch (opcao){
                case 1:
                    if(!pilha.isFull()){ //enquanto a pilha nao estiver cheia
                    System.out.println("Informe o livro a ser adicionado: ");
                    String livro = s.next();
                    pilha.push(livro);
                    System.out.println("Livro "+livro+" adicionado a pilha.");
                    } else {
                            System.out.println("A pilha esta cheia. Nao e possivel adicionar mais livros.");
                    }
                    break;
                case 2:
                    if(!pilha.isEmpty()){
                        Ex3_Pilha<String> tempPilha = new Ex3_Pilha<>(100);
                        System.out.println("Livros na pilha: ");
                        while(!pilha.isEmpty()){
                            String livro = pilha.pop();
                            System.out.println(livro);
                            tempPilha.push(livro); //armazena temporariamente
                        }
                        while(!tempPilha.isEmpty()){
                            pilha.push(tempPilha.pop()); // Restaura os livros na pilha original-
                        }
                    } else {
                        System.out.println("A pilha esta vazia");
                    }
                    break;
                case 3:
                    if (!pilha.isEmpty()) {
                        String livroRemovido = pilha.pop();
                        System.out.println("Livro removido: " + livroRemovido);
                    } else {
                        System.out.println("A pilha esta vazia. Nenhum livro para remover.");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida.");
                }
            }
        }
    
    public static void exercicio04(Scanner s){
        Ex4_Pilha pilha = new Ex4_Pilha(10);
        
        while(true){
            System.out.println("Menu Exercicio 04:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Lista de produtos");
            System.out.println("3 - Retirar produto");
            System.out.println("4 - Voltar ao menu principal");

            System.out.print("Escolha uma opcao: ");
            int opcao = s.nextInt();
            
            switch(opcao){
                case 1:
                    if(!pilha.isFull()){
                        System.out.print("Informe o codigo do produto: ");
                        String codProduto = s.next();
                        System.out.print("Informe a descricao: ");
                        String descricao = s.next();
                        System.out.print("Informe a data de entrada: ");
                        String dataEntrada = s.next();
                        System.out.print("Informe a UF de origem: ");
                        String ufOrigem = s.next();
                        System.out.print("Informe a UF de destino: ");
                        String ufDestino = s.next();
                        
                        Ex4_Produto produto = new Ex4_Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                        pilha.push(produto);
                        System.out.println("Produto " + produto + " adicionado a pilha.");
                        displayPilha(pilha);
                    }else{
                        System.out.println("A pilha esta cheia. Nao e possível adicionar mais produtos.");
                    }
                    break;
                case 2:
                    if(!pilha.isEmpty()){
                        Ex4_Pilha tempPilha = new Ex4_Pilha(10);
                        System.out.println("Produtos na pilha: ");
                        while(!pilha.isEmpty()){
                            Ex4_Produto produto = pilha.pop();
                            System.out.println(produto);
                            tempPilha.push(produto);//armazena temporariamente
                        }
                        while(!tempPilha.isEmpty()){
                            pilha.push(tempPilha.pop());//restaura os produtos da pilha original
                        }
                    }else{
                            System.out.println("A pilha esta vazia.");
                        }
                    break;
                case 3:
                    if (!pilha.isEmpty()) {
                        Ex4_Produto produtoRemovido = pilha.pop();
                        System.out.println("Produto removido: " + produtoRemovido);
                        displayPilha(pilha);
                    } else {
                        System.out.println("A pilha esta vazia. Nenhum produto para remover.");
                    }
                    break;
                case 4:
                    return; // sai do método e volta ao menu principal
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }
    
    private static void displayPilha(Ex4_Pilha pilha) {
        if (pilha.isEmpty()) {
            System.out.println("A pilha esta vazia.");
        } else {
            Ex4_Pilha tempPilha = new Ex4_Pilha(10);
            System.out.println("Estado atual da pilha:");
            while (!pilha.isEmpty()) {
                Ex4_Produto produto = pilha.pop();
                System.out.println(produto);
                tempPilha.push(produto); // armazena temporariamente
            }
            while (!tempPilha.isEmpty()) {
                pilha.push(tempPilha.pop()); // restaura os produtos na pilha original
            }
        }
    }
    
    public static void exercicio05(Scanner s){
        Ex4_Pilha[] pilhas = new Ex4_Pilha[5];
        for (int i = 0; i < pilhas.length; i++) {
            pilhas[i] = new Ex4_Pilha(10); // cada pilha tem capacidade para 10 produtos
        }

        while (true) {
            System.out.println("Menu Exercicio 05:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Retirar produto");
            System.out.println("4 - Voltar ao menu principal");

            System.out.print("Escolha uma opcao: ");
            int opcao = s.nextInt();
            s.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Selecione a pilha (0-4): ");
                    int pilhaSelecionada = s.nextInt();
                    s.nextLine(); // consumir a nova linha
                    if (pilhaSelecionada < 0 || pilhaSelecionada >= pilhas.length) {
                        System.out.println("Pilha invalida.");
                        break;
                    }
                    if (!pilhas[pilhaSelecionada].isFull()) {
                        System.out.print("Informe o codigo do produto: ");
                        String codProduto = s.nextLine();
                        System.out.print("Informe a descricao: ");
                        String descricao = s.nextLine();
                        System.out.print("Informe a data de entrada: ");
                        String dataEntrada = s.nextLine();
                        System.out.print("Informe a UF de origem: ");
                        String ufOrigem = s.nextLine();
                        System.out.print("Informe a UF de destino: ");
                        String ufDestino = s.nextLine();

                        Ex4_Produto produto = new Ex4_Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                        pilhas[pilhaSelecionada].push(produto);
                        System.out.println("Produto " + produto + " adicionado a pilha " + pilhaSelecionada + ".");
                        displayPilhas(pilhas);
                    } else {
                        System.out.println("A pilha " + pilhaSelecionada + " esta cheia. Nao e possível adicionar mais produtos.");
                    }
                    break;
                case 2:
                    displayPilhas(pilhas);
                    break;
                case 3:
                    System.out.print("Selecione a pilha (0-4): ");
                    pilhaSelecionada = s.nextInt();
                    s.nextLine(); // consumir a nova linha
                    if (pilhaSelecionada < 0 || pilhaSelecionada >= pilhas.length) {
                        System.out.println("Pilha invalida.");
                        break;
                    }
                    if (!pilhas[pilhaSelecionada].isEmpty()) {
                        Ex4_Produto produtoRemovido = pilhas[pilhaSelecionada].pop();
                        System.out.println("Produto removido da pilha " + pilhaSelecionada + ": " + produtoRemovido);
                        displayPilhas(pilhas);
                    } else {
                        System.out.println("A pilha " + pilhaSelecionada + " esta vazia. Nenhum produto para remover.");
                    }
                    break;
                case 4:
                    return; // sai do método e volta ao menu principal
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }

    private static void displayPilhas(Ex4_Pilha[] pilhas) {
        for (int i = 0; i < pilhas.length; i++) {
            Ex4_Pilha tempPilha = new Ex4_Pilha(10);
            System.out.println("Pilha " + i + ":");
            if (pilhas[i].isEmpty()) {
                System.out.println("  [Vazia]");
            } else {
                while (!pilhas[i].isEmpty()) {
                    Ex4_Produto produto = pilhas[i].pop();
                    System.out.println("  " + produto);
                    tempPilha.push(produto); // armazena temporariamente
                }
                while (!tempPilha.isEmpty()) {
                    pilhas[i].push(tempPilha.pop()); // restaura os produtos na pilha original
                }
            }
        }
    }
}
