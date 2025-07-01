/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class atualizar {
    Connection conn;
    PreparedStatement psmt;
    
    public void AtualizarPagina(cadastro objetodto){
        conn = new conexao().conexaoBD();
        String sql = "Update cadastrousuario.usuarios set nome = ?, idade = ? WHERE id =?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, objetodto.getNome());
            psmt.setInt(2, objetodto.getIdade());
            psmt.setInt(3, objetodto.getId());
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Pagina Atualizada com sucesso!");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}
