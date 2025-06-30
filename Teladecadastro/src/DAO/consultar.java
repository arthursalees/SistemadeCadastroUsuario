/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class consultar {
    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    public cadastro consultar1(Integer id){
        conn = new conexao().conexaoBD();
        String sql = "Select * FROM cadastrousuario.usuarios WHERE id = ?";
        try{
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            
            cadastro objetodto = new cadastro();
            if(rs.next()){
                objetodto.setNome(rs.getString("Nome"));
                objetodto.setIdade(rs.getInt("Idade"));
            }else{
                return null;
            }
            rs.close();
            psmt.close();
            return objetodto;
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, erro);
                return null;
            }
                
    }
}
