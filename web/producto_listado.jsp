<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PROYECTO | USUARIOS</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body  class="fixed-nav md-skin">
<div id="wrapper">
    <!-- SIDEBAR -->
    <%@include file="WEB-INF/jspf/sidebar_admin.jspf" %>
    <!-- END SIDEBAR-->
    <div id="page-wrapper" class="gray-bg">
        <!-- NAV -->
        <%@include file="WEB-INF/jspf/nav_admin.jspf" %>
        <!-- END NAV-->        
        <div class="wrapper wrapper-content fadeInLeft">                
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                          <h5><b>PRODUCTOS</b></h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <!--
                            <div class="row">
                                <div class="col-sm-9 m-b-xs">
                                </div>
                                <div class="col-sm-3">
                                    <div class="input-group"><input type="text" placeholder="Buscar" class="input-sm form-control"> <span class="input-group-btn">
                                    <button type="button" class="btn btn-sm btn-primary"> Ir!</button> </span></div>
                                </div>
                            </div>
                            -->
                            <a class="btn btn-primary btn-sm" href="Productos?action=agregar"><i class="fa fa-plus" style="margin-right:5px;"></i>Agregar Producto
                            </a>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">#</th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Nombre </th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Descripcion </th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Precio Unitario </th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Unidades en Stock </th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Descuento </th>
                                        <th style="color:white;background:url('img/bor.png') fixed center" class="text-center">Acciones </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="cont" scope="session" value="${0}"/>
                                    <c:forEach items="${products}" var="product">
                                        <c:set var="cont" scope="session" value="${cont+1}"/>
                                        <tr>
                                            <td class="text-center "><c:out value="${cont}" /></td>
                                            <td ><c:out value="${product.name}" /></td>
                                            <td ><c:out value="${product.description}" /></td>
                                            <td ><c:out value="${product.unitPrice}" /></td>
                                            <td ><c:out value="${product.unitInStock}" /></td>
                                            <td ><c:out value="${product.disccount}" /></td>
                                            <td class="text-center col-xs-2">
                                                <div class="btn-group">
                                                    <a class="btn btn-xs btn-warning" href="Productos?action=edit&id=<c:out value="${product.id}"/>">Modificar</a>
                                                    <button class="btn btn-xs btn-danger openModal" prop1="<c:out value="${product.id}"/>" href="#"  name="openModal">Eliminar</button>
                                                </div>
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
               
        </div>
        <div class="footer">
            <div class="pull-right">
                
            </div>
            <div>
                <strong>Copyright</strong> CompuFy Solutions &copy; 2017
            </div>
        </div>
        <div class="modal fade" id="modalEliminar" role="dialog">
          <div class="modal-dialog modal-sm">
            <!-- Modal content-->
            <div class="modal-content">          
              <div class="modal-body">
                <h3 class="modal-title text-center">¿Esta seguro de eliminar el registro?</h3>
              </div>
              <div class="modal-footer">
                <button type="button" id="delFinal" onclick="" class="btn btn-danger" data-dismiss="modal">Aceptar</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              </div>
            </div>

          </div>
        </div>                            
    </div>
</div>
    <!-- Mainly scripts -->
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <script src="js/bootstrap-confirmation.min.js"></script>
    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>  
    
    <script>
    $(function (){
        var id=0;
        $(".openModal").click(function(){
            id = $(this).attr("prop1");
            $("#modalEliminar").modal();
        });
        $('#delFinal').click(function (){
          location.href='Categorias?action=delete&id='+id;
        })
    });
    </script>
</body>
</html>
