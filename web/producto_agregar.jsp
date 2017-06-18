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
    <link href="css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
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
                                  <h5><b style="color: #16987e"><u>AGREGAR PRODUCTO </u></b></h5>
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
                                    <form method="POST" action='Productos' enctype="multipart/form-data" name="frmAddProduct" class="form-horizontal" >
                                        <input type="hidden" name="categoria" id="categoria" value="<c:out value="${products.categories_id}" />">
                                        <input type="hidden"  name="id" value="<c:out value="${products.id}" />">     
                                        
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Nombre</label>
                                                    <div class="col-lg-10">
                                                        <input name="name" required autofocus value="<c:out value="${products.name}" />" type="text" placeholder="Nombre" class="form-control">                                                 
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Descripcion</label>
                                                    <div class="col-lg-10">
                                                        <input name="description" required value="<c:out value="${products.description}" />" type="text" placeholder="Descripcion" class="form-control">                                                 
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Categorias</label>
                                                    <div class="col-lg-10">
                                                        <select required name="categories_id" id="categories_id" class="form-control"></select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Cantidad por Unid.</label>
                                                    <div class="col-lg-10">
                                                        <input name="quantityPerUnit" required value="<c:out value="${products.quantityPerUnit}" />" type="number" placeholder="" class="form-control">                                                 
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Unidades en Stock</label>
                                                    <div class="col-lg-10">
                                                        <input name="unitInStock" required value="<c:out value="${products.unitInStock}" />" type="number" placeholder="" class="form-control">                                                 
                                                    </div>
                                                </div>   
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Precio Unit.</label>
                                                    <div class="col-lg-10">
                                                        <input name="unitPrice" required value="<c:out value="${products.unitPrice}" />" type="number" placeholder="0.00" class="form-control">                                                 
                                                    </div>
                                                </div>      
                                                
                                                <div class="form-group">
                                                    <label class="col-lg-2 control-label">Descuento</label>
                                                    <div class="col-lg-10">
                                                        <input name="disccount" required value="<c:out value="${products.disccount}" />" type="number" placeholder="0.00" class="form-control">                                                 
                                                    </div>
                                                </div>                                                         
                                                    
                                            </div>
                                            <div class="col-lg-6" >                                                    
                                                <div class="fileinput fileinput-new" data-provides="fileinput">                                                    
                                                    <div class="input-group">
                                                        <div class="form-control" data-trigger="fileinput">
                                                            <i class="glyphicon glyphicon-file fileinput-exists"></i>
                                                        <span class="fileinput-filename"></span>

                                                        </div>

                                                        <span class="input-group-addon btn btn-default btn-file">
                                                            <span class="fileinput-new">Seleccione una Imagen</span>
                                                            <span class="fileinput-exists">Change</span>
                                                            <input id="imgInp" type="file" name="file"/>
                                                        </span>

                                                        <a href="#" class="input-group-addon btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                                                    </div>
                                                    
                                                    <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 100%; height: 150px;">
                                                        <c:if test = "${products.picture == null}">
                                                            <img src="holder.js/300x200">
                                                        </c:if>
                                                        <c:if test = "${products.picture != null}">
                                                            <img id='abc' src="imgServer/${products.picture}">
                                                        </c:if>
                                                           
                                                    </div>
                                                    
                                                </div>    
                                                
                                            </div>
                                        </div>
                                        <hr>            
                                        <div class="form-group">
                                            <div class="col-lg-12 text-right">
                                                <input class="btn btn-primary" type="submit" value="Grabar Producto">
                                                <a href="/ProyectoCibertec/Productos?action=listProducts" class="btn btn-warning" >Cancelar</a>
                                            </div>
                                        </div>                                        
                                    </form>
                                </div>
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
    
   <!-- Jasny -->
    <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>
    <script src="js/holder.js"></script>
    
    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>  

    <script>
        $(function () {
            var cat = $('#categoria').val();
            
            $.ajax({
                url: "Categorias",data: {catego :"porid"},  dataType: "json",
                success: function (categorias) {                        
                    var option = "";var sel= '';
                    for (var cate in categorias) {
                        var item = categorias[cate];
                        option += "<option value='"+ item.id+"' "+sel+">" + item.name + "</option>";
                    }
                    $("#categories_id").html(option);
                    if( categoria!=="" ){
                        $('#categories_id').val(cat);
                    }
                }
            });
            $('#imgInp').on('change.bs.fileinput', function(event) {
              event.stopPropagation();
              
              console.log(event);
          });
        });
    </script>
</body>
</html>
