<?php

//pegaPontos();



//<<<<<<<<<<<<<<<<<<   AGENCIA >>>>>>>>>>>>>>>>>>>>>>>>
//function pegaPontos() {
    //$request = \Slim\Slim::getInstance()->request();
    //$produto = json_decode($request->getBody());

    //$agencia = $request->getBody();
    //$sql = "INSERT INTO agencia (nome,cnpj,id) values (:nome,:cnpj,:id) ";
    
    echo "Entrou";

    $stmt = getConn()->query("SELECT * FROM DADOS D JOIN APP_LISTA AL ON D.DADOS =AL.ID WHERE RESOLVIDO=0");
    
    $pontos = $stmt->fetchAll(PDO::FETCH_OBJ);
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
    
// CÓDIGO ABAIXO CRIA UM ARQUIVO EM BRANCO
$arquivo = fopen('pontos.json','w+');
if ($arquivo == false){
    unlink('pontos.json');
}
    

    
    
$arquivo = fopen('pontos.json','r+');
if ($arquivo) {
	if (!fwrite($arquivo, str_replace("\/","/",json_encode($pontos)))) die('Não foi possível atualizar o arquivo.');
	echo 'Arquivo atualizado com sucesso';
	
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