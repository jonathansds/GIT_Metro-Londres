<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:p="http://primefaces.org/ui">


	<body>
		<form action="<c:url value='/importar' />" method="post" enctype="multipart/form-data">
			<fieldset>
				<label for="nome"><fmt:message key='label.nome.tabela' /></label>			
				<input id="nome" type="text" name="tabela" />
			    <input id="arquivo" type="file" name="arquivo" size="50" />
			    <button type="submit" ><fmt:message key='botao.salvar' /></button>
			</fieldset>
		</form>
		<p>OBS.:</p><br />
		<p style="color: red"> 
			- As tabelas dispon�veis em nosso sistema s�o: Estacoes, Rotas e Linhas; <br />
			- O nome das colunas contidos no arquivo ser�o respeitados na base de dados; <br/>
			- O arquivo dever� estar no formato CSV;
			- A opera��o de persistencia dos dados ser� no padr�o "at�mica" onde, se houver uma linha incorreta no arquivo nenhum registro ser� persistido, por isso, atente-se ao arquivo enviado; <br/>
			- Caso a opera��o seja realizada com sucesso voc� ser� redirecionado � p�gina de listagem de dados.
		</p>
	</body>
</html>