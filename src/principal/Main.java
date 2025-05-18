package principal;

import Model.Carro;
import lista.Lista;

public class Main {
    public static void main(String[] args) {

    Lista lista = new Lista();

        Carro c1 = new Carro("Gol","Volkswagem","Preto");
        Carro c2 = new Carro("Saveiro","Volkswagem","Azul");
        Carro c3 = new Carro("Onix","Chevrolet","Branco");
        Carro c4 = new Carro("Uno","Fiat","Preto");
        Carro c5 = new Carro("Civic","Honda","Vermelho");
        Carro c6 = new Carro("3008","Peugeut","Prata");

        lista.enqueue(c1,3);
        lista.enqueue(c2,3);
        lista.enqueue(c3,3);
        lista.enqueue(c4,3);
        lista.enqueue(c5,2);
        lista.enqueue(c6,2);

        lista.exibir();

        System.out.println();
        System.out.println(lista.front());
        System.out.println(lista.size());
        System.out.println(lista.dequeue());
        System.out.println(lista.size());
        System.out.println(lista.empty());



    }
}