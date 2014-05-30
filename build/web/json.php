<?php


ini_set('default_charset','UTF-8');


$array = array("nome" => $_POST['nome'], "preco" => $_POST['preco'], "dataInclusao" => $_POST['dataInclusao'], "idCategoria" => $_POST['idCategoria']);

// Atenção: A string nome deve receber o tratamento na API cliente;



$safe = array_map('htmlentities', $array);

//$safe= strtr($safe, "áàãâéêíóôõúüçÁÀÃÂÉÊÍÓÔÕÚÜÇ", "aaaaeeiooouucAAAAEEIOOOUUC");
//echo json_encode($safe);
//$data = array("name" => "Hagrid", "age" => "36");
$data_string = json_encode($safe);

$ch = curl_init('http://localhost/SlimProdutos/index.php/produtos');
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
//curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json',
    'Content-Length: ' . strlen($data_string))
);

$result = curl_exec($ch);
//}
?>