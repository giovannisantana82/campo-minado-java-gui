package br.com.giovanni.cm.visao;

import br.com.giovanni.cm.modelo.Campo;
import br.com.giovanni.cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro){

        setLayout(new GridLayout(tabuleiro.getQtLinhas(), tabuleiro.getQtColunas()));

        tabuleiro.forEach(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()){
                    JOptionPane.showMessageDialog(this, "Ganhou :)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu :(");
                }

                tabuleiro.reiniciar();
            });
        });
    }
}
