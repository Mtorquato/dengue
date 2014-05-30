<%-- 
    Document   : login
    Created on : 30/10/2013, 22:45:42
    Author     : Higor
--%>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
        <link href="css/bootstrap.css"  rel="stylesheet" type="text/css" title="style">
        <link href="css/signin.css"  rel="stylesheet" type="text/css" title="style" />
</head>
<body>

    <div id="center">
        <div class="container">
            <img src="img/mosquito.png" />
                <h2>Controle de Endemias</h2>
                <span class="alert-danger">Por Favor, digite o nome de usuário e senha corretamente!<br /></span>
                <form class="form-signin" role="form" method="post" action="validaLogin.do">
                    <h3 class="form-signin-heading">Painel Administrativo</h3>
                        <b>Usuário </b><input type="text" class="form-control"name="usuario" placeholder="Digite aqui seu usuário" required autofocus>
                        <b>Senha </b><input type="password" class="form-control" name="senha" placeholder="Digite aqui sua senha" required>
                        <br />
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                </form>
        </div>
    
    </div> 
    <div id="rodape">
        Um produto fornecido pelos alunos do <a href="http://www.ifgoiano.edu.br/morrinhos">Instituto Federal Goiano <i>campus</i> Morrinhos
    </div>
</body>
</html>