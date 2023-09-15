

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RepositorioEmail {

	public Connection getConn() throws SQLException {		
		return DriverManager.getConnection("jdbc:h2:~/usuarioEmail", "sa", "sa");
	}
	
	
	public void cadastrar(Email e) {
		String sql = "insert into EMAIL (rementente, destinatario, titulo, descricao) values (?, ?, ?, ?) ";
		
		try (
				Connection conn = getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
			) {
			
			pst.setString(1, e.rementente);
			pst.setString(2, e.destinatario);
			pst.setString(3, e.titulo);
			pst.setString(4, e.descricao);
			
			pst.execute();
			
			conn.commit();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public List<Email> listarEmails() {
		String sql = "select * from email";
		
		ArrayList<Email> emails = new ArrayList<Email>();
		
		try (
				Connection conn = getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
			) {
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Email e = new Email();
				
				e.setId(rs.getInt("id"));
				e.setDescricao(rs.getString("descricao"));
				e.setTitulo(rs.getString("titulo"));
				e.setRementente(rs.getString("rementente"));
				e.setDestinatario(rs.getString("destinatario"));
			
				emails.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return emails;
	}

}
