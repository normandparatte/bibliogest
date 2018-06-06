<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String isbn = request.getParameter("isbn");
    Book book = MockPersistance.getBookFromISBN(isbn);
    Boolean possede = !bookIsInWishlist(isbn);
%>

<%@include file="includes/header.jsp" %>
<title>BiblioGest | Détail du livre</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" style="margin-top: 75px">
    <h1 class="my-4">BiblioGest
        <small>Détail du livre</small>
    </h1>

    <div class="row">

        <div class="col-md-4">
            <img class="card-img-top img-fluid" src="<%=book.getImageUrl()%>" alt="">
            <h3>Avis personnel</h3>
            <h5>note : <%=book.getPersonalReview().getRating()%></h5>
            <p class="card-text"><%=book.getPersonalReview().getDescription()%></p>
        </div>

        <div class="col-md-8">
            <h3 class="my-3"><%=book.getTitle()%> <small><%= book.getAuthor().getName() %></small></h3>
            <h5>Note moyenne : <%=book.getAverageRating()%> <small>(<%=book.getRatingsCount()%>)</small></h5>
            <% if (!possede){ %>
            <button class="btn btn-success btn-sm btn-block" onclick="<%addBookToLibrary(book);%>">Ajouter à la bibliothèque</button>
            <% } %>
            <hr>
            <p class="card-text"><%=book.getDescription()%></p>
            <hr>
        </div>

    </div>

</div>

<%@include file="includes/footer.jsp" %>