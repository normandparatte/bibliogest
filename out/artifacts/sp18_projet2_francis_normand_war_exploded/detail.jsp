<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="includes/header.jsp" %>
<title>BiblioGest | Détail du livre</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" style="margin-top: 75px">
    <h1 class="my-4">BiblioGest
        <small>Détail du livre</small>
    </h1>


    <div class="card mt-4">
        <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
        <div class="card-body">
            <h3 class="card-title">Mon livre</h3>
            <h5>Note : 4.5</h5>
            <p class="card-text">Résumé du livre</p>

        </div>
    </div>
    <!-- /.card -->

    <div class="card card-outline-secondary my-4">
        <div class="card-header">
            <h5>Remarque personnelle</h5>
        </div>
        <div class="card-body">
            <p>Mon commentaire personnel ici !</p>
        </div>
    </div>

</div>

<%@include file="includes/footer.jsp" %>