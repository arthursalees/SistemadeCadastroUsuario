/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class conexao {
    public Connection conexaoBD(){
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/cadastrousuario?user=root&password=1234";
            conn = DriverManager.getConnection(url);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
        }return conn;
        
        
        
    }
}
