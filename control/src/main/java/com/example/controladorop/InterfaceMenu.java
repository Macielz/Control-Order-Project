package com.example.controladorop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceMenu extends JFrame {

    private JLabel titulo;
    private JLabel codOrdemV;
    private JLabel codOperacaoV;
    private JLabel codPessoaV;
    private JTextField codOrdem;
    private JTextField codOperacao;
    private JTextField codPessoa;
    private JButton enviar;
    private DataInserter dataInserter; // Instância de DataInserter para inserção de dados

    public InterfaceMenu() {
        dataInserter = new DataInserter(); // Inicializa o DataInserter

        setTitle("Controlador Ordem De Produção");
        setBounds(100, 120, 600, 500);
        setLayout(null);

        titulo = adicionaJLabel(228, 10, 220, 30, "CONTROLADOR DE OP");

        codOrdemV = adicionaJLabel(180, 60, 220, 30, "Ordem de Produção");
        codOrdem = adicionaJTextField(180, 85, 220, 30);

        codOperacaoV = adicionaJLabel(180, 115, 220, 30, "Cód. Operação");
        codOperacao = adicionaJTextField(180, 140, 220, 30);

        codPessoaV = adicionaJLabel(180, 170, 220, 30, "Cód. Pessoa");
        codPessoa = adicionaJTextField(180, 195, 220, 30);

        enviar = adicionaJButton(180, 260, 220, 30, "Enviar");
        enviar.addActionListener(extractInfo);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

    public static void main(String[] args) {
        new InterfaceMenu();
    }

    ActionListener extractInfo = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                String txt1 = codOrdem.getText();
                String txt2 = codOperacao.getText();
                String txt3 = codPessoa.getText();

                if (!txt1.isEmpty() && !txt2.isEmpty() && !txt3.isEmpty()) {
                    dataInserter.insertData(txt1, txt2, txt3);

                    codOrdem.setText("");
                    codOperacao.setText("");
                    codPessoa.setText("");

                } else {
                    System.err.println("Valores nulos ou espaços em branco!");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter para número: " + ex.getMessage());
            }
        }
    };


}
