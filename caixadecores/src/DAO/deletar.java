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

public class deletar {
    Connection conn;
    PreparedStatement psmt;
    public void Deletarinfo(Caixadecores objetodto){
        conn = new conexao().conectaBD();
        String sql = "Delete from caixadecores.cores WHERE id=?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, objetodto.getId());
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Informações deletadas");
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}
