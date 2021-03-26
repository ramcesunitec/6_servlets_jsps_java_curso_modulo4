package c_web_ManejoFormularios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/C_Servlet_ManejoFormularios")
public class Servlet_ManejoFormularios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musicas[] = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet</h1>");
        out.print("<table border='1'>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologia(s)");
        out.print("</td>");
        out.print("<td>");
        for (String tecnologia : tecnologias) {
            out.print(tecnologia);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Genero");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Musica Favorita");
        out.print("</td>");
        out.print("<td>");
        if (musicas != null) {
            for (String musica : musicas) {
                out.print(musica);
                out.print(" / ");
            }
        }else{
            out.print("Valor no proporcionado");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios");
        out.print("</td>");
        out.print("<td>");
        if(comentario!="Escribir un texto"||comentario!=null){
        out.print(comentario);
        }else{
            out.print("Valor no proporcionado");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
}
