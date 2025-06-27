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
/**
 *
 * @author GIP_03
 */
public class coresdao {
    Connection conn;
    PreparedStatement psmt;
    public void cadastrarCor(Caixadecores objetodto){
        conn = new conexao().conectaBD();
        String sql = "insert into caixadecores.cores (cor,nome,senha) values(?,?,?)";
         try{
             psmt = conn.prepareStatement(sql);
             psmt.setString(1,objetodto.getCor());
             psmt.setString(2,objetodto.getNome());
             psmt.setInt(3,objetodto.getSenha());
             psmt.execute();
             psmt.close();
             JOptionPane.showMessageDialog(null,"Cor cadastrada");
         }catch(SQLException erro){
             JOptionPane.showMessageDialog(null, erro);
         }
    }
    
                                    
}
