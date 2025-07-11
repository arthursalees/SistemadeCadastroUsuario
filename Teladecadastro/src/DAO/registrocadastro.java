/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.cadastro;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class registrocadastro {
    Connection conn;
    PreparedStatement psmt;
    
    public void cadastrarusuario(cadastro objetodto){
        conn = new conexao().conexaoBD();
        String sql = "Insert into cadastrousuario.usuarios (nome, senha, idade, Email, telefone, cpf) values(?,?,?,?,?,?)";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, objetodto.getNome());
            psmt.setString(2, objetodto.getSenha());
            psmt.setInt(3, objetodto.getIdade());
            psmt.setString(4, objetodto.getEmail());
            psmt.setString(5, objetodto.getTelefone());
            psmt.setString(6, objetodto.getCpf());
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado");

        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
        
    }
    
}
