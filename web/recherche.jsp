<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="includes/header.jsp" %>
<title>BiblioGest | Résultat de la recherche</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" style="margin-top: 75px">
    <h1 class="my-4">BiblioGest
        <small>Résultat de la recherche</small>
    </h1>


    <div class="card mt-4">
        <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
        <div class="card-body">
            <h3 class="card-title">Le livre recherché</h3>
            <h5>Note : 3.8</h5>
            <p class="card-text">Résumé du livre</p>

        </div>
    </div>
    <!-- /.card -->

</div>

<%@include file="includes/footer.jsp" %>