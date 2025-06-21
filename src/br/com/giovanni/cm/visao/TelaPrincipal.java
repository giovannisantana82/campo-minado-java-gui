package br.com.giovanni.cm.visao;

import br.com.giovanni.cm.modelo.Tabuleiro;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){

       String [] opcoes = {"Fácil", "Médio", "Difícil"};
       int dificuldade = JOptionPane.showOptionDialog(
               null,
               "Escolha a dificuldade: ",
               "Campo Minado - DIFICULDADE",
               JOptionPane.DEFAULT_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,
               opcoes,
               opcoes[0]);

       //DIFICULDADE PADRÃO
        int linhas = 9;
        int colunas = 9;
        int minas = 10;

        if (dificuldade == 0) { // Fácil
            linhas = 9;
            colunas = 9;
            minas = 10;
        } else if (dificuldade == 1) { // Médio
            linhas = 16;
            colunas = 30;
            minas = 40;
        } else if (dificuldade == 2) { // Difícil
            linhas = 16;
            colunas = 30;
            minas = 99;
        }

        Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas, minas);

        add(new PainelTabuleiro(tabuleiro));

        setTitle("Campo Minado GUI");
        setSize(690,438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        setVisible(true);
    }
    public static void main(String[] args) {
        new TelaPrincipal();
    }

}
