<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="cache-control" content="public" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=yes">

<jsp:include page="../template/cabecalho.jsp" />

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card strpied-tabled-with-hover">
					<div class="card-header ">
						<h4 class="card-title">Gerenciamento de Clientes</h4>
					</div>
					<div class="card-body">
						<form>
							<div class="row">
								<div class="col-md-2 pr-1">
									<div class="form-group">
										<label>Código</label> <input id="id" maxlength="5"
											minlength="1" value='${(fn:escapeXml(param.id))}' name="id"
											type="text" class="form-control filtro" placeholder="Código">
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<label>Nome</label> <input type="text" maxlength="40"
											minlength="1" value='${(fn:escapeXml(param.nome))}' id="nome"
											name="nome" class="form-control filtro" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<label>Email</label> <input id="email" maxlength="35"
											minlength="1" value='${(fn:escapeXml(param.email))}'
											name="email" type="text" class="form-control filtro"
											placeholder="E-mail">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-5"></div>
								<div class="col-md-7 text-right">
									<button name="btnSubmit" id="btnSubmit" onclick="pesquisar()"
										type="button" rel="tooltip" data-original-title="Pesquisar"
										class="btn btn-primary btn-fill">
										<i class="nc-icon nc-zoom-split"></i> Pesquisar
									</button>
									<button id="reset" name="reset" rel="tooltip"
										data-original-title="Limpar Campos" id="btnLimpar"
										type="button" class="btn btn-default btn-fill">
										<i class="fa fa-eraser"></i> Limpar
									</button>
									<button name="exportToPdf" id="exportToPdf" type="button"
										rel="tooltip" data-original-title="Exportar para PDF"
										class="btn btn-danger btn-fill">
										<i class="fa fa-file-pdf-o" aria-hidden="true"></i> Exportar
										para PDF
									</button>

									<a name="btnSubmit" rel="tooltip"
										data-original-title="Cadastrar Novo Usuário" id="btnSubmit"
										href='/e-SIGOM/home/cliente/cadastrar' type="submit"
										class="btn btn-success btn-fill"> <i
										class="nc-icon nc-single-02"></i> Novo Cliente
									</a>
								</div>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>
					<div class="row">
						<div class="col-md-12">
							<table id="example" class="mdl-data-table" style="width: 100%">
								<thead>
									<tr>
										<th class="text-center" onclick="ordenarColuna('id')">ID</th>
										<th onclick="ordenarColuna('nome')" class="text-center">NOME</th>
										<th onclick="ordenarColuna('email')" class="text-center">EMAIL</th>
										<th class="text-center">Ações</th>
									</tr>
								</thead>
							</table>
						</div>
						<form:form id="myModal" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Atenção</h4>
									</div>
									<div class="modal-body">
										<p>Deseja realmente excluir este funcionário?</p>
									</div>
									<div class="modal-footer">
										<button type="button" name="btnCancelar" id="btnCancelar"
											class="btn btn-default" data-dismiss="modal">Cancelar</button>
										<button name="btnConfirmar" id="btnConfirmar" type="button"
											class="btn btn-primary">Confirmar</button>
									</div>
								</div>
							</div>
							<input type="hidden" id="codAvisoExclusao"
								name="codAvisoExclusao" />
						</form:form>
						<form:form id="modalResetaSenha" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Resetar Senha</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-md-12 pl-1">
												<div class="form-group">
													<label>Nova Senha</label> <input type="text" required
														id="novaSenha" name="novaSenha" maxlength="8"
														minlength="6" class="form-control"
														placeholder="Senha reset padrão: 12345678">



												</div>
											</div>
											<p class="help-block">
												<i class="nc-icon nc-bulb-63"></i> &nbsp; A senha deverá
												conter no mínimo 6 caracteres e no máximo 8.
											</p>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" name="btnCancelar"
											id="btnCancelarResetSenha" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button name="btnConfirmarResetSenha"
											id="btnConfirmarResetSenha" type="button"
											class="btn btn-primary">Confirmar</button>
									</div>
								</div>
							</div>
							<input type="hidden" id="codAvisoExclusao"
								name="codAvisoExclusao" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../template/rodape.jsp" />
