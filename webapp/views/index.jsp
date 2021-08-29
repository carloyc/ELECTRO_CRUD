<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/main.css">
    <title>CRUD</title>
</head>
<body>

<nav class="navbar navbar-dark bg-dark ">

    <div >
        <h1> electrodomesticos</h1>
    </div>

</nav>


<table >
    <thead class="">
    <tr>
        <th>No.</th>
        <th>Nombre</th>
        <th>Dirección del fabricante</th>
        <th>Pais</th>
        <th>Estado</th>
        <th>Modificaciones</th>
    </tr>
    </thead>
    <tbody id="Aparatos_listar">
    </tbody>
</table>

<button type="button" class="btn btn-success" id="btn-registrar" data-bs-target="#Modalregistro" data-bs-toggle="modal" >Registrar</button>

<div class="modal fade" id="Modalregistro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registro</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="registrar" method="POST" action="/Servlet?action=Registrar" >
                    <div >
                        <label for="aparato" class="col-form-label">nombre:</label>
                        <input type="text" id="aparato" class="form-control" >
                    </div>
                    <div >
                        <label for="fecha" class="col-form-label">fecha de registro:</label>
                        <input type="date" class="form-control" id="fecha">
                    </div>
                    <div >
                        <label for="calle" class="col-form-label">calle:</label>
                        <input type="text" class="form-control" id="calle">
                    </div>
                    <div >
                        <label for="colonia" class="col-form-label">colonia:</label>
                        <input type="text" class="form-control" id="colonia">
                    </div>
                    <div>
                        <label for="codigo_postal" class="col-form-label">codigo postal:</label>
                        <input type="number" class="form-control" id="codigo_postal">
                    </div>
                    <div >
                        <label for="estado" class="col-form-label">estado:</label>
                        <input type="text" class="form-control" id="estado">
                    </div>
                    <div >
                        <label for="pais" class="col-form-label">pais:</label>
                        <input type="text" class="form-control" id="pais">
                    </div>
                </form>
            </div>
            <div >
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-success" id="btn-guardar">Guardar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="Modalmodificar" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12">
            <div>
                <h1 class="modal-title" id="exampleModalLabel1">Modificar</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div >
                <form class="row g-3" id="Modificar" method="POST" action="${context}/Servlet">
                    <input type="hidden" name="action" value="Modificar">
                    <input type="hidden" name="id" id="id" value="">
                    <div class="col-sm-7">
                        <label for="aparato1" class="col-form-label">Nombre:</label>
                        <input type="text" class="form-control" id="aparato1" name="nombre">
                    </div>
                    <div >
                        <label for="fecha1" class="col-form-label">fecha de registro:</label>
                        <input type="date" class="form-control" id="fecha1" name="fechareg">
                    </div>
                    <div >
                        <label for="calle1" class="col-form-label">calle:</label>
                        <input type="text" class="form-control" id="calle1" name="calle">
                    </div>
                    <div >
                        <label for="colonia1" class="col-form-label">colonia:</label>
                        <input type="text" class="form-control" id="colonia1" name="colonia">
                    </div>
                    <div >
                        <label for="codigo_postal1" class="col-form-label">codigo postal:</label>
                        <input type="text" class="form-control" id="codigo_postal1" name="codigopos">
                    </div>
                    <div>
                        <label for="estado1" class="col-form-label">estado:</label>
                        <input type="text" class="form-control" id="estado1" name="estado">
                    </div>
                    <div >
                        <label for="pais1" class="col-form-label">pais:</label>
                        <input type="text" class="form-control" id="pais1" name="pais">
                    </div>
                </form>

                </div>
            <div >
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="btn-guardar1">Guardar</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="Modaldetalles" tabindex="-1" aria-labelledby="exampleModalLabel3" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12">
            <div class="modal-header">
                <h1 class="modal-title" id="exampleModalLabel3">Modificar</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div >
                <form >
                    <input type="hidden" name="txtidproducto" id="txtidprod2" value="">
                    <div >
                        <label for="producto1" class="col-form-label">Nombre:</label>
                        <input type="text" class="form-control" id="producto1" disabled>
                    </div>
                    <div >
                        <label for="fecha2" class="col-form-label">fecha de registro:</label>
                        <input type="date" class="form-control" id="fecha2" disabled>
                    </div>
                    <div >
                        <label for="calle2" class="col-form-label">calle:</label>
                        <input type="text" class="form-control" id="calle2" disabled>
                    </div>
                    <div >
                        <label for="colonia2" class="col-form-label">colonia:</label>
                        <input type="text" class="form-control" id="colonia2" disabled>
                    </div>
                    <div >
                        <label for="codigo_postal2" class="col-form-label">codigo postal:</label>
                        <input type="text" class="form-control" id="codigo_postal2" disabled>
                    </div>
                    <div >
                        <label for="estado2" class="col-form-label">estado:</label>
                        <input type="text" class="form-control" id="estado2" disabled>
                    </div>
                    <div >
                        <label for="pais2" class="col-form-label">pais:</label>
                        <input type="text" class="form-control" id="pais2" disabled>
                    </div>
                </form>
            </div>
            <div >
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="ModalEliminar" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div >
        <div >
            <div >
                <h1 class="modal-title" id="exampleModalLabel2">eliminar</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div>
                <form  id="Eliminar" method="POST" action="">
                    <input type="hidden" name="id" id="id1" value="">
                    <div >
                        <label for="aparato2" class="col-form-label">Electrodomestico:</label>
                        <input type="text" class="form-control" id="aparato2" disabled>
                    </div>
                </form>
            </div>
            <div >
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-danger" id="btn-guardar2">Eliminar</button>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.bundle.js"></script>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>


