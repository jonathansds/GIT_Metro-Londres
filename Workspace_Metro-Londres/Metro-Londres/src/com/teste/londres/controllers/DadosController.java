package com.teste.londres.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.teste.londres.dao.EstacaoDao;
import com.teste.londres.dao.LinhaDao;
import com.teste.londres.dao.RotaDao;
import com.teste.londres.dao.impl.EstacaoDaoImpl;
import com.teste.londres.dao.impl.LinhaDaoImpl;
import com.teste.londres.dao.impl.RotaDaoImpl;
import com.teste.londres.entidades.Estacao;
import com.teste.londres.entidades.Linha;
import com.teste.londres.entidades.Rota;
import com.teste.londres.models.RegistrosModel;
import com.teste.londres.utils.Constantes;

/**
 * @author Jonathan
 * @version 11/05/2014
 *
 */
@Resource
public class DadosController{
	
	/** estacaoDao */
	private final EstacaoDao estacaoDao;
	
	/** rotaDao */
	private final RotaDao rotaDao;
	
	/** linhaDao */
	private final LinhaDao linhaDao;
	
	/** result */
	private final Result result;
	
	/** validator */
	private final Validator validator;
	
	/** estacoes */
	private List<Object> entidadesList;
	
	/**
	 * @param estacaoDao
	 * @param rotaDao
	 * @param linhaDao
	 * @param result
	 * @param validator
	 */
	public DadosController(EstacaoDaoImpl estacaoDao, RotaDaoImpl rotaDao, LinhaDaoImpl linhaDao, Result result, Validator validator){
		this.estacaoDao = estacaoDao;
		this.rotaDao = rotaDao;
		this.linhaDao = linhaDao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	@Path("/dados/arquivo")
	public void arquivo(){

	}
	
	@Post
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/importar")
	public void importar(final UploadedFile arquivo, final String tabela){
		if(tabela == null || (!tabela.trim().equalsIgnoreCase(Constantes.TABELA_ESTACOES) && 
			!tabela.trim().equalsIgnoreCase(Constantes.TABELA_LINHAS)  && 
			!tabela.trim().equalsIgnoreCase(Constantes.TABELA_ROTAS))){
			
			validator.add(new ValidationMessage("N�o existe uma tabela com o nome indicado!", "nome"));
		}
		
		if(arquivo == null || (!arquivo.getFileName().endsWith(".csv") && !arquivo.getFileName().endsWith(".CSV"))){
			validator.add(new ValidationMessage("Arquivo inv�lido!", "arquivo"));
		}
		
		validator.onErrorUsePageOf(this).arquivo();
		
		try{
			boolean sucesso = recuperaObjetosPersistentes(arquivo, tabela);
			
			if(sucesso){
				persisteListaEntidades();
			}else{
				validator.add(new ValidationMessage("Nenhum valor v�lido encontrado para ser persistido.", "arquivo"));
			}
			
			validator.onErrorUsePageOf(this).arquivo();
			
			result.redirectTo(this).arquivos();
		}catch(Exception erro){
			erro.printStackTrace();
			result.redirectTo(this).arquivo();
		}
	}
	
	@Get
	@Path("/dados/arquivos")
	public RegistrosModel arquivos(){
		RegistrosModel registros = new RegistrosModel();
		
		registros.setEstacoes(estacaoDao.listAll());
		registros.setLinhas(linhaDao.listAll());
		registros.setRotas(rotaDao.listAll());
		
		return registros;
	}
	
	@SuppressWarnings("rawtypes")
	private boolean recuperaObjetosPersistentes(UploadedFile arq, String tabela) throws IOException{
		String linha;
		String[] dados;
		String[] colunas;
		BufferedReader reader;
		try{
			reader = new BufferedReader(new InputStreamReader(arq.getFile()));
			
			linha = reader.readLine();
			
			if(linha != null && !linha.trim().equals("")){
				colunas = linha.split(";");
			}else{
				validator.add(new ValidationMessage("A primeira linha do arquivo deve conter o nome das colunas!", "arquivo"));
				return false;
			}
		}catch(Exception erro){
			validator.add(new ValidationMessage("Erro no acesso ao arquivo", "arquivo"));
			return false;
		}
		
		
		boolean populou = false;
		entidadesList = new ArrayList<Object>();
		Class params[] = new Class[colunas.length];
		String nomeSets[] = new String[colunas.length];
		Object entidade;
		String nomeMetodoSetEntidade = "";
		String nomeMetodoGetEntidade = "";
		
		if(tabela.equalsIgnoreCase(Constantes.TABELA_ESTACOES)){
			entidade = new Estacao();
		}else if(tabela.equalsIgnoreCase(Constantes.TABELA_LINHAS)){
			entidade = new Linha();
		}else{
			entidade = new Rota();
		}
			
		for(int i = 0; i < colunas.length; i++){
			try{
				Method[] metodosGeral = entidade.getClass().getDeclaredMethods();
				String atributo = colunas[i];
				nomeMetodoSetEntidade = "set" + atributo.substring(0,1).toUpperCase().concat(atributo.substring(1));
				nomeSets[i] = nomeMetodoSetEntidade;
				nomeMetodoGetEntidade = nomeMetodoSetEntidade.replaceFirst("set", "get");
				
				for(Method metodo : metodosGeral){
					if(metodo.getName().equals(nomeMetodoGetEntidade)){
						params[i] = metodo.getReturnType();
						break;
					}
				}
			}catch(Exception erro){
				continue;
			}
		}
			
		while((linha = reader.readLine())!= null){
			dados = linha.split(";");
			
			for(int i = 0; i < colunas.length; i++){
				try{
					Object valor = getInstancia(params[i], dados[i]);
					
					if(valor == null){
						continue;
					}
				
				
					Method metodoSet = entidade.getClass().getDeclaredMethod(nomeSets[i], params[i]);
					metodoSet.setAccessible(true);
					metodoSet.invoke(entidade, new Object[]{valor});
					populou = true;
				}catch(NumberFormatException err){
					validator.add(new ValidationMessage("O valor "+dados[i]+" na linha "+linha+" deve ser do tipo "+params[i].getName()+". O CAMPO FOI IGNORADO.", "arquivo"));
					continue;
				}catch(Exception erro){
					continue;
				}
			}
			entidadesList.add(entidade);
			
			if(tabela.equalsIgnoreCase(Constantes.TABELA_ESTACOES)){
				entidade = new Estacao();
			}else if(tabela.equalsIgnoreCase(Constantes.TABELA_LINHAS)){
				entidade = new Linha();
			}else{
				entidade = new Rota();
			}
		}
		
		return populou;
	}
	
	@SuppressWarnings("rawtypes")
	private Object getInstancia(Class classe, String valor){
		if(classe == null || valor.trim().equalsIgnoreCase("NULL")){
			return null;
		}
		
		String nome = classe.getName();
		
		if(nome.endsWith("Double")){
			return new Double(valor);
		}else if(nome.endsWith("String")){
			return new String(valor);
		}else if(nome.endsWith("Integer")){
			return new Integer(valor);
		}else if(nome.endsWith("Long")){
			return new Long(valor);
		}
		
		return null;
	}
	
	private boolean persisteListaEntidades(){
		if(entidadesList.get(0) instanceof Estacao){
			
			for(Object obj:entidadesList){
				estacaoDao.insert((Estacao)obj);
			}
			return true;
		}else if(entidadesList.get(0) instanceof Rota){
			
			for(Object obj:entidadesList){
				rotaDao.insert((Rota)obj);
			}
			return true;
		}else if(entidadesList.get(0) instanceof Linha){
			
			for(Object obj:entidadesList){
				linhaDao.insert((Linha)obj);
			}
			return true;
		}
		
		return false;
	}
}
