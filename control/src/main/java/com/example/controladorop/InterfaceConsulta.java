package com.example.controladorop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InterfaceConsulta extends JFrame{
   
    @SuppressWarnings("unused")
    private JLabel titulo;
    @SuppressWarnings("unused")
    private JLabel codOrdemV;
    private JTextField codOrdem;
    private JButton enviar;

    private DataConsult dataConsult;


    public InterfaceConsulta(){
        
        dataConsult = new DataConsult();

        setTitle("Consulta OP");
        setBounds(100, 120, 600, 500);
        setLayout(null);

        titulo = adicionaJLabel(228, 10, 220, 30, "CONTROLADOR DE OP");

        codOrdemV = adicionaJLabel(180, 60, 220, 30, "Ordem de Produção");
        codOrdem = adicionaJTextField(180, 85, 220, 30);

        enviar = adicionaJButton(180, 260, 220, 30, "Enviar");
        enviar.addActionListener(consultOrdem);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        

    }

    

    ActionListener consultOrdem = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                String txt1 = codOrdem.getText();
                if (!txt1.isEmpty()) {
                    dataConsult.consultData(txt1);                     
                    codOrdem.setText("");
                } else {
                    System.err.println("Valores nulos ou espaços em branco!");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Erro ao converter para número: " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }
    };


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