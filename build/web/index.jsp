<%-- 
    Document   : index
    Created on : 30/09/2013, 19:39:11
    Author     : Higor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.dengue.teste.CriaJson"%>
<%@page import="br.dengue.modelo.Dados"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/signin.css" />
        <link rel="stylesheet" type="text/css" href="css/painel.css" />
        
        <title>Dengue</title>
    </head>
    <body>
        
        <c:choose>
            <c:when test="${ user eq null }">
                <jsp:forward page="erroLogin.jsp" />
            </c:when>
            <c:otherwise>
                <p>Bem-vindo ${ user.nome }</p>
            </c:otherwise>

        </c:choose>


        <span class="text-center" id="systemTitle"> <h3> Sistema de Controle de Endemias </h3></span>
        <div class="navbar-inverse">
            <nav class="navbar navbar-default" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Sistema de Controle de Endemias</span>
                        <span class="icon-bar"></span>

                    </button>
                    <a class="navbar-brand" href="index.jsp">Home</a>

                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Sistema de Controle de Endemias</span>
                    </button>
                    <ul class="nav navbar-nav navbar-left">
                        <a class="nav navbar-brand navbar-left" href="logout.jsp">Sair</a>
                    </ul>
                </div>
            </nav>
        </div>
        <div id="mapa" style="height: 500px; width: 100%">


            <script src="js/jquery.min.js"></script>

            <!-- Maps API Javascript -->
            <script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

            <!-- Caixa de informação -->
            <script src="js/infobox.js"></script>

            <!-- Agrupamento dos marcadores -->
            <script src="js/markerclusterer.js"></script>

            <!-- Arquivo de inicialização do mapa -->
            <script src="js/mapa.js"></script>

        </div>

        <div id="center"
             <!-- Favor não alterar o Form sem consulta com o desenvolvedor -->
             <div id="form" class="form-signin form-control-static">
                <h4><span class="alert alert-warning">Supervisionar Marcador</span></h4>
                <form name="form" method="POST" action="alteraMarcador">
                    <!-- Div especial para input de id (comentário para modo desenvolvimento) -->
                    <div id="idMarker"></div>
                    <br />
                    <!-- Div especial para mostrar descrição do problema (comentário para modo desenvolvimento) -->
                    <div id="markerDescription" class="alert-danger"></div>
                    <br />
                    <!-- Altera status -->

                    <select id="selector" name="statusMarcador">
                        <option value="0" >Não Resolvido</option>
                        <option value="1" >Resolvido</option>
                        <!--                    <option value="0" name="statusMarcador">Não Resolvido</option>
                                            <option value="1" name="statusMarcador">Resolvido</option>-->
                    </select>
                    <br />
                    <br /> 
                    <!--<input type="submit" value="Alterar" onclick="atualiza" class="btn btn-success"> -->
                    
                      <input type="submit" value="Alterar" class="btn btn-info">
                <a href="http://localhost/dengue/index.php"><input type="button" name="Atualiza" value="Atualiza Mapa" class="btn btn-success"/></a>
                    
                </form>

            </div>
        </div>
        <!-- Obrigado pela atenção -->

        <div id="rodape">
            <br />
            <p class="text-center"><span class=text-info"> Projeto idealizado por: Prof. Dr. Fernando Matos</span><br/>
                Desenvolvido pelos alunos do 6º Periodo do <a href="http://ifgoiano.edu.br/morrinhos/home/index.php?option=com_content&view=article&id=183:-tecnologia-em-sistemas-para-internet-&catid=8:cursos-superiores&Itemid=57"> 
                    Curso de Sistemas para Internet.</a></p>
        </div>

    </body>
</html>
