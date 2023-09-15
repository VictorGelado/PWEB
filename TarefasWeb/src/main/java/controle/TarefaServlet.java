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

@WebServlet("/visualizar")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RepositorioTarefas r = new RepositorioTarefas();
		
		int id = Integer.valueOf(req.getParameter("id"));
		
		Tarefa t = r.listarTarefa(id);
		
		req.setAttribute("t", t);
		
		req.getRequestDispatcher("tarefaWeb.jsp").forward(req, resp);

	}

}