</body>
<jsp:include page="../template/scripts-rodape.jsp" />
<script>
	$(document).ready(function() {

		//	var valor = JSON.stringify(${(fn:escapeXml(param.ativo))});
		//	valor ? document.getElementById("ativo").value = valor : document.getElementById("ativo").value = '';
	})

	// Abrir Modal "Excluir Funcionário"
	var codFuncionario = 0;
	function excluirFuncionario(cod) {
		$('#myModal').modal();
		codFuncionario = cod;
	}

	// Abrir Modal "Alterar Senha"
	var codFuncionarioAlterarSenha = 0;
	function resetarSenha(cod) {
		$('#modalResetaSenha').modal();
		codFuncionarioAlterarSenha = cod;
	}

	function showNotification(from, align, msg) {
		color = Math.floor((Math.random() * 5));

		$.notify({
			icon : "nc-icon nc-tap-01",
			message : msg

		}, {
			type : type[color],
			timer : 2500,
			placement : {
				from : from,
				align : align
			}
		});
	}

	var sucessoMessage = "${message}";
	if (sucessoMessage != "") {
		showNotification('top', 'right', sucessoMessage);
	}

	
	//Limpar
	$("#reset").click(function() {
		$(":text").each(function() {
			$(this).val("");
		});
		$("select").each(function() {
			$(this).val("0");
		});
	});
	
	
	// Enter
	$(document).keypress(function(e) {
	    if(e.which == 13) $('#btnSubmit').click();
	});
	
	// Evento Alterar Senha
	$('#btnConfirmarResetSenha').click(function() {
		$('#btnConfirmarResetSenha').attr('disabled', 'disabled');
		$('#btnCancelarResetSenha').attr('disabled', 'disabled');
		var novaSenha = "0";
		if ($('#novaSenha').val()) {
			novaSenha = $('#novaSenha').val();
		}
		$.ajax({
			url : 'cliente/alterarSenha/' + codFuncionarioAlterarSenha,
			type : 'POST',
			contentType : "application/json",
			data : novaSenha
		}).done(function(data) {
			showNotification('top', 'right', 'Senha alterada com sucesso!');
			$('#btnConfirmarResetSenha').attr('disabled', false);
			$('#btnCancelarResetSenha').attr('disabled', false);
			$('#modalResetaSenha').modal('hide');
		}).fail(function(data) {
			showNotification('top', 'right', 'Erro inesperado.');
		});
	});

	// Evento Excluir Funcionário
	$('#btnConfirmar').click(function() {
		$('#btnConfirmar').attr('disabled', 'disabled');
		$('#btnCancelar').attr('disabled', 'disabled');
		$.ajax({
			url : 'excluir/' + codFuncionario,
			type : 'POST',
			contentType : "application/json"
		}).done(function(data) {
			$('#myModal').modal('hide');
			showNotification('top', 'right', 'Registro excluído com sucesso!');
			$('#btnConfirmar').removeAttr("disabled");
			$('#btnCancelar').removeAttr("disabled");
			carregarDataTables(pagineAtual,colunaParaOrdenarAsc);
		
		}).fail(function(data) {
			$('.loader').hide();
			showNotification('top', 'right', 'Erro ao excluir o registro!');
			$('#myModal').modal('hide');
			$('#btnConfirmar').removeAttr("disabled");
			$('#btnCancelar').removeAttr("disabled");
		});
	});

	// Evento Exportar para PDF
	$('#exportToPdf')
			.click(
					function() {
						
						
						
						
						$('#exportToPdf').attr("disabled",
								"disabled");
						$
								.ajax({
									url : 'export',
									type : 'POST'

								})
								.done(
										function(data) {
											showNotification('top', 'right',
													"PDF Exportado com sucesso! Verifique a pasta C://!");
										});
						
						$('#exportToPdf').removeAttr("disabled");
					});

	
	// Preparar Datatable
	function dataTable() {

		return $('#example').DataTable({
			
			retrieve: true,
			 
			columnDefs : [ {
				"width" : "15%",
				"targets" : 0,
				className : 'dt-body-center'
			}, {
				"width" : "30%",
				"targets" : 1,
				className : 'mdl-data-table__cell--non-numeric'

			}, {
				"width" : "30%",
				"targets" : 2,
				className : 'mdl-data-table__cell--non-numeric'
			}, {
				"width" : "25%",
				"targets" : 3,
				className : 'mdl-data-table__cell--non-numeric'
			

			}, ],
		});
	};

	// Ordenar
	var pagineAtual = "";
	var colunaParaOrdenarAsc = "";
	var colunaParaOrdenarDesc = "";
	function ordenarColuna(coluna) {

		if (colunaParaOrdenarAsc != coluna) {
			colunaParaOrdenarAsc = coluna;
		} else {
			colunaParaOrdenarAsc = colunaParaOrdenarDesc;
		}
		carregarDataTables(pagineAtual, colunaParaOrdenarAsc);
	}

	// Pesquisar
	var dto = new Object();
	function pesquisar() {
		dto.cod = $('#id').val();
		dto.nome = $('#nome').val();
		dto.email = $('#email').val();
		carregarDataTables();
	}

	// Construção das linhas da grid
	function carregarDataTables(pagina, colunaParaOrdenar) {
		// Definindo tamanho esperado pelo Front
		var offset = 10;

		if (!colunaParaOrdenar) {
			colunaParaOrdenar = colunaParaOrdenarAsc;
		}

		if (!pagina) {
			pagina = 0;
		}

		dto.colunaParaOrdenar = colunaParaOrdenar;

		// Chamadando Ajax
		$
				.ajax({
					url : '/e-SIGOM/home/cliente/listar/' + pagina,
					type : 'POST',
					data : JSON.stringify(dto),
					dataType : "json",
					contentType : "application/json; charset=utf-8"
				})
				
				.done(
						function(data) {
							var t = dataTable();
							t.clear();
						if (data.lista.length > 0) {
								data.lista.forEach(function(valor) {
									//Carregando o datatables
									t.row.add(
											[
													'<div class="text-center">'
															+ valor.id
															+ '</div>',
													'<div class="text-left">'
															+ valor.nome
															+ '</div>',
													
													'<div class="text-left">'
															+ valor.email
															+ '</div>',
													'<div class="text-center">'
														+'<a rel="tooltip" data-original-title="Editar" name="btnSubmit" id="btnSubmit"'
														+'type="button" class="btn btn-default btn-fill"> <i class="nc-icon nc-settings-tool-66"></i>'
														+'</a> '
								/* 				 +'<button rel="tooltip" name="btnSubmit"'
													+'data-original-title="Trocar Senha"'
													+'onclick="resetarSenha(${it.id})" type="button"'
													+'class="btn btn-default btn-fill">'
													+'<i class="nc-icon nc-refresh-02"></i>'
												+'</button> ' */
												+'<button rel="tooltip" name="btnSubmit"'
													+'data-original-title="Excluir" id="btnSubmit"'
													+'onclick="excluirFuncionario('
													+ valor.id
													+')" type="button"'
													+'class="btn btn-danger btn-fill">'
													+'<i class="nc-icon nc-simple-remove"></i>'
												+'</button> '
												+'</div>' ]).draw(
											false);
								});

								// Parametrizações iniciais baseada no retorno do back-end
								var textoMostrando = "";
								var inicioContador = 0;
								var currentPage = pagina + 1;
								var numeroPaginas = data.numeroPaginas;

								if (pagina == 0) {
									inicioContador = 1 + pagina;
								}

								if (pagina == 1) {
									inicioContador = offset + pagina;
								}

								if (pagina > 1) {
									inicioContador = pagina + "1";
								}

								// Formatando quantidade de registros
								var fimContador = pagina * offset;
								var fimContadorFormatado = fimContador
										+ data.qtdRegistroPagina;
								textoMostrando = "Página " + currentPage
										+ " de " + numeroPaginas
										+ " - Mostrando " + inicioContador * 1
										+ " de " + fimContadorFormatado
										+ " de " + data.qtdTotalDeRegistros
										+ "."
								$('#example_info').html("");
								$('#example_info').html(textoMostrando);

								// Montando Paginação chumbando a página 1, opção [Próxima e Última]
								var ultimaPagina = data.numeroPaginas - 1;
								$('#example_paginate').html("");
								$('#example_paginate')
										.append(
												'<div class="pagination"><button id="anterior" class="mdl-button previous" aria-controls="example" disabled="disabled">Anterior</button><button id="0" onclick="carregarDataTables(0)"  class="mdl-button  mdl-button--raised mdl-button--colored" aria-controls="example">1</button><div id="menosPagina"></div><div id="botoes"></div><div id="botoes2"></div><div id="maisPagina"></div><div id="botoesAdicionais"></div><div><button id="proximo" class="mdl-button next" aria-controls="example" disabled="disabled">Próxima</button></div><button class="mdl-button" disabled="disabled" id="ultimaPagina" onclick="carregarDataTables('
														+ ultimaPagina
														+ ')" type="button">Última</button></div>');
					
								// Percorrendo o numero retornado pelo back para criação das próximas páginas dinamicamente
								var i = 1;
								while (i <= data.numeroPaginas) {
									var paginaAtual = i + 1;
									var proximaPagina = pagina + 1;
									var paginaAnterior = pagina - 1;

									// Páginas que serão atualizadas utilizando de uma mesma posição - da 3 em diante
									if (i > 1 && i < data.numeroPaginas) {
										if (pagina >= 2
												&& i + 1 == proximaPagina) {
											
											$('#botoesAdicionais')
													.append(
															'</button><button class="mdl-button paginaNaoInicial" type="button" id="'
																	+ i
																	+ '" onclick="carregarDataTables('
																	+ i
																	+ ')" aria-controls="example">'
																	+ paginaAtual
																	);
										}
									}

									// Atualizando o parâmetro da opção Próxima
									if (pagina < data.numeroPaginas - 1) {
										var ajaxProximo = 'carregarDataTables('
												+ proximaPagina + ')';
										$('#proximo').removeAttr("disabled");
										$('#proximo').attr("onclick",
												ajaxProximo);
									}

									// Atualizando o parâmetro da opção Anterior
									if (pagina >= 1) {
										var ajaxAnterior = 'carregarDataTables('
												+ paginaAnterior + ')';
										$('#anterior').removeAttr("disabled");
										$('#anterior').attr("onclick",
												ajaxAnterior);
									}

									// Inserindo página 2
									if (i < 2 && data.qtdTotalDeRegistros > offset) {
										$('#botoes')
												.append(
														'<button class="mdl-button paginaNaoInicial" type="button" id="'
																+ i
																+ '" onclick="carregarDataTables('
																+ i
																+ ')" aria-controls="example">'
																+ paginaAtual
																+ '</button>');
									}

									// Inserindo/Atualizando cor da página selecionada
									if (pagina == i) {
										var idPaginaAtual = '#' + i;
										$('#0')
												.removeClass(
														"mdl-button--raised mdl-button--colored");
										$(idPaginaAtual)
												.addClass(
														"mdl-button--raised mdl-button--colored");
									}

									if (pagina == 0) {
										$('.paginaNaoInicial')
												.removeClass(
														"mdl-button--raised mdl-button--colored");
										$('#0')
												.addClass(
														"mdl-button--raised mdl-button--colored");
									}

									// Desabilitando a opção [Última], quando assim é o caso
									if (pagina != ultimaPagina) {
										$('#ultimaPagina').removeAttr(
												"disabled");
									}

									// Incrementando
									i++;
								}

								// Utilizado na paginação
								pagineAtual = pagina;

								// Caso nenhum registro tenha sido encontrado
								
							} else {
								// Caso Nenhum Registro Encontrado
								t.destroy();
								dataTable();
							}
						});
	}

	// Chamada da função executável
	carregarDataTables();
</script>
</body>
</html>