/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.Caixadecores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class atualizar {
    Connection conn;
    PreparedStatement psmt;
    
    public void Atualizarpagina(Caixadecores objetodto){
        conn = new conexao().conectaBD();
        String sql = "update caixadecores.cores set cor = ?, nome=?,id=? WHERE id =?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, objetodto.getCor());
            psmt.setString(2,objetodto.getNome());
            psmt.setInt(3, objetodto.getId());
            psmt.setInt(4, objetodto.getId());
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null,"Pagina Atualizada");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}
