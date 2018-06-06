<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.modele.api.GoodreadsAPI" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    MockPersistance.init();
    
    String isbn = request.getParameter("isbn");

    if(MockPersistance.getBookFromISBN(isbn)!=null) {
        response.sendRedirect("/sp18_projet2_francis_normand_war_exploded/detail.jsp?isbn=" + isbn);
    }

    Book book = GoodreadsAPI.getBookFromISBN(isbn);
%>

<%@include file="includes/header.jsp" %>
<title>BiblioGest | Résultat de la recherche</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" >
    <h1 class="my-4">BiblioGest
        <small>Résultat de la recherche</small>
    </h1>

    <div class="row">

        <div class="col-md-4">
            <img class="card-img-top img-fluid" src="<%=book.getImageUrl()%>" alt="">
        </div>

        <div class="col-md-8">
            <h3 class="my-3"><%=book.getTitle()%> <small><%= book.getAuthor().getName() %></small></h3>
            <h5>Note moyenne : <%=book.getAverageRating()%> <small>(<%=book.getRatingsCount()%>)</small></h5>
            <form method="post">
                <input type="button" name="addwishlist" value="Ajouter à la wishlist" id="addwishlist" class="btn btn-warning btn-sm btn-block" onclick="<%addBookToWhishlist(book);%>">
                <input type="button" name="addlibrary" value="Ajouter à la bibliothèque" id="addlibrary" class="btn btn-success btn-sm btn-block" onclick="<%addBookToLibrary(book);%>">
            <p class="card-text"><%=book.getDescription()%></p>
        </div>

    </div>

</div>

<%@include file="includes/footer.jsp" %>