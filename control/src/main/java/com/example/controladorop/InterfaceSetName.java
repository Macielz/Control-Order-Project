package com.example.controladorop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.naming.directory.AttributeModificationException;
import javax.swing.*;
import java.awt.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InterfaceSetName extends JFrame{
    private DatabaseConnector dbConnector;
    private ViewConsult viewConsult;

    @SuppressWarnings("unused")
    private JLabel operacaoLabelV;
    @SuppressWarnings("unused")
    private JTextField operacaoLabel;

    @SuppressWarnings("unused")
    private JLabel pessoaLabelV;
    @SuppressWarnings("unused")
    private JTextField pessoaLabel;

    @SuppressWarnings("unused")
    private JLabel obsLabelV;
    @SuppressWarnings("unused")
    private JTextField obsLabel;

    private JButton proximo;

    private JCheckBox iniCheckBox;
    private JCheckBox fimCheckBox;

    private JLabel codOrdemAuxL;


    public InterfaceSetName(){
        dbConnector = new DatabaseConnector();

            setTitle("Set Name (InterfaceSetName)");
            setBounds(100, 120, 400, 400);
            setLayout(null);

        operacaoLabelV = adicionaJLabel(80, 75, 220, 30, "Operação: ");
        operacaoLabel = adicionaJTextField(80, 100, 220, 30);

        obsLabelV = adicionaJLabel(80, 110, 220, 30, "Observações: ");
        obsLabel = adicionaJTextField(80, 130, 220, 30);

        pessoaLabelV = adicionaJLabel(80, 155, 220, 30, "Operador da Etapa: ");
        pessoaLabel = adicionaJTextField(80, 180, 220, 30);
   
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        proximo = adicionaJButton(80, 260, 220, 30, "Enviar");
        proximo.addActionListener(setInfo);

        iniCheckBox = new JCheckBox("Início da Operação");
        iniCheckBox.setBounds(80, 215, 220, 20);

        fimCheckBox = new JCheckBox("Fim da Operação");
        fimCheckBox.setBounds(80, 235, 220, 20);

        ButtonGroup group = new ButtonGroup();
        group.add(iniCheckBox);
        group.add(fimCheckBox);

        getContentPane().add(iniCheckBox);
        getContentPane().add(fimCheckBox);

        

    }
    
    public void setName(String codOrdem, String codOperacao, String codPessoa, String obs, String dataIni, String dataFim) {
        String sql = "INSERT INTO SET_OPERACAO (cod_ordem, cod_operacao, cod_pessoa, obs, data_ini, data_fim) VALUES (?, ?, ?, ?, ?, ?, dados_seq.nextval)";
        
        try (Connection conn = dbConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"COD_OINSERT"})) {

            System.out.println("Conexão estabelecida com sucesso!");

            pstmt.setString(1, codOrdem);
            pstmt.setString(2, codOperacao);
            pstmt.setString(3, codPessoa);
            pstmt.setString(5, obs);
            pstmt.setString(6, dataIni);
            pstmt.setString(7, dataFim);

            System.out.println("Executando a consulta de inserção...");

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inserção realizada com sucesso, obtendo chave gerada...");
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int codInsert = rs.getInt(1); // Obtem o valor gerado
                    System.out.println("Valor de codInsert gerado: " + codInsert);
                } else {
                    System.out.println("Não foi possível obter o valor de codInsert gerado.");
                }
                rs.close();
            } else {
                System.out.println("Nenhuma linha afetada ao inserir os dados.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            System.out.println("Finalizando a operação de inserção.");
        }
    }
    
        
    
    public void setOrdem (String codOrdemAuxL){
        this.codOrdemAuxL.setText(codOrdemAuxL);
        }


    ActionListener setInfo = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            try{
                //String txt1 = codOrdemAuxL.getText();
                String txt1 = "12341";
                String txt2 = operacaoLabel.getText();
                String txt3 = pessoaLabel.getText();
                String txt4 = obsLabel.getText();
                
                Boolean bLean1 = iniCheckBox.isSelected();
                Boolean bLean2 = fimCheckBox.isSelected();

                String bLeanAux1 = null;
                String bLeanAux2 = null;

                if (bLean1) {
                    LocalDateTime agora = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    bLeanAux1 = agora.format(formatter);
                    System.out.println("Início selecionado em: " + bLeanAux1);
                } else if (bLean2) {
                    LocalDateTime agora = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    bLeanAux2 = agora.format(formatter);
                    System.out.println("Fim selecionado em: " + bLeanAux2);

                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Nenhum selecionado.");
                }

                    if(!txt1.isEmpty() && !txt2.isEmpty() && !txt3.isEmpty() && !txt4.isEmpty()){
                        setName(txt1, txt2, txt3, txt4, bLeanAux1, bLeanAux2 );
                        /*
                        viewConsult = new ViewConsult();
                        viewConsult.setPessoa(txt2);
                        viewConsult.setOperacao(txt1);
                        */  

                }
                    else {
                    System.err.println("Valores nulos ou espaços em branco!");
                }
            }
                catch(NumberFormatException ex) {
                System.err.println("Erro ao converter para número: " + ex.getMessage());

                }

           operacaoLabel.setText("");
           pessoaLabel.setText("");


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
    
