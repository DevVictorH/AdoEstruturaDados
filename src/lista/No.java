package lista;

import Model.Carro;

public class No {

    private No ant;
    private No prox;
    private Carro carro;

    public No(No ant, Carro c, No prox) {
        this.ant = ant;
        this.carro = c;
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public Object getCarro() {
        return carro;
    }

    public void setCarro(Carro c) {
        this.carro = c;
    }
}
