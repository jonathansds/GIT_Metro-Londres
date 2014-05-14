<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:p="http://primefaces.org/ui">


	<body>
		<form name="formulario" action="definir<c:url value='/trajeto/definir' />" method="post">
			<fieldset>
				<label for="estacao1"><fmt:message key='estacao.origem.nome' /></label>
				<select id="estacao1" name="estacaoOrigem">
				    <c:forEach items="${registrosModel.stations}" var="estacaoOrigem">
				    	<option value="${estacaoOrigem.identificador}">${estacaoOrigem.nome}</option>
				    </c:forEach>
				</select>
				<label for="linha1"><fmt:message key='linha.origem.numero' /></label>
				<select id="linha1" name="linhaOrigem">
				    <c:forEach items="${registrosModel.numeroLinhas}" var="linhaOrigem">
				    	<option  value="${linhaOrigem}">${linhaOrigem}</option>
				    </c:forEach>
				</select>
				<label for="estacao2"><fmt:message key='estacao.destino.nome' /></label>
				<select id="estacao2" name="estacaoDestino">
				    <c:forEach items="${registrosModel.stations}" var="estacaoDestino">
				    	<option  value="${estacaoDestino.identificador}">${estacaoDestino.nome}</option>
				    </c:forEach>
				</select>
			    <button type="submit" onclick="visualizar()" ><fmt:message key='botao.visualizar' /></button>
			    <button type="submit" onclick="retornarXML()"><fmt:message key='botao.xml' /></button>
			</fieldset>
		</form>
		
		<script language="javascript">
			function visualizar() {
 				document.formulario.action = "/Metro-Londres/trajeto/visualizar";
			}
			
			function retornarXML() {
 				document.formulario.action = "/Metro-Londres/trajeto/retornarXML";
			}
		</script>
	</body>
</html>