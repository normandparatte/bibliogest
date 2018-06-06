<%@ page import="ch.hearc.ig.odi.bibliogest.modele.business.Book" %>
<%@ page import="static ch.hearc.ig.odi.bibliogest.controleur.MockPersistance.*" %>
<%@ page import="ch.hearc.ig.odi.bibliogest.controleur.*" %>
<%@ page import="static jdk.nashorn.internal.objects.Global.print" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MockPersistance.init();
%>

<%@include file="includes/header.jsp" %>
<title>BiblioGest | Wishlist</title>
<%@include file="includes/navbar.jsp" %>

<div class="container" style="margin-top: 75px">
    <h1 class="my-4">BiblioGest
        <small>Wishlist</small>
    </h1>
    <div class="row">
        <%
            if (getLibrary() == null)
                MockPersistance.init();

            if (getLibrary() != null) {
                for (Book book : getWishlist().getBookcase()) {
        %>
        <div class="col-lg-6 portfolio-item">
            <div class="card h-100">
                <a href="/sp18_projet2_francis_normand_war_exploded/detail.jsp?isbn=<%if(book.getIsbn10()!=null){out.print(book.getIsbn10());}else{out.print(book.getIsbn13());}%>"><img class="card-img-top" src="<%= book.getImageUrl() %>" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/sp18_projet2_francis_normand_war_exploded/detail.jsp?isbn=<%if(book.getIsbn10()!=null){out.print(book.getIsbn10());}else{out.print(book.getIsbn13());}%>"><%= book.getTitle() %>
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