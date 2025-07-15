
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class exportar {
    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    public void exportar(){
        String sql = " Select * FROM cadastrousuario.usuarios";
        String nomeArquivo = "C:\\Users\\daviv\\OneDrive\\Documentos\\NetBeansProjects\\Teladecadastro";
        try{ conn = new conexao().conexaoBD();
        psmt = conn.prepareStatement(sql);
        rs = psmt.executeQuery();
        
        CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo + "\\usuario.csv"));
        
        String[] header = {"id", "nome", "idade", "email", "telefone", "cpf"};
        writer.writeNext(header);
        
        while(rs.next()){
        String [] linha = {
        String.valueOf(rs.getInt("id")),rs.getString("nome"), String.valueOf(rs.getInt("idade")),
        rs.getString("email"), rs.getString("telefone"), rs.getString("cpf")
        };
        writer.writeNext(linha);
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "CSV exportado com sucesso!!");
        }catch (IOException | SQLException e){
        JOptionPane.showMessageDialog(null, "erro ao exportar " + e.getMessage());

        
        
        
      }
    }
}
