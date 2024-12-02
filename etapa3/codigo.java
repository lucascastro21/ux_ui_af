package com.caixa.branca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    // Ponto 1: Início da classe User
    
    public Connection conectarBD() {
        Connection conn = null;
        // Ponto 2: Tentativa de conexão com o banco de dados
        try {
            // Problema: O driver MySQL é carregado diretamente sem validação prévia.
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            // Problema: A URL do banco está fixa, podendo causar dificuldades em manutenções ou configurações.
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url); // Problema: Não há tratamento detalhado em caso de falha na conexão.
        } catch (Exception e) { 
            // Ponto 3: Bloco catch para tratar possíveis exceções durante a conexão
            // Problema: Não há mensagens de erro ou registros para diagnóstico.
        }
        // Ponto 4: Retorno da conexão, seja nula ou válida
        return conn; // Problema: Retorno 'null' sem indicar a falha ao usuário.
    }
    
    public String nome = ""; 
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
         // Ponto 5: Chamada ao método conectarBD()
        Connection conn = conectarBD(); // Problema: Não há verificação se a conexão foi estabelecida antes de prosseguir.

        // Ponto 6: Construção da query SQL
        // Problema: Uso de concatenação direta de strings para montar a consulta, expondo a vulnerabilidade de SQL Injection.
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "' ";
        sql += "AND senha = '" + senha + "'";

        try {
            // Ponto 7: Criação de um Statement para execução da query
            Statement st = conn.createStatement(); // Problema: O Statement não é encerrado corretamente após o uso.
            ResultSet rs = st.executeQuery(sql);  // Problema: O ResultSet também não é encerrado.

            // Ponto 8: Verificação dos resultados retornados pela query
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Ponto 10: Tratamento de exceções durante a execução da query
            // Problema: Ausência de mensagens ou registros para facilitar o diagnóstico de erros.
        }
        // Ponto 11: Retorno do resultado da verificação
        return result; // Problema: Retorno do resultado sem garantia de que a conexão foi válida ou encerrada adequadamente.
    }
}
