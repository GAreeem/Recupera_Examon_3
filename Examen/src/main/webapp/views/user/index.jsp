<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
  <title>Incidencias</title>
  <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<div class="container-fluid">
  <div class="row">
        <nav class="navbar bg-body-tertiary">
          <div style="display: flex; align-items: center;" >
            <a class="navbar-brand" href="#" style="display: flex; align-items: center; margin: 10px; margin-left: 40px;">
              Bienvenido Usuario ${user.username}
            </a>
            <a class="navbar-brand" href="/user/logout" style="display: flex; align-items: center; margin: 10px; margin-left: 40px; border-width:1px">
               salir
            </a>
          </div>
          <input hidden value="${incidencia.id}" name="id"/>

        </nav>

      <div class="col text-center mt-5">
        <h2>Solicitudes de retardo</h2>
        <div class="card">
          <div class="card-header">

            <div class="col text-end">
              <a class="btn btn-outline-primary btn-sm" href="/user/crear-incidencias" role="button">Incidencia</a>
            </div>

          </div>
          <div class="card-body">
            <table class="table table-striped">
              <thead>
              <th>#</th>
              <th>Titulo</th>
              <th>Descripción</th>
              <th>Estado</th>
              </thead>
              <tbody>
              <c:forEach var="incidencia" items="${incidencias}" varStatus="s">
                <tr>
                  <td>
                    <c:out value="${s.count}"/>
                  </td>
                  <td>
                    <c:out value="${incidencia.titulo}"/>
                  </td>
                  <td>
                    <c:out value="${incidencia.descripcion}"/>
                  </td>
                  <td>
                    <c:out value="${incidencia.estado}"/>
                  </td>
                  <td>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
  </div>
</div>


<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>