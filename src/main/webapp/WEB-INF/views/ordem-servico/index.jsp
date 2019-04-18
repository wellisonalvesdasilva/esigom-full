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
						<h4 class="card-title">Consultar Ordens de Serviços</h4>
					</div>
					<div class="card-body">
						<form>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Código</label> <input id="id" maxlength="10000"
											name="id" type="text" class="form-control filtro"
											placeholder="Código">
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<label>Descrição</label> <input type="text" maxlength="40"
											minlength="1" id="descricao" name="descricao"
											class="form-control filtro" placeholder="Descrição">
									</div>
								</div>
								<div class="col-md-5 text-right">
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
										<th onclick="ordenarColuna('valor')" class="text-center">DATA
											CADASTRO</th>
										<th onclick="ordenarColuna('descricao')" class="text-center">
											CLIENTE</th>
										<th onclick="ordenarColuna('valor')" class="text-center">
											ORÇAMENTO</th>
										<th onclick="ordenarColuna('valor')" class="text-center">DATA
											ENTREGA</th>
										<th class="text-center">AÇÕES</th>
									</tr>
								</thead>
							</table>
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

	// Carregar DataTables
	carregarDataTables();
});


var codServico = 0;
function excluir(cod) {
	$('#myModal').modal();
	codServico = cod;
}

// Evento Excluir Funcionário
$('#btnConfirmar').click(function() {
	$('#btnConfirmar').attr('disabled', 'disabled');
	$('#btnCancelar').attr('disabled', 'disabled');
	$.ajax({
		url : 'ordem-servicos/excluir/' + codServico,
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

// Preparar Datatable
function dataTable() {
	return $('#example').DataTable({
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
	dto.id = $('#id').val();
	dto.descricao = $('#descricao').val();
	dto.valor = $('#valor').val();
	carregarDataTables();
}

// Construção das linhas da grid
function carregarDataTables(pagina, colunaParaOrdenar) {
	$('#example').append(
			'<tbody id="carregando">'
						+'<tr class="odd">'
							+'<td valign="top" colspan="7"'
							+'class="dataTables_empty text-center">Carregando...</td>'
						+'</tr>'
			+'</tbody>'
	)								
	
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
				url : '/e-SIGOM/home/ordem-servicos/pagination/' + pagina,
				type : 'POST',
				data : JSON.stringify(dto),
				dataType : "json",
				contentType : "application/json; charset=utf-8"
			})
			.done(
					function(valor) {
						console.log(valor);
						$( "#carregando" ).remove();
						var t = dataTable();
						t.clear();
						if (valor.lista.length > 0) {
							valor.lista.forEach(function(valor) {
									// Carregando o datatables
										t.row
												.add(
														[
																'<div class="text-center">'
																		+valor.id
																		+ '</div>',
																		
																'<div class="text-center">'
																		+ dataAtualFormatada(valor.dataGeracao)
																		+ '</div>',
																		
																'<div class="text-center">'
																		+  valor.orcamento.cliente.nome
																		+ '</div>',
																		
												/* 				'<div class="text-center">Nº. '
																	+ valor.orcamento.id
																	+ '</div>', */

																	
																	'<div class="text-center">'
																	+'<span class="label ellipsis_150 ng-isolate-scope ng-binding label-default"'
																	+'style="display: block; margin: 0; padding: 11.5px;">Aguardando Execução</span>'
																+'</div>',
																
																	'<div class="text-center">'
																	+ dataAtualFormatada(valor.dataEntrega)
																	+ '</div>',
														
													
																'<div class="text-center">'
																	
																		// Configurar Ordem de Serviço
																		+ '<a rel="tooltip" href="/e-SIGOM/home/ordem-servicos/'
																		+valor.id
																		+ '"data-original-title="Editar" name="btnSubmit" id="btnSubmit"'
																		+ 'type="button" class="btn btn-warning btn-fill"> <i class="nc-icon nc-refresh-02"></i>'
																		+ '</a> '
																																				
																		// Imprimir
																		+ '<a rel="tooltip" href="#'
																		+valor.id
																		+ '"data-original-title="Editar" name="btnSubmit" id="btnSubmit"'
																		+ 'type="button" class="btn btn-info btn-fill"> <i class="nc-icon nc-zoom-split"></i>'
																		+ '</a> '
																		
																		// Excluir
																		+ '<button rel="tooltip" name="btnSubmit"'
																		+ 'data-original-title="Excluir" id="btnSubmit"'
																		+ 'onclick="excluir('
																		+ valor.id
																		+ ')" type="button"'
																		+ 'class="btn btn-danger btn-fill">'
																		+ '<i class="nc-icon nc-simple-remove"></i>'
																		+ '</button> '
																		+ '</div>'
																		
																		])
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


function dataAtualFormatada(miliseconds){
    var data = new Date(miliseconds);
    var dia = data.getDate();
    if (dia.toString().length == 1)
      dia = "0"+dia;
    var mes = data.getMonth()+1;
    if (mes.toString().length == 1)
      mes = "0"+mes;
    
    var hora = data.getHours();
    if (hora.toString().length == 1)
    	hora = "0"+hora;
    
    var minutos = data.getMinutes();
    if (minutos.toString().length == 1)
    	minutos = "0"+minutos;
    
    var segundos = data.getSeconds();
    if (segundos.toString().length == 1)
    	segundos = "0"+segundos;
    
    
    var ano = data.getFullYear();  
    return dia+"/"+mes+"/"+ano+" "+hora+":"+minutos+":"+segundos;   
}


</script>
</body>
</html>