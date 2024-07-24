package com.example.controladorop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.CORBA.VM_ABSTRACT;



public class InterfaceSetName extends JFrame{
    private ViewConsult viewConsult;


    @SuppressWarnings("unused")
    private JLabel operacaoLabelV;
    @SuppressWarnings("unused")
    private JTextField operacaoLabel;

    @SuppressWarnings("unused")
    private JLabel pessoaLabelV;
    @SuppressWarnings("unused")
    private JTextField pessoaLabel;

    private JButton proximo;


    public InterfaceSetName(){
        
        setTitle("Set Name (InterfaceSetName)");
        setBounds(100, 120, 400, 400);
        setLayout(null);

        operacaoLabelV = adicionaJLabel(80, 75, 220, 30, "Operação: ");
        operacaoLabel = adicionaJTextField(80, 100, 220, 30);

        pessoaLabelV = adicionaJLabel(80, 155, 220, 30, "Operador da Etapa: ");
        pessoaLabel = adicionaJTextField(80, 180, 220, 30);
   
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        proximo = adicionaJButton(80, 260, 220, 30, "Enviar");
        proximo.addActionListener(setInfo);

    }

    ActionListener setInfo = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            try{
                String txt1 = operacaoLabel.getText();
                String txt2 = pessoaLabel.getText();
                if(!txt1.isEmpty() && !txt2.isEmpty()){


                    viewConsult = new ViewConsult();
                    viewConsult.setPessoa(txt2);
                    viewConsult.setOperacao(txt1);
                
            }
                else {
                    System.err.println("Valores nulos ou espaços em branco!");
                }
            }
            catch(NumberFormatException ex) {
                System.err.println("Erro ao converter para número: " + ex.getMessage());

            }

           operacaoLabel.setText("");
           pessoaLabel.setText("Marcelo");

        }
    };



    private JLabel adicionaJLabel(int x, int y, int w, int h, String texto) {
        JLabel novaLabel = new JLabel(texto);
        novaLabel.setBounds(x, y, w, h);
        getContentPane().add(novaLabel);
        return novaLabel;
    }
    @SuppressWarnings("unused")
    private JTextField adicionaJTextField(int x, int y, int w, int h) {
        JTextField novoTextField = new JTextField();
        novoTextField.setBounds(x, y, w, h);
        getContentPane().add(novoTextField);
        return novoTextField;
    }
    @SuppressWarnings("unused")
    private JButton adicionaJButton(int x, int y, int w, int h, String texto) {
        JButton novoBotao = new JButton(texto);
        novoBotao.setBounds(x, y, w, h);
        getContentPane().add(novoBotao);
        return novoBotao;
    }


}
    
