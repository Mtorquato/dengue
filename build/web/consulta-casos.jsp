<%-- 
    Document   : consulta-resolvidos
    Created on : 06/12/2013, 22:49:13
    Author     : bubulindao
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="minhasTags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript"></script>
        <title></title>
    </head>
    <body>

        <jsp:useBean id="dao" class="br.dengue.dao.DadosDAO"/>

        <table id="tabela" align="center" border="1">
            <tr>
                <td colspan="3" align="center" style="font-size: 25pt;">Dados de Casos</td>
            </tr>
            <tr align="center">

                <td>Tipo de Caso</td>
                <td>Status</td>

            </tr>

            <c:forEach var="dados" items="${dao.lista}">

                <tr>
                    <c:choose>
                        <c:when test="${dados.resolvido != 0}">
                            <td>${dados.dados}</td>
                            <td>Resolvido!</td>
                        </c:when>

                        <c:otherwise><td>${dados.dados}</td>
                            <td> Não Resolvido!</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>

        </table><br>

    </body>
</html>

