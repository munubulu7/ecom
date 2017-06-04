<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         isELIgnored="false" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">
    <title>DataTables example - Pipelining data to reduce Ajax calls for paging</title>
    <link rel="stylesheet" type="text/css" href="/resources/data_table/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="/resources/data_table/css/shCore.css">
    <link rel="stylesheet" type="text/css" href="/resources/data_table/css/demo.css">
    <style type="text/css" class="init">

    </style>
    <script type="text/javascript" language="javascript" src="/resources/data_table/js/jquery.js">
    </script>
    <script type="text/javascript" language="javascript" src="/resources/data_table/js/jquery.dataTables.js">
    </script>
    <script type="text/javascript" language="javascript" src="/resources/data_table/js/shCore.js">
    </script>
    <%--<script type="text/javascript" language="javascript" src="/resources/data_table/js/demo.js"/>--%>
    <script type="text/javascript" language="javascript" class="init">

        //
        // DataTables initialisation
        //
        $(document).ready(function () {
            $.ajax({
                url: "/jpa",
                data: {
                    column: true
                },
                dataType: "json",
                success: function (result) {
                    $("#example").DataTable({
                        "processing": true,
                        "serverSide": true,
                        "ajax": "/jpa",
                        "columns": result.columns
                    });
                }
            });
        });

    </script>
</head>
<body class="dt-example">
<div class="container">
    <section>
        <h1>DataTables example <span>Pipelining data to reduce Ajax calls for paging</span></h1>
        <table id="example" class="display" cellspacing="0" width="100%">
        </table>
    </section>
</div>
</body>
</html>