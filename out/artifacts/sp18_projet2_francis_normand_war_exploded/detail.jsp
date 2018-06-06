<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Review" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.modele.api.GoodreadsAPI" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MockPersistance.init();

    String isbn = request.getParameter("isbn");
    Book book = MockPersistance.getBookFromISBN(isbn);
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
            <% if (book.getPersonalReview()!= null){ %>
            <h3>Avis personnel</h3>
            <h5>note : <%=book.getPersonalReview().getRating()%></h5>
            <p class="card-text"><%=book.getPersonalReview().getDescription()%></p>
            <% } %>
        </div>

        <div class="col-md-8">
            <h3 class="my-3"><%=book.getTitle()%> <small><%= book.getAuthor().getName() %></small></h3>
            <h5>Note moyenne : <%=book.getAverageRating()%> <small>(<%=book.getRatingsCount()%>)</small></h5>
            <% if (!bookIsInLibrary(isbn)){ %>
            <form method="post">
                <input type="button" name="addlibrary" value="Ajouter à la bibliothèque" id="addlibrary" class="btn btn-success btn-sm btn-block" onclick="<%addBookToLibrary(book);%>">
            </form>
            <% } else { %>
            <form method="post" action="bibliotheque.jsp">
                <input type="button" name="deletelibrary" value="Supprimer de la bibliothèque" id="deletelibrary" class="btn btn-danger btn-sm btn-block" onclick="<%removeBookFromLibrary(book.getIsbn10());%>">
            </form>
            <% } %>
            <hr>
            <p class="card-text"><%=book.getDescription()%></p>
        </div>

    </div>
    <hr>
    <h3>Livres similaires</h3>
    <div class="row">
        <%
            if (getLibrary() == null)
                MockPersistance.init();

            if (getLibrary() != null) {
                for (Book suggest : GoodreadsAPI
                        .getSimilarBooks(MockPersistance.getLibrary().getBookcase().get(0).getIsbn10())) {
        %>
        <div class="col-lg-2 portfolio-item">
            <div class="card h-100">
                <a href="/sp18_projet2_francis_normand_war_exploded/recherche.jsp?isbn=<%if(suggest.getIsbn10()!=null){out.print(suggest.getIsbn10());}else{out.print(suggest.getIsbn13());}%>"><img class="card-img-top" src="<%= suggest.getImageUrl() %>" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/sp18_projet2_francis_normand_war_exploded/recherche.jsp?isbn=<%if(suggest.getIsbn10()!=null){out.print(suggest.getIsbn10());}else{out.print(suggest.getIsbn13());}%>"><%= suggest.getTitle() %>
                        </a>
                    </h4>
                    <!--<p class="card-text"><%//= suggest.getDescription() %>-->
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