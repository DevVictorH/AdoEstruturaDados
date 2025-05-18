package lista;

import Model.Carro;

public class Lista {

    private No inicio, atual, aux;
    private static int contador = 0;

    //verifica se fila ta vazia
    public boolean empty(){
        return inicio == null;
    }

    //adiciona um nó na lista
    public void enqueue(Carro c, int prioridade) {
        No ref = inicio;

        // Cria um novo nó para o carro
        No novoNo = new No(null, c, null);
        c.setPrioridade(prioridade);

        if (empty()) {
            // Se a lista estiver vazia, o novo nó será o início
            inicio = novoNo;
            aux = inicio;
        } else {
            switch (prioridade) {
                case 1: // Prioridade Alta
                    // Adiciona no início da lista
                    novoNo.setProx(inicio);
                    inicio.setAnt(novoNo);
                    inicio = novoNo;
                    break;

                case 2: // Prioridade Média
                    // Procura o último carro com prioridade 1
                    while (ref != null && ((Carro) ref.getCarro()).getPrioridade() == 1) {
                        ref = ref.getProx();
                    }
                    if (ref == null) {
                        // Se não encontrar carros de prioridade 1, adiciona no final
                        aux.setProx(novoNo);
                        novoNo.setAnt(aux);
                        aux = novoNo;
                    } else {
                        // Insere após os carros de prioridade 1
                        novoNo.setProx(ref);
                        novoNo.setAnt(ref.getAnt());
                        if (ref.getAnt() != null) {
                            ref.getAnt().setProx(novoNo);
                        } else {
                            inicio = novoNo; // Caso seja o início
                        }
                        ref.setAnt(novoNo);
                    }
                    break;

                case 3: // Prioridade Baixa
                    // Adiciona no final da lista
                    aux.setProx(novoNo);
                    novoNo.setAnt(aux);
                    aux = novoNo;
                    break;

                default:
                    System.out.println("Insira uma prioridade válida!");
                    return;
            }
        }
        contador++;
    }

    // Retorna quantos itens tem na lista
    public int size(){
        return contador;
    }

    // Retorna qual o primeiro objeto da fila
    public Carro front(){
        if(!empty()){
            return inicio.getCarro();
        }
        return null;
    }

    // Remove o primeiro item da lista
    public boolean dequeue(){
        No ref = inicio;
        if(ref != null){
            inicio = inicio.getProx();
            ref.setProx(null);
            inicio.setAnt(null);
            contador--;
            return true;
        }
        return false;
    }

    // Exibe todos os itens na lista de prioridade
    public void exibir() {
        No ref = inicio;
        while (ref != null) {
            System.out.println(ref.getCarro());
            ref = ref.getProx();
        }
    }

}
