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
						<h4 class="card-title">Ordem de Serviços</h4>
					</div>
					<div class="card-body">
						<form>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Código</label> <input id="cod" maxlength="10000"
											name="cod" type="text" class="form-control filtro"
											placeholder="Código">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Nome</label> <input type="text" maxlength="40"
											minlength="1" id="nome" name="nome"
											class="form-control filtro" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>CPF</label> <input id="cpf" maxlength="14" name="cpf"
											type="text" class="form-control filtro" placeholder="CPF">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>RG</label> <input type="text" maxlength="7" id="rg"
											name="rg" class="form-control filtro" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Email</label> <input id="email" maxlength="40"
											name="email" type="text" class="form-control filtro"
											placeholder="E-mail">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>CNPJ</label> <input id="tipoPessoa" maxlength="30"
											name="cnpj" type="text" class="form-control filtro"
											placeholder="CNPJ">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Tipo Pessoa</label> <select name="tp_pessoa" required
											id="tp_pessoa" class="form-control">
											<option value="">Selecione</option>
											<option value="1">Física</option>
											<!-- 											<option value="2">Jurídica</option> -->
										</select>
									</div>
								</div>
								<div class="col-md-7 text-right">
									<button name="btnSubmit" id="btnSubmit" onclick="pesquisar()"
										type="button" rel="tooltip" data-original-title="Pesquisar"
										class="btn btn-primary btn-fill btn-pesquisa">
										<i class="nc-icon nc-zoom-split"></i> Pesquisar
									</button>
									<button id="reset" name="reset" rel="tooltip"
										data-original-title="Limpar Campos" id="btnLimpar"
										type="button" class="btn btn-default btn-fill btn-pesquisa">
										<i class="nc-icon nc-refresh-02"></i> Limpar
									</button>
									<!-- <button name="exportToPdf" id="exportToPdf" type="button"
										rel="tooltip" data-original-title="Exportar para PDF"
										class="btn btn-danger btn-fill btn-pesquisa">
										<i class="nc-icon nc-cloud-download-93" aria-hidden="true"></i>
										Exportar para PDF
									</button> -->
									<a name="btnSubmit" rel="tooltip"
										data-original-title="Cadastrar Novo Usuário" id="btnSubmit"
										href='/e-SIGOM/home/clientes/cadastrar' type="submit"
										class="btn btn-success btn-fill btn-pesquisa"> <i
										class="nc-icon nc-simple-add"></i> Novo Cadastro
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
										<th onclick="ordenarColuna('tp_pessoa')" class="text-center">TIPO
											PESSOA</th>
										<th onclick="ordenarColuna('celular')" class="text-center">
											CELULAR</th>
										<th onclick="ordenarColuna('telefone')" class="text-center">TELEFONE</th>
										<th class="text-center">AÇÕES</th>
									</tr>
								</thead>
							</table>
						</div>
						<form:form id="myModal" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Atenção</h4>
									</div>
									<div class="modal-body">
										<p>Deseja realmente excluir este Cliente?</p>
									</div>
									<div class="modal-footer">
										<button type="button" name="btnCancelar" id="btnCancelar"
											class="btn btn-default" data-dismiss="modal">Cancelar</button>
										<button name="btnConfirmar" id="btnConfirmar" type="button"
											class="btn btn-primary">Confirmar</button>
									</div>
								</div>
							</div>
						</form:form>
						<form:form id="detalhesCliente" class="modal fade" role="dialog">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Detalhes Cliente</h4>
									</div>
									<div class="modal-body" id="modal-body"></div>
									<div class="modal-footer">
										<div class="col-md-9"></div>
										<div class="col-md-3 text-right">
											<button type="button" class="btn btn-default btn-fill"
												data-dismiss="modal">
												<i class="nc-icon nc-simple-remove"></i>&nbsp;Fechar
											</button>

										</div>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<jsp:include page="../template/rodape.jsp" />
</body>
<script>




$(document).ready(function() {
	var $seuCampoCpf = $("#cpf");
	$seuCampoCpf.mask('000.000.000-00', {
		reverse : true
	});
});

// Abrir Modal "Excluir Funcionário"
var codCliente = 0;
function excluirFuncionario(cod) {
	$('#myModal').modal();
	codCliente = cod;
}

