package com.example.controladorop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataInserter {
    private DatabaseConnector dbConnector;

    public DataInserter() {
        dbConnector = new DatabaseConnector();
    }

    public void insertData(String codOrdem, String codOperacao, String codPessoa) {
        String sql = "INSERT INTO DADOS (cod_ordem, cod_operacao, cod_pessoa, cod_Insert) VALUES (?, ?, ?, dados_seq.nextval)";
        
        System.out.println("Preparando para inserir dados...");

        try (Connection conn = dbConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"COD_INSERT"})) {

            System.out.println("Conexão estabelecida com sucesso!");

            pstmt.setString(1, codOrdem);
            pstmt.setString(2, codOperacao);
            pstmt.setString(3, codPessoa);

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


}
