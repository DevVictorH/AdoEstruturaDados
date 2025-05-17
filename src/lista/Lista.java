package lista;

import Model.Carro;

public class Lista {

    private No inicio, atual, aux;
    private static int contador = 0;

    public boolean empty(){
        return inicio == null;
    }
/*
    public void enqueue(Carro c,int prioridade){
        No ref = inicio;
        if(empty()){
            inicio = new No(null, c,null);
            aux = inicio;
        }else{
            switch(prioridade){
                case 1: //Prioridade Alta
                    inicio = new No(null, c,ref);
                    ref.setAnt(inicio);
                    aux = inicio;
                    c.setPrioridade(1);
                    break;

                case 2: //Prioridade Média
                    while(ref != null){
                        Carro carro = (Carro) ref.getCarro();
                        aux = inicio;
                        if(carro.getPrioridade() == 1){
                            aux = ref;
                            ref = ref.getProx();
                        }else{
                            ref = new No(aux,c,aux.getProx());
                            aux.setProx(ref);
                            ref.getProx().setAnt(ref);
                            aux = ref;
                            break;
                        }
                    }
                case 3: //Prioridade Baixa
                    atual = new No(aux, c, null);
                    aux.setProx(atual);
                    aux = atual;
                    break;

                default:
                    System.out.println("Insira uma prioridade válida!");
                    break;
            }
        }
        contador++;
    }

 */

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


    public int size(){
        return contador;
    }

    public Object front(){
        if(!empty()){
            return inicio.getCarro();
        }
        return null;
    }

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

    public void exibir() {
        No ref = inicio;
        while (ref != null) {
            System.out.println(ref.getCarro());
            ref = ref.getProx();
        }
    }

}
