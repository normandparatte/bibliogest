<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp" %>
<title>BiblioGest | Ma bibliothèque</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" style="margin-top: 75px">
    <h1 class="my-4">BiblioGest
        <small>Ma bibliothèque</small>
    </h1>
    <div class="row">
        <%
            if (getLibrary() == null)
                MockPersistance.init();
            if (getLibrary() != null) {
                for (Book book : getLibrary().getBookcase()) {
        %>
        <div class="col-lg-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="<%= book.getImageUrl() %>" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#"><%= book.getTitle() %>
                        </a>
                    </h4>
                    <p class="card-text"><%= book.getDescription() %>
                    </p>
                </div>
            </div>
        </div>
        <% }
        } else {%><p>Aucun livre trouvé !</p><%
        }
        ;
    %>
    </div>
</div>

<%@include file="includes/footer.jsp" %>