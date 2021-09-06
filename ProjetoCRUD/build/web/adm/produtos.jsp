<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<jsp:useBean class="br.com.alfashop.repository.ProdutoDAO" id="lstpro"/>

<!DOCTYPE html>
<html>
    <body>
        <div class="container">
          <div class="row">
            
            <%@include file="_inc/_menu.jsp" %>
              
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
              
              <h2>Lista de Produtos</h2>
              <div class="table-responsive">
                <table class="table table-striped table-sm">
                  <thead>
                    <tr>
                      <th scope="col">Cod</th>
                      <th scope="col">Nome</th>
                      <th scope="col">Valor</th>
                      <th scope="col">Peso</th>
                      <th scope="col">Destaque</th>
                      <th scope="col">Ativo</th>
                      <th scope="col">Opções</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    
                    <c:forEach items="${lstpro.produtos}" var="objpro">
                    <tr>
                      <td>${objpro.idproduto}</td>
                      <td>${objpro.nome}</td>
                      <td>${objpro.valor}</td>
                      <td>${objpro.peso}</td>
                      <td>${objpro.destaque}</td>
                      <td>${objpro.ativo}</td>
                      <td>
                          <a href="#">[ A ]</a>
                          <a href="#">[ X ]</a>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                  
                </table>
              </div>
            </main> 
          </div>
        </div>
    </body>
</html>
