package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tarefa;
import repositorio.RepositorioTarefas;

@WebServlet("/tarefasWeb")
public class TarefasWebServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RepositorioTarefas r = new RepositorioTarefas();
		
		ArrayList<Tarefa> lT = (ArrayList<Tarefa>) r.listarTarefas();
		
		req.setAttribute("tarefa", lT);
		
		req.getRequestDispatcher("listagemTarefas.jsp").forward(req, resp);
		
	}

}
