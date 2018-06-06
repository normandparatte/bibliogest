<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.MockPersistance" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<title>BiblioGest | Accueil</title>
<%@include file="includes/navbar.jsp" %>

<%
    MockPersistance.init();
%>

<div class="container">
    <h1 class="my-4">BiblioGest
        <small>Accueil</small>
    </h1>
    <div class="row">
        <div class="col-3 portfolio-item">
            <div class="card h-100">
                <a href="/sp18_projet2_francis_normand_war_exploded/bibliotheque.jsp"><img
                        class="card-img-top"
                        src="https://cdn2.iconfinder.com/data/icons/circle-icons-1/64/bookshelf-256.png"
                        alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/sp18_projet2_francis_normand_war_exploded/bibliotheque.jsp">Ma
                            bibliothèque</a>
                    </h4>
                </div>
            </div>
            </a>
        </div>
        <div class="col-3 portfolio-item">
            <div class="card h-100">
                <a href="/sp18_projet2_francis_normand_war_exploded/wishlist.jsp"><img
                        class="card-img-top"
                        src="https://cdn2.iconfinder.com/data/icons/circle-icons-1/64/heart-256.png"
                        alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/sp18_projet2_francis_normand_war_exploded/wishlist.jsp">Ma liste
                            d'envie</a>
                    </h4>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>