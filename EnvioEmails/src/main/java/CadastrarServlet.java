

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cadastrar")
public class CadastrarServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RepositorioEmail rE = new RepositorioEmail();
		Email e = new Email();
		
		e.setRementente(req.getParameter("rementente"));
		e.setDestinatario(req.getParameter("destinatario"));
		e.setTitulo(req.getParameter("titulo"));
		e.setDescricao(req.getParameter("descricao"));
		
		rE.cadastrar(e);

		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RepositorioEmail rE = new RepositorioEmail();
		
		ArrayList<Email> emails = (ArrayList<Email>) rE.listarEmails();
		
		req.setAttribute("e", emails);
		
		req.getRequestDispatcher("listarEmails.jsp").forward(req, resp);;
	}

}