/* // Iniciar a lista sempre vazia
function visualizarDetalhesDoCliente(cod)
	{
	$.ajax({
		url:'clientes/detail/'+cod,
		type:'GET',
		data: cod
	}).done(function(retorno){
			$('#modal-body').append(
						'<div class="row">'
						+'<label class="col-sm-4 control-label"><strong>'
							+retorno.nome+'</strong>'
						+'</label>'
						+'<div class="col-lg-8">'
							+'<div>'+retorno.nome+'</div>'
						+'</div>'
						+'</div>'
				
						+'<div class="row">'
						+'<label class="col-sm-4 control-label"><strong>'
							+retorno.nome+'</strong>'
						+'</label>'
						+'<div class="col-lg-8">'
							+'<div>'+retorno.nome+'</div>'
						+'</div>'
						+'</div>'
				
						+'<div class="row">'
						+'<label class="col-sm-4 control-label"><strong>'
							+retorno.nome+'</strong>'
						+'</label>'
						+'<div class="col-lg-8">'
							+'<div>'+retorno.nome+'</div>'
						+'</div>'
						+'</div>'

						
						+'<div class="row">'
						+'<label class="col-sm-4 control-label"><strong>'
							+retorno.nome+'</strong>'
						+'</label>'
						+'<div class="col-lg-8">'
							+'<div>'+retorno.nome+'</div>'
						+'</div>'
						+'</div>'

			
						+'<div class="row">'
						+'<label class="col-sm-4 control-label"><strong>'
							+retorno.nome+'</strong>'
						+'</label>'
						+'<div class="col-lg-8">'
							+'<div>'+retorno.nome+'</div>'
						+'</div>'
						+'</div>');
	

		// Abrir Modal
		$('#detalhesCliente').modal({
			backdrop : 'static',
			keyboard : false
		});
	});
} */



