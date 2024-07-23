package com.example.controladorop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ViewConsult extends JFrame{
    
    private JLabel titulo;

    private JLabel codOrdemLabelV;
    private JLabel codOrdemLabel;

    private JLabel artOrdemlabelV;
    private JLabel artOrdemLabel;

    private JLabel nomeOrdemLabelV;
    private JLabel nomeOrdemLabel;

    private JLabel qtdOrdemLabelV;
    private JLabel qtdOrdemLabel;

    private JLabel operacaoLabelV;
    private JLabel operacaoLabel;

    private JLabel pessoaLabelV;
    private JLabel pessoaLabel;

    //private JButton enviar;


    public ViewConsult(){
        
        setTitle("Consulta OP");
        setBounds(100, 120, 600, 500);
        setLayout(null);

        titulo = adicionaJLabel(228, 10, 220, 30, "CONTROLADOR DE OP");

        codOrdemLabelV = adicionaJLabel(180, 60, 220, 30, "N° Ordem: ");
        codOrdemLabel = adicionaJLabel(280, 60, 220, 30, "");

        artOrdemlabelV = adicionaJLabel(180, 80, 220, 30, "Artigo: ");
        artOrdemLabel = adicionaJLabel(260, 80, 220, 30, "");

        nomeOrdemLabelV = adicionaJLabel(180, 100, 220, 30, "Descrição: ");
        nomeOrdemLabel = adicionaJLabel(300, 100, 220, 30, "");

        qtdOrdemLabelV = adicionaJLabel(180, 120, 220, 30, "Quantidade: ");
        qtdOrdemLabel = adicionaJLabel(280, 120, 220, 30, "");

        operacaoLabelV = adicionaJLabel(180, 140, 220, 30, "Teste: ");
        operacaoLabel = adicionaJLabel(180, 165, 220, 30, "");

        /*
        pessoaLabelV = adicionaJLabel(180, 160, 220, 30, "Ord");
        pessoaLabel = adicionaJLabel(180, 185, 220, 30, "");
         

        enviar = adicionaJButton(180, 260, 220, 30, "Enviar");
        enviar.addActionListener();

        */
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    protected void setDados(String codOrdem, String artOrdem, String nomeOrdem, int qtdOrdem ){

        String recoveString = Integer.toString(qtdOrdem);

        codOrdemLabel.setText(codOrdem);
        artOrdemLabel.setText(artOrdem);
        nomeOrdemLabel.setText(nomeOrdem);
        qtdOrdemLabel.setText(recoveString);

    }







    private JLabel adicionaJLabel(int x, int y, int w, int h, String texto) {
        JLabel novaLabel = new JLabel(texto);
        novaLabel.setBounds(x, y, w, h);
        getContentPane().add(novaLabel);
        return novaLabel;
    }
    private JTextField adicionaJTextField(int x, int y, int w, int h) {
        JTextField novoTextField = new JTextField();
        novoTextField.setBounds(x, y, w, h);
        getContentPane().add(novoTextField);
        return novoTextField;
    }
    private JButton adicionaJButton(int x, int y, int w, int h, String texto) {
        JButton novoBotao = new JButton(texto);
        novoBotao.setBounds(x, y, w, h);
        getContentPane().add(novoBotao);
        return novoBotao;
    }


}
    
