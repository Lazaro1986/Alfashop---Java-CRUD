<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<jsp:useBean class="br.com.alfashop.repository.CategoriaDAO" id="lstcat"/>


<!DOCTYPE html>
<html>
    <body>
        <div class="container">
          <div class="row">
            
            <%@include file="_inc/_menu.jsp" %>
              
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
              
              <h2>Lista de Categorias</h2>
              <div class="table-responsive">
                <table class="table table-striped table-sm">
                  <thead>
                    <tr>
                      <th scope="col">Cod</th>
                      <th scope="col">Nome</th>
                      <th scope="col">Descrição</th>
                      <th scope="col">Ativo</th>
                      <th scope="col">Opções</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                    <c:forEach items="${lstcat.categorias}" var="objcat">
                    <tr>
                      <td>${objcat.idcategoria}</td>
                      <td>${objcat.nome}</td>
                      <td>${objcat.descricao}</td>
                      <td>${objcat.ativo}</td>
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
