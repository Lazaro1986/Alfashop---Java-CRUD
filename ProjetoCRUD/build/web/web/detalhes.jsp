<%@include file="./_inc/_header.jsp" %>

<%@page import="java.util.List" %>
<%@page import="br.com.alfashop.model.Produto" %>
<%@page import="br.com.alfashop.repository.ProdutoDAO" %>
<%
String filtro = "1 != 1";
Long idp = 0L;
if(request.getParameter("idp") != null){
    String sidp = request.getParameter("idp");
    try{
        idp = Long.parseLong(sidp);
        filtro = "idprodutos = "+idp;
    } catch(Exception e){}
}
ProdutoDAO daopro = new ProdutoDAO();
List<Produto> lstpro = daopro.buscar(filtro);
pageContext.setAttribute("lstpro", lstpro);
%>

<!doctype html>
<html lang="en">

      <%@include file="./_inc/_menu.jsp" %>

      <c:forEach items="${lstpro}" var="objpro">
        <div class="container px-4 py-4" id="custom-cards">
          <h2 class="pb-2 border-bottom">${objpro.nome}</h2>
          <div class="row row-cols-1 row-cols-lg-3 align-itens-stretch g-4 py-5">
              ${objpro.descricao}
              <br><br>
              ${objpro.maisinfo}
              <br><br>
              R$ ${objpro.valor}
          </div>
        </div>
      </c:forEach>
<%@include file="./_inc/_footer.jsp" %>

    <script src="./assets/js/bootstrap.bundle.min.js"></script>

</html>
