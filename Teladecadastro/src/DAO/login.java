/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author GIP_03
 */
public class login {
    public boolean validarlogin(String nome, String senha){
        Connection conn;
        PreparedStatement psmt;
        ResultSet rs;
        conn = new conexao().conexaoBD();
        String sql = "SELECT * FROM cadastrousuario.usuarios WHERE nome = ? AND senha = ?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, nome);
            psmt.setString(2, senha);
            rs = psmt.executeQuery();
            if (rs.next()){
             return true;   
            }else{
                return false;
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao fazer login" + erro.getMessage());
            return false;
        }
    }
}