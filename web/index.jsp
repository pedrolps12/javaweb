<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>COMPUFY | Inicio</title>

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
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-right">Monthly</span>
                            <h5>Income</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">1,430</h1>
                            <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                            <small>Total income</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">Annual</span>
                            <h5>Orders</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">3840</h1>
                            <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i></div>
                            <small>New orders</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">Today</span>
                            <h5>visits</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">1012</h1>
                            <div class="stat-percent font-bold text-navy">44% <i class="fa fa-level-up"></i></div>
                            <small>New visits</small>
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Orders</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">Today</button>
                                    <button type="button" class="btn btn-xs btn-white">Monthly</button>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-9">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">
                                        <li>
                                            <h2 class="no-margins">144</h2>
                                            <small>Total orders in period</small>
                                            <div class="stat-percent">48% <i class="fa fa-level-up text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 48%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">251</h2>
                                            <small>Orders in last month</small>
                                            <div class="stat-percent">60% <i class="fa fa-level-down text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 60%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">780</h2>
                                            <small>Monthly income from orders</small>
                                            <div class="stat-percent">22% <i class="fa fa-bolt text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 22%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
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

    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Flot -->
<script src="js/plugins/flot/jquery.flot.js"></script>
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="js/plugins/flot/jquery.flot.spline.js"></script>
<script src="js/plugins/flot/jquery.flot.resize.js"></script>
<script src="js/plugins/flot/jquery.flot.pie.js"></script>
<script src="js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="js/plugins/flot/jquery.flot.time.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<script>
  
  //https://es.stackoverflow.com/questions/21347/duda-sobre-guardar-una-imagen-en-base-de-datos
            var data3 = [
                [gd(2017, 6, 1), 12], [gd(2017, 6, 2), 15], [gd(2017, 6, 3), 25], [gd(2017, 6, 4), 10],
                [gd(2017, 6, 5), 7], [gd(2017, 6, 6), 13], [gd(2017, 6, 7), 15], [gd(2017, 6, 8), 19],
                [gd(2017, 6, 9), 11], [gd(2017, 6, 10), 21], [gd(2017, 6, 11), 8], [gd(2017, 6, 12), 10],
                [gd(2017, 6, 13), 8], [gd(2017, 6, 14), 5], [gd(2017, 6, 15), 9]
            ];


            var dataset = [
                {
                    label: "Ventas",
                    data: data3,
                    yaxis: 2,
                    color: "#1C84C6",
                    lines: {
                        lineWidth:1,
                            show: true,
                            fill: true,
                        fillColor: {
                            colors: [{
                                opacity: 0.2
                            }, {
                                opacity: 0.4
                            }]
                        }
                    },
                    splines: {
                        show: false,
                        tension: 0.6,
                        lineWidth: 1,
                        fill: 0.1
                    },
                }
            ];


            var options = {
                xaxis: {
                    mode: "time",
                    tickSize: [3, "day"],
                    tickLength: 0,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Arial',
                    axisLabelPadding: 10,
                    color: "#d5d5d5"
                },
                yaxes: [{
                    position: "left",
                    max: 1070,
                    color: "#d5d5d5",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Arial',
                    axisLabelPadding: 3
                }, {
                    position: "right",
                    clolor: "#d5d5d5",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: ' Arial',
                    axisLabelPadding: 67
                }
                ],
                legend: {
                    noColumns: 1,
                    labelBoxBorderColor: "#000000",
                    position: "nw"
                },
                grid: {
                    hoverable: false,
                    borderWidth: 0
                }
            };
            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }
            var previousPoint = null, previousLabel = null;
            $.plot($("#flot-dashboard-chart"), dataset, options);
</script>

</body>

</html>
