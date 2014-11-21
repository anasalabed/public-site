<!DOCTYPE html>
<html class="bg-black" xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:p="http://java.sun.com/jsf/passthrough"
     xmlns:ui="http://java.sun.com/jsf/facelets">
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
        <link href="#{request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="#{request.contextPath}/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="#{request.contextPath}/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="#{request.contextPath}/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="#{request.contextPath}/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="#{request.contextPath}/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="#{request.contextPath}/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <style>
        	.ui-growl-item{
        		background-color: #993D3D;
        		border: 0px;
        	}
        	.ui-state-highlight, .ui-widget-content .ui-state-highlight, .ui-widget-header .ui-state-highlight{
        		border: 0px;
        	}
        	.ui-growl-title{
        		color: white;
        	}
        	.ui-datatable tbody td{
        		text-align: center;
        	}
        	.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default{
        		background: none;
        	}
        	.ui-widget-header{
        		background: none;
        	}
        	.noBorder{
        		border: 1px solid #FFFFFF;
        	}
        	
        	.noBorder tr{
        		border: 1px solid #FFFFFF;
        	}
        	.ui-draggable .ui-dialog-titlebar{
        		 background-color: #0073b7 !important;
        	}
        </style>
        <p:ajaxStatus onstart="PF('statusDialog').show();" onsuccess="setTimeout(function(){PF('statusDialog').hide()}, 200);" /> 
		<p:dialog
			widgetVar="statusDialog" modal="true" draggable="false"
			closable="false" resizable="false" showHeader="false">
			<p:graphicImage name="#{request.contextPath}/img/ajax-loader.gif" width="220px" height="20px" />
			
		</p:dialog> 
</html>