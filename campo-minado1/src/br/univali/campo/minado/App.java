package br.univali.campo.minado;

import br.univali.campo.minado.model.Tabuleiro;
import br.univali.campo.minado.view.TabuleiroConsole;

public class App {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(10,10,10);
        new TabuleiroConsole(tabuleiro);
    }
}
