<%@include file="./_inc/_header.jsp" %>

<%@page import="java.util.List" %>
<%@page import="br.com.alfashop.model.Produto" %>
<%@page import="br.com.alfashop.repository.ProdutoDAO" %>
<%
String filtro = "1 != 1";
Long idc = 0L;
String nom = "";

//pegar o parametro "idc" que veio na URL (id da categoria)
if(request.getParameter("idc") != null){
    String sidc = request.getParameter("idc");

    try{
        idc = Long.parseLong(sidc);
        filtro = "categorias_idcategorias = "+idc;
    } catch(Exception e){}
}

//pegar o parâmetro "nom" que veio pela pesquisa do form no topo da página
if(request.getParameter("nom") != null){
    nom = request.getParameter("nom");
    filtro = "p.nome like '%"+nom+"%' ";
}

//criar um objeto DAO para consultar por ID de categoria
ProdutoDAO daopro = new ProdutoDAO();

//utilizar o retorno (lista) para exibir os dados
//(neste caso, sem fazer uso do <jsp:useBean>)
List<Produto> lstpro = daopro.buscar(filtro);

//adicionar o objeto a um atributo da página,
//para ser utilizado no EL (Expression Language)
pageContext.setAttribute("lstpro", lstpro);
%>

<!doctype html>
<html lang="en">

      <%@include file="./_inc/_menu.jsp" %>

        <div class="container px-4 py-4" id="custom-cards">
          <h2 class="pb-2 border-bottom">Lista de Produtos</h2>
          <div class="row row-cols-1 row-cols-lg-3 align-itens-stretch g-4 py-5">

              <c:forEach items="${lstpro}" var="objpro">
                <div class="col">
                  <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg"
                       style="background-image: url('https://picsum.photos/410/280?random=${objpro.idproduto}');">
                    <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
                      <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">
                          <a href="detalhes.jsp?idp=${objpro.idproduto}">${objpro.nome}</a>
                      </h2>
                      <ul class="d-flex list-unstyled mt-auto">
                        <li class="me-auto">
                          R$ ${objpro.valor}
                        </li>
                        <li class="d-flex align-itens-center me-3">
                          <small>${objpro.nomecat}</small>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </c:forEach>

          </div>
        </div>
<%@include file="./_inc/_footer.jsp" %>

    <script src="./assets/js/bootstrap.bundle.min.js"></script>

</html>
