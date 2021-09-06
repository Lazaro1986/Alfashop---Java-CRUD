package br.com.alfashop.controller;

import br.com.alfashop.model.Usuario;
import br.com.alfashop.repository.UsuarioDAO;
import br.com.alfashop.util.Util;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lázaro
 */
public class LoginExec extends HttpServlet {

    protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        //pegar dados do form
        String ema = request.getParameter("ema");
        String sen = request.getParameter("sen");
        sen = Util.sha1(sen);
        
        //montar filtro
        //senha_inexistente' or 'a' = 'a
        //String filtro = "email = '" +ema+ "'and senha = '" +sen+"'";
        
        //consultar dados utilizando a classe DAO
        UsuarioDAO daousu = new UsuarioDAO();
        List<Usuario> lstusu = daousu.validar(ema, sen);
        
        String destino = "";
        String msg = "";
        if(lstusu.size() > 0){
            //se deu certo, vai para a página de adm
            Usuario usu = lstusu.get(0);
            session.setAttribute("usu", usu); //pega o 1r0 objeto usuario da lista
            destino = "dashboard.jsp"; //cria uma variável de sessão com esse objeto usuario
        }else{
            //se deu errado, volta para a página de login com aviso
            msg = "err";
            destino = "./?msg="+msg;
        }
        response.sendRedirect(destino);
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //fazer outra ação para dados enviados por get
        response.sendRedirect("index.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        validarLogin(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
