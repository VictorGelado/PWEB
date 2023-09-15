package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import entidades.Tarefa;

public class RepositorioTarefas {
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/tarefadb", "sa", "sa");
	}
	
	public List<Tarefa> listarTarefas() {
		ArrayList<Tarefa> lstTarefas = new ArrayList<Tarefa>();

		String sql = "select * from tarefa";

		try (Connection conn = this.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(sql);) {

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Tarefa t = new Tarefa();
				t.setId(resultSet.getInt("id"));
				t.setTitulo(resultSet.getString("titulo"));
				t.setDescricao(resultSet.getString("descricao"));

				lstTarefas.add(t);
			}
		} catch (SQLException ex) {
			System.out.println("Erro na consulta de usuarios");
			ex.printStackTrace();
		}
		
		return lstTarefas;
	}
	
	public Tarefa listarTarefa(int id) {

		String sql = "select titulo, descricao from tarefa where id = ? ";

		try (Connection conn = this.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			
			ResultSet resultSet = pst.executeQuery();

			resultSet.next();
			Tarefa t = new Tarefa();
			t.setId(id);
			t.setTitulo(resultSet.getString("titulo"));
			t.setDescricao(resultSet.getString("descricao"));
			
			return t;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		throw new RuntimeException("Usuário não encontrado");
		
	}
}