// Evento Excluir Funcionário
$('#btnConfirmar').click(function() {
	$('#btnConfirmar').attr('disabled', 'disabled');
	$('#btnCancelar').attr('disabled', 'disabled');
	$.ajax({
		url : 'clientes/excluir/' + codCliente,
		type : 'POST',
		contentType : "application/json"
	}).done(function(data) {
		$('#myModal').modal('hide');
		showNotification('top', 'right', 'Registro excluído com sucesso!');
		$('#btnConfirmar').removeAttr("disabled");
		$('#btnCancelar').removeAttr("disabled");
		carregarDataTables(pagineAtual, colunaParaOrdenarAsc);

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
					$('#exportToPdf').attr("disabled", "disabled");
					$
							.ajax({
								url : 'clientes/export',
								type : 'POST'

							})
							.done(
									function(data) {
										showNotification('top', 'right',
												"PDF Exportado com sucesso! Verifique a pasta C://!");
									});

					$('#exportToPdf').removeAttr("disabled");
				});


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


// Preparar Datatable
function dataTable() {
	return $('#example').DataTable({
		
		processing: true,
		retrieve : true,
		language : {
			"sEmptyTable" : "Nenhum registro encontrado",
			"sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
			"sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
			"sInfoFiltered" : "(Filtrados de _MAX_ registros)",
			"sInfoPostFix" : "",
			"sInfoThousands" : ".",
			"sLengthMenu" : "_MENU_ resultados por página",
			"sLoadingRecords" : "Carregando...",
			"sProcessing" : "Processando...",
			"sZeroRecords" : "Nenhum registro encontrado",
			"sSearch" : "Pesquisar por CPF: ",
			"oPaginate" : {
				"sNext" : "Próximo",
				"sPrevious" : "Anterior",
				"sFirst" : "Primeiro",
				"sLast" : "Último"
			},
			"oAria" : {
				"sSortAscending" : ": Ordenar colunas de forma ascendente",
				"sSortDescending" : ": Ordenar colunas de forma descendente"
			}
		},
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


// Pesquisar
var dto = new Object();
function pesquisar() {
	dto.cod = $('#cod').val();
	dto.nome = $('#nome').val();
	dto.cpf = $('#cpf').val();
	dto.rg = $('#rg').val();
	dto.email = $('#email').val();
	dto.cnpj = $('#cnpj').val();
	dto.tp_pessoa = $('#tp_pessoa').val();

	carregarDataTables();
}


// Construção das linhas da grid
function carregarDataTables(pagina, colunaParaOrdenar) {

	// Construir datatable


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
				url : '/e-SIGOM/home/clientes/pagination/' + pagina,
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
							data.lista
									.forEach(function(valor) {
										
										// Carregando o datatables
										t.row
												.add(
														[
																'<div class="text-center">'
																		+ valor.cod
																		+ '</div>',
																'<div class="text-left">'
																		+ valor.nome
																		+ '</div>',

																'<div class="text-left">'
																		+ valor.email
																		+ '</div>',

																'<div class="text-left">'
																		+ valor.tp_pessoa
																		+ '</div>',

																'<div class="text-left">'
																		+ valor.celular
																		+ '</div>',

																'<div class="text-left">'
																		+ valor.telefone
																		+ '</div>',

																'<div class="text-center">'
															/* 			+ '<button rel="tooltip" name="btnSubmit"'
																		+ 'data-original-title="Visualizar Detalhes"'
																		+ 'onclick="visualizarDetalhesDoCliente('+valor.cod+')" type="button"'
																		+ 'class="btn btn-info btn-fill">'
																		+ '<i class="nc-icon nc-zoom-split"></i>'
																		+ '</button>' */

																		+ '<a rel="tooltip" href="/e-SIGOM/home/clientes/'
																		+valor.cod
																		+ '"data-original-title="Editar" name="btnSubmit" id="btnSubmit"'
																		+ 'type="button" class="btn btn-default btn-fill"> <i class="nc-icon nc-settings-tool-66"></i>'
																		+ '</a> '

																		+ '<button rel="tooltip" name="btnSubmit"'
																		+ 'data-original-title="Excluir" id="btnSubmit"'
																		+ 'onclick="excluirFuncionario('
																		+ valor.cod
																		+ ')" type="button"'
																		+ 'class="btn btn-danger btn-fill">'
																		+ '<i class="nc-icon nc-simple-remove"></i>'
																		+ '</button> '
																		+ '</div>' ])
												.draw(false);
									});

							// Parametrizações iniciais baseada no retorno do
							// back-end
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
							textoMostrando = "Página " + currentPage + " de "
									+ numeroPaginas + " - Mostrando "
									+ inicioContador * 1 + " de "
									+ fimContadorFormatado + " de "
									+ data.qtdTotalDeRegistros + "."
							$('#example_info').html("");
							$('#example_info').html(textoMostrando);

							// Montando Paginação chumbando a página 1, opção
							// [Próxima e Última]
							var ultimaPagina = data.numeroPaginas - 1;
							$('#example_paginate').html("");
							$('#example_paginate')
									.append(
											'<div class="pagination"><button id="anterior" class="mdl-button previous" aria-controls="example" disabled="disabled">Anterior</button><button id="0" onclick="carregarDataTables(0)"  class="mdl-button  mdl-button--raised mdl-button--colored" aria-controls="example">1</button><div id="menosPagina"></div><div id="botoes"></div><div id="botoes2"></div><div id="maisPagina"></div><div id="botoesAdicionais"></div><div><button id="proximo" class="mdl-button next" aria-controls="example" disabled="disabled">Próxima</button></div><button class="mdl-button" disabled="disabled" id="ultimaPagina" onclick="carregarDataTables('
													+ ultimaPagina
													+ ')" type="button">Última</button></div>');

							// Percorrendo o numero retornado pelo back para
							// criação das próximas páginas dinamicamente
							var i = 1;
							while (i <= data.numeroPaginas) {
								var paginaAtual = i + 1;
								var proximaPagina = pagina + 1;
								var paginaAnterior = pagina - 1;

								// Páginas que serão atualizadas utilizando de
								// uma mesma posição - da 3 em diante
								if (i > 1 && i < data.numeroPaginas) {
									if (pagina >= 2 && i + 1 == proximaPagina) {

										$('#botoesAdicionais')
												.append(
														'</button><button class="mdl-button paginaNaoInicial" type="button" id="'
																+ i
																+ '" onclick="carregarDataTables('
																+ i
																+ ')" aria-controls="example">'
																+ paginaAtual);
									}
								}

								// Atualizando o parâmetro da opção Próxima
								if (pagina < data.numeroPaginas - 1) {
									var ajaxProximo = 'carregarDataTables('
											+ proximaPagina + ')';
									$('#proximo').removeAttr("disabled");
									$('#proximo').attr("onclick", ajaxProximo);
								}

								// Atualizando o parâmetro da opção Anterior
								if (pagina >= 1) {
									var ajaxAnterior = 'carregarDataTables('
											+ paginaAnterior + ')';
									$('#anterior').removeAttr("disabled");
									$('#anterior')
											.attr("onclick", ajaxAnterior);
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

								// Inserindo/Atualizando cor da página
								// selecionada
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

								// Desabilitando a opção [Última], quando assim
								// é o caso
								if (pagina != ultimaPagina) {
									$('#ultimaPagina').removeAttr("disabled");
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

carregarDataTables();

</script>
</body>
</html>