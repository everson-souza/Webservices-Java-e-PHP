<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$SoapClient = new SoapClient("http://localhost:8080/ServidorWS/ServicoWS?wsdl");
//$functions = $SoapClient->__getFunctions ();
//var_dump ($functions);

if (isset($_POST["submitEmpresa"])){    
    
    unset($_POST["submitEmpresa"]);
    //Chama o método no servidor
    $params = array('codigo'=>$_POST["codigo"], 'nome'=>$_POST["nome"], 'contato'=>$_POST["contato"], 'area'=>$_POST["area"], 'cargaHoraria'=>$_POST["cargaHoraria"], 'salario'=>$_POST["salario"]);
    $result = $SoapClient->cadastraVaga($params);
    
    echo $result->return;   //Imprime o resultado da consulta
    
}
?>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Empresa</title>
  </head>
  <body>
        <div class="row" style="width: 100%; margin-top: 15px;">                                  
            <div class="col-md-4"></div>
            <div class="col-md-4">                
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                      <a class="nav-link active" href="Empresa.php">Cadastrar vagas</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="EmpresaConsulta.php">Consultar currículos</a>
                    </li>                    
                </ul>
                <br>
                <form action="Empresa.php" method="post">
                    <div class="form-group">                  
                        <input name="codigo" type="text" class="form-control" placeholder="Código da vaga">
                    </div>
                    <div class="form-group">                  
                        <input name="nome" type="text" class="form-control" placeholder="Nome">
                    </div>
                    <div class="form-group">                  
                        <input name="contato" type="text" class="form-control" placeholder="Contato">
                    </div>
                    <div class="form-group">                  
                        <input name="area" type="text" class="form-control" placeholder="Área">
                    </div>
                    <div class="form-group">                  
                        <input name="cargaHoraria" type="text" class="form-control" placeholder="Carga Horária Semanal">
                    </div>
                    <div class="form-group">                  
                        <input name="salario" type="text" class="form-control" placeholder="Salário">
                    </div>
                    
                    <button name="submitEmpresa" type="submit" class="btn btn-primary">Cadastro</button>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
