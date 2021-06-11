package g_web_Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/G_servlet_Cookies")
public class ManejoCookiesServlet_Cookies extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario=true;
        
        //Obtenemos el arreglo de cookies
        Cookie[] cookies=request.getCookies();
        
        //Buscamos si ya existe un cookie creada con anterioridad llamada visitanteRecurrente
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("visitanteRecurrente")&&c.getValue().equals("si")){
                    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario=false;
                    break;
                }
            }
        }
        
        String mensaje;
        if(nuevoUsuario){
            Cookie visitanteCookie=new Cookie("visitanteRecurrente","si");
            response.addCookie(visitanteCookie);
            mensaje="Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje="Gracias por visitar nuevamente nuestro sitio";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print("Mensaje: "+mensaje);
        out.close();
    }
}
