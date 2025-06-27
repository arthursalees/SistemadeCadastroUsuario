/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import DTO.Caixadecores;
import java.sql.ResultSet;

public class Consultar {
    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    public Caixadecores Consultar1(Integer Id){
        conn = new conexao() .conectaBD();
        String sql = "Select * FROM caixadecores.cores WHERE Id =?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, Id);
            rs = psmt.executeQuery();
            
            Caixadecores objetodto = new Caixadecores();
            if(rs.next()){
            objetodto.setCor(rs.getString("cor"));
            objetodto.setNome(rs.getString("nome"));
            }else {
                return null;
            }
            rs.close();
            psmt.close();
            return objetodto;
            }catch (SQLException erro){
                JOptionPane.showMessageDialog(null, erro);
                return null;
    } 
}   
}