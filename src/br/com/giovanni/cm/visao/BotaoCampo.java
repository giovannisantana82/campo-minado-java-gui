package br.com.giovanni.cm.visao;

import br.com.giovanni.cm.modelo.Campo;
import br.com.giovanni.cm.modelo.CampoEvento;
import br.com.giovanni.cm.modelo.CampoObservador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotaoCampo extends JButton implements CampoObservador, MouseListener {

    private final Color BG_PADRAO = new Color(215, 215, 215);
    private final Color BG_MARCADO = new Color(21, 101, 192);
    private final Color BG_EXPLOSAO = new Color(211, 47, 47);
    private final Color TEXTO_VERDE = new Color(69, 196, 75);
    private final Color TEXTO_AZUL = new Color(60, 163, 255);
    private final Color TEXTO_VERMELHO = new Color(246, 32, 32);
    private final Color TEXTO_PRETO = new Color(33, 33, 33);

    private Campo campo;
    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));

        addMouseListener(this);
        campo.registrarObservador(this);
    }

    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento){
            case ABRIR:
                aplicarEstiloAbrir();
                break;
            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstiloExplodir();
                break;
            default:
                aplicarEstiloPadrao();
        }

    }

    private void aplicarEstiloPadrao(){
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_EXPLOSAO);
        setText("X");
        setForeground(Color.WHITE);
        setFont(getFont().deriveFont(Font.BOLD));
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCADO);
        setForeground(Color.WHITE);
        setText("⚑");
        setFont(getFont().deriveFont(Font.BOLD));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void aplicarEstiloAbrir() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (campo.isMinado()){
            setBackground(BG_EXPLOSAO);
            return;
        }
        setBackground(BG_PADRAO);

        switch (campo.minasNaVizinhaca()) {
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(TEXTO_AZUL);
                break;
            case 3:
                setForeground(TEXTO_VERMELHO);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(TEXTO_PRETO);
                break;
            default:
                setForeground(Color.PINK);
        }

        String valor = !campo.vizinhacaSegura() ? campo.minasNaVizinhaca() + "" : "" + "";

        setText(valor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            campo.abrir();
        } else {
            campo.alternarMarcacao();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
