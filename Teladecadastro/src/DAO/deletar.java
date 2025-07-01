/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DTO.cadastro;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class deletar {
    Connection conn;
    PreparedStatement psmt;
    public void Deletarinfo(cadastro objetodto){
        conn = new conexao().conexaoBD();
        String sql = "delete  from cadastrousuario.usuarios WHERE id=?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, objetodto.getId());
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Informação deletado com sucesso");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    } 
}
