package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuarioRepositorio {

	public Connection conn;
	
	public Connection getConn() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}
	
	public List<Usuario> listarUsuario(){
		ArrayList<Usuario> lstUsuario = new ArrayList<Usuario>();
		
		String sql = "select ID, name, email, data_nascimento from usuarios ";
		
		try(	
				Connection conn = this.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
			) {
			
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("name"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
				
				lstUsuario.add(usuario);
			}
		}catch(SQLException ex) {
			System.out.println("Erro na consulta de usuarios");
			ex.printStackTrace();
		}
		return lstUsuario;
		
	}
	
	public void criarUsu(Usuario usuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into usuarios (name, email, senha) ");
		sql.append("values(?, ?, ?)");
		
		try(	
				Connection conn = this.getConn();
				PreparedStatement pst = conn.prepareStatement(sql.toString());
			) {
			
			System.out.println(usuario.getNome());
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			
			pst.execute();
			
			conn.commit();
			
		}catch(SQLException ex) {
			System.out.println("Erro na inclusão de usuarios");
			ex.printStackTrace();
		}
	}
	
	
}
