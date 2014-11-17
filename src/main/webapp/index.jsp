<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Dashboard</title>
        <jsp:include page="include/header-resources-include.jsp"></jsp:include>
    </head>
    <body class="skin-blue">
    	<jsp:include page="include/header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <jsp:include page="include/left.jsp"></jsp:include>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Blank page
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Blank page</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">


                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

		<jsp:include page="include/footer-resources-include.jsp"></jsp:include>
	
    </body>
</html>