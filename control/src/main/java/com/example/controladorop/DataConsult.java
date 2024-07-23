package com.example.controladorop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataConsult extends ViewConsult{
    private DatabaseConnector dbConnector;
    private ViewConsult viewConsult;

    public DataConsult(){
        dbConnector = new DatabaseConnector();
    }

    public void consultData(String codOrdem){
        viewConsult = new ViewConsult();

        String sql = "SELECT * FROM ORDEM_OP WHERE cod_ordem = ?";

        System.out.println("Preparando para consultar...");

        try (Connection conn = dbConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            System.out.println(" (Consult) Conexão estabelecida com sucesso !");

            pstmt.setString(1, codOrdem);

            System.out.println("Executando a consulta...");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    
                    String ordemTxt = rs.getString("COD_ORDEM");
                    String artTxt = rs.getString("ART_ORDEM");
                    String nomeTxt = rs.getString("NOME_ORDEM");
                    int qtdOrdem = rs.getInt("QTD_ORDEM");

                    viewConsult.setDados(ordemTxt, artTxt, nomeTxt, qtdOrdem);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar dados: " + e.getMessage());
        }
    }
}
