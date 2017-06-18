<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                                  <h5><b style="color: #16987e"><u>AGREGAR CLIENTE </u></b></h5>
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
                                    <form method="POST" action='Clientes'  name="frmAddUser" class="form-horizontal">
                                        <input type="hidden" name="ubigeo" id="ubigeo" value="<c:out value="${customer.ubigeo}" />">
                                        <input type="hidden"  name="id" value="<c:out value="${customer.id}" />"> 
                                        
            
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Nombres</label>
                                            <div class="col-lg-10">
                                                <input name="firstName" required autofocus value="<c:out value="${customer.firstName}" />" type="text" placeholder="Nombres" class="form-control">                                                 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Apellidos</label>
                                            <div class="col-lg-10">
                                                <input name="lastName" required value="<c:out value="${customer.lastName}" />" type="text" placeholder="Apellidos" class="form-control">                                                 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Correo</label>
                                            <div class="col-lg-4">
                                                <input name="email" value="<c:out value="${customer.email}" />" type="email" placeholder="Correo" class="form-control">
                                            </div>
                                            <label class="col-lg-2 control-label">Fecha de Nac.</label>
                                            <div class="col-lg-4">
                                                <input name="birthDate" value="${customer.birthDate}" required type="date" placeholder="Fecha de Nacimiento" class="form-control"> 
                                            </div>
                                        </div>
                                            
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label">Departamento</label>
                                            <div class="col-lg-2">
                                                <select required id="departamento" class="form-control"></select>

                                            </div>
                                            <label class="col-lg-2 control-label">Provincia</label>
                                            <div class="col-lg-2">
                                                <select required id="provincia" class="form-control"></select>
                                            </div>
                                            <label class="col-lg-2 control-label">Distrito</label>
                                            <div class="col-lg-2">
                                                <select id="distrito" required name="distrito" class="form-control"></select>
                                            </div>
                                        </div>
                                            <hr>
                                        <div class="form-group">
                                            <div class="col-lg-12 text-right">
                                                <input class="btn btn-primary" type="submit" value="Grabar Cliente">
                                                <a href="/ProyectoCibertec/Clientes?action=listCustomer" class="btn btn-warning" >Cancelar</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        
                    </div>
                    </div>
                
                    <div class="footer fixed">
                        <div>
                            <strong>Copyright</strong> Pedro Lucky Peña Salazar &copy; 2017
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
    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>  
    <script type="text/javascript">
            $(function () {
                var ubigeo = $('#ubigeo').val();
                
                $.ajax({
                    url: "Ubigeo",  data: {iddept: "", idprov :""}, dataType: "json",
                    success: function (departamentos) {                        
                        var option = "";var sel= '';
                        for (var dept in departamentos) {
                            var item = departamentos[dept];sel = (ubigeo!=="" && item.idubigeo.substring(0,2) === ubigeo.substring(0,2) ) ? ' selected ':'';
                            option += "<option value='" + item.idubigeo.substring(0,2) +"' "+sel+">" + item.departamento + "</option>";
                        }
                        $("#departamento").html(option);
                        (ubigeo==="")? $("#departamento").val(0):$("#departamento").trigger("change");                     
                    }
                });
                $('#departamento').change( function (){
                    var coddep = $('#departamento').val();
                    $.ajax({                        
                        url: "Ubigeo",data: {iddept: coddep, idprov :""},dataType: "json",                        
                        success: function (provincias) {
                            var option = "";var sel= '';
                            for (var prov in provincias) {
                                var item = provincias[prov];sel = (ubigeo!=="" && item.idubigeo.substring(0,4) === ubigeo.substring(0,4) ) ? ' selected ':'';
                                option += "<option value='" + item.idubigeo.substring(0,4) +"' "+sel+">" + item.provincia + "</option>";                                
                            }
                            $("#provincia").html(option);
                            if(ubigeo === ""){
                                $('#distrito').empty();$('#provincia').focus().val(0);
                            }else{
                                $("#provincia").trigger("change"); 
                            }
                        }
                    });
                });
                $('#provincia').change( function (){
                    var coddep = $('#departamento').val();var codpro = $('#provincia').val();
                    $.ajax({                        
                        url: "Ubigeo",data: {iddept: coddep,idprov : codpro},dataType: "json",
                        success: function (distritos) {                                                      
                            var option = "";var sel='';
                            for (var dist in distritos) {
                                var item = distritos[dist];
                                console.log(item.idubigeo);
                                sel = (ubigeo!=="" && item.idubigeo === ubigeo ) ? ' selected ':'';
                                option += "<option value='" + item.idubigeo +" ' "+sel+">" + item.distrito + "</option>";
                            }
                            $("#distrito").html(option);
                            if ( ubigeo !== "") {
                                ubigeo="";
                            }else{
                                $('#distrito').val(0).focus();
                            }
                        }
                    });
                }); 
            });
    </script>
</body>
</html>
