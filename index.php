<?php

//pegaPontos();



//<<<<<<<<<<<<<<<<<<   AGENCIA >>>>>>>>>>>>>>>>>>>>>>>>
//function pegaPontos() {
    //$request = \Slim\Slim::getInstance()->request();
    //$produto = json_decode($request->getBody());

    //$agencia = $request->getBody();
    //$sql = "INSERT INTO agencia (nome,cnpj,id) values (:nome,:cnpj,:id) ";

   
   // echo "{pontos:" . json_encode($pontos) . "}";
    
    
    // Cria o arquivo se ele não existir
// Escreve 'Michel Fernandes' ao final do arquivo

//$arquivo = fopen('json.txt','a+');
//if ($arquivo) {
//	// move o ponteiro para o inicio do arquivo
//	rewind($arquivo);
//	if (!fwrite($arquivo, json_encode($pontos))) die('Não foi possível atualizar o arquivo.');
//	echo 'Arquivo atualizado com sucesso';
//	fclose($arquivo);
//}
    
 //    Sobre escreve o arquivo partindo do começo
    
    //delete('json.txt');
     $stmt = getConn()->query("select d.id,latitude,longitude,dados,valor,icone from dados d join app_lista al on d.dados=al.id where resolvido=0");
    
    $pontos = $stmt->fetchAll(PDO::FETCH_OBJ);
// CÓDIGO ABAIXO CRIA UM ARQUIVO EM BRANCO
$arquivo = fopen('web/js/pontos.json','w+');
if ($arquivo == false){
    unlink('web/js/pontos.json');
}
    

    
    
$arquivo = fopen('web/js/pontos.json','r+');
if ($arquivo) {
	if (!fwrite($arquivo, str_replace("\/","/",json_encode($pontos)))) die('Não foi possível atualizar o arquivo.');
	echo "Obtendo pontos...";
	echo '<meta http-equiv="refresh" content="2; url=http://localhost:8080/Dengue/index.jsp">';
	fclose($arquivo);
}
    
    // $categorias = $stmt->fetchAll(PDO::FETCH_OBJ);
    //echo "{categorias:" . json_encode($categorias) . "}";
    // $sql = "SELECT * FROM categorias WHERE id=:id";
//    $stmt = $conn->prepare($sql);
//    $stmt->bindParam("id", $produto->id);
//    $stmt->bindParam("latitude", $produto->latitude);
//    $stmt->bindParam("longitude", $produto->longitude);
//    $stmt->bindParam("valor", $produto->valor);
//    $stmt->bindParam("icone", $icone);
//    $stmt->execute();
//
//    echo json_encode($produto);
//
//    // Cria o arquivo se ele não existir
//// Escreve 'Michel Fernandes' ao final do arquivo
//
//    $arquivo = fopen('meuarquivodengue.json', 'a+');
//    if ($arquivo) {
//        // move o ponteiro para o inicio do arquivo
//        rewind($arquivo);
//        if (!fwrite($arquivo, $produto))
//            die('Não foi possível atualizar o arquivo.');
//        echo 'Arquivo atualizado com sucesso';
//        fclose($arquivo);
//    }
//}


 //<form action ="http://localhost/dengo/wsdengo.php/dengue" method="GET">

function getConn() {
    //return new PDO('mysql:host=localhost;dbname=restal', 'root', 'root', array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8")
    return new PDO('mysql:host=localhost;dbname=dengue', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8")
    );
}