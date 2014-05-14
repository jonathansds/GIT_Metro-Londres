<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:p="http://primefaces.org/ui">


	<body>
		<label><fmt:message key='label.estacao.origem' /></label><label style="font-weight: bold;">${trajeto.estacaoOrigem.nome}</label>
		<label><fmt:message key='label.estacao.destino' /></label><label style="font-weight: bold;">${trajeto.estacaoDestino.nome}</label>
		
		<label><fmt:message key='label.menor.trajeto' /></label>
		<table>
		  <thead>
		    <tr>
		    	<th><fmt:message key='tabela.coluna.estacao' /></th>
		    	<th><fmt:message key='tabela.coluna.linha' /></th>
		    	<th><fmt:message key='label.tempo.gasto' /></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${trajeto.menorCaminho}" var="station">
				<tr>
					<td>${station.nome}</td>
					<td>${station.linhaEscolhida}</td>
					<td>${station.tempoDistancia} min</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
	</body>
</html>