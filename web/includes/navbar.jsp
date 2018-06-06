<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container" >
        <a class="navbar-brand" href="/sp18_projet2_francis_normand_war_exploded/index.jsp">BiblioGest</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/sp18_projet2_francis_normand_war_exploded/index.jsp">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="/sp18_projet2_francis_normand_war_exploded/bibliotheque.jsp">Ma bibliothèque</a>
                </li>
                <form class="form-inline my-2 my-lg-0" method="GET" action="recherche.jsp">
                    <input class="form-control mr-sm-2" type="search"
                           placeholder="Rechercher un livre (ISBN)" name="isbn">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Rechercher
                    </button>
                </form>
            </ul>
        </div>
    </div>
</nav>