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
						<h4 class="card-title">Cadastrar Orçamento</h4>
					</div>
					<div class="card-body">
						<form:form method="POST" modelAttribute="obj"
							cssClass='form-horizontal'>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Data</label> <input autocomplete="off"
											placeholder="DD/MM/AAAA" id="data" name="data" type="text"
											class="form-control dataMask" placeholder="Data">
									</div>
								</div>
								<!-- 				<div class="col-md-2">
									<div class="form-group">
										<label>Tipo de Pessoa</label> <select name="tp_pessoa"
											required id="tp_pessoa" class="form-control">
											<option value="1">Física</option>
											<option value="2">Jurídica</option>
										</select>
									</div>
								</div> -->
								<div class="col-md-2">
									<div class="form-group">
										<label>Veículo-Placa</label> <input type="text" maxlength='40'
											minlength='1' required id="nome" name="nome"
											class="form-control" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Marca</label> <input type="text" maxlength='40'
											minlength='1' required id="nome" name="nome"
											class="form-control" placeholder="Nome">
									</div>
								</div>



								<div class="col-md-2">
									<div class="form-group">
										<label>Modelo</label> <input type="text" maxlength='40'
											minlength='1' id="telefone" name="telefone"
											class="form-control" placeholder="Telefone">
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label>Cor</label> <input type="text" maxlength='40'
											minlength='1' id="telefone" name="telefone"
											class="form-control" placeholder="Telefone">
									</div>
								</div>


								<div class="col-md-2">
									<div class="form-group">
										<label>Ano</label> <input type="text" maxlength='40'
											minlength='1' id="telefone" name="telefone"
											class="form-control" placeholder="Telefone">
									</div>
								</div>


							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Odômetro (KM)</label> <input type="text" maxlength='40'
											minlength='1' required id="celular" name="celular"
											class="form-control" placeholder="Celular">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Proprietário (CPF)</label> <input type="text"
											maxlength='40' minlength='1' id="email" name="email"
											class="form-control" placeholder="E-mail">
									</div>
								</div>
								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>Nome</label> <input id="rg" maxlength='7' name="rg"
											type="text" class="form-control" placeholder="RG">
									</div>
								</div>
								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>Telefone</label> <input id="cpf" maxlength='35'
											minlength='20' name="cpf" type="text" class="form-control"
											placeholder="CPF">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Celular</label> <input type="text" maxlength='40'
											minlength='1' required id="cep" name="cep"
											class="form-control" placeholder="CEP">
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>Endereço</label> <input maxlength='20' minlength='1'
											type="text" id="estado" required name="estado"
											class="form-control" placeholder="UF">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Número</label> <input type="text" maxlength='40'
											minlength='1' required id="cidade" name="cidade"
											class="form-control" placeholder="Cidade">
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label>Bairro</label> <input type="text" maxlength='40'
											minlength='1' required id="bairro" name="bairro"
											class="form-control" placeholder="Bairro">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Cidade</label> <input type="text" maxlength='40'
											minlength='1' required id="rua" name="rua"
											class="form-control" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>UF</label> <input type="text" maxlength='40'
											minlength='1' required id="numero" name="numero"
											class="form-control" placeholder="Número">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Email</label> <input type="text" maxlength='40'
											minlength='1' required id="numero" name="numero"
											class="form-control" placeholder="Número">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<ul class="nav nav-tabs" id="myTab" role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="home-tab" data-toggle="tab" href="#home" role="tab"
											aria-controls="home" aria-selected="true">Peças</a></li>
										<li class="nav-item"><a class="nav-link" id="profile-tab"
											data-toggle="tab" href="#perfil" role="tab"
											aria-controls="profile" aria-selected="false">Serviços</a></li>
										<!-- 	<li class="nav-item"><a class="nav-link" id="contact-tab"
											data-toggle="tab" href="#contato" role="tab"
											aria-controls="contact" aria-selected="false">Anotações</a></li> -->
									</ul>
									<div class="tab-content" id="myTabContent">
										<div class="tab-pane fade show active" id="home"
											role="tabpanel" aria-labelledby="home-tab">
											<div class="row">

												<div class="col-md-10">
													<table class="table table-bordered table-striped">
														<thead>
															<tr>
																<th>Código</th>
																<th>Descrição</th>
																<th>Quantidade</th>
																<th>Valor Unitário</th>
																<th>Sub Total</th>
																<th>Ação</th>
															</tr>
														</thead>
														<tbody id="tabelaIndexPeca">
															<tr class="odd" id="nenhumEncontrado">
																<td valign="top" colspan="7"
																	class="dataTables_empty text-center">Nenhum item
																	foi adicionado até o momento.</td>
															</tr>
														</tbody>
													</table>
												</div>
												<div class="col-md-2 text-center">
													<button name="btnSubmit" rel="tooltip"
														data-original-title="Adicionar Nova Peça"
														onclick="adicionarNaTabela()" type="button"
														class="btn btn-default btn-fill btn-pesquisa">
														<i class="nc-icon nc-simple-add"></i> Adicionar
													</button>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="perfil" role="tabpanel"
											aria-labelledby="profile-tab">
											<div class="row">

												<div class="col-md-10">
													<table class="table table-bordered table-striped">
														<thead>
															<tr>
																<th>Código</th>
																<th>Descrição</th>
																<th>Quantidade</th>
																<th>Valor Unitário</th>
																<th>Sub Total</th>
															</tr>
														</thead>
														<tbody>
															<tr class="odd">
																<td valign="top" colspan="7"
																	class="dataTables_empty text-center">Nenhum item
																	foi adicionado até o momento.</td>
															</tr>
														</tbody>
													</table>
												</div>

												<div class="col-md-2 text-center">
													<a name="btnSubmit" rel="tooltip"
														data-original-title="Cadastrar Novo Usuário"
														id="btnSubmit" href="/e-SIGOM/home/clientes/cadastrar"
														type="submit"
														class="btn btn-default btn-fill btn-pesquisa"> <i
														class="nc-icon nc-simple-add"></i> Adicionar
													</a>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 text-right" id="totalGeralFormatado"></div>
							</div>
						</form:form>
						<div class="row">
							<div class="col-md-5">
								<a href='/e-SIGOM/home/clientes' type="button"
									class="btn btn-warning btn-fill"> <i
									class="nc-icon nc-stre-left"></i> Consulta
								</a>

								<button type="submit" type="button"
									class="btn btn-success btn-fill">
									<i class="nc-icon nc-send"></i> Salvar
								</button>

								<a href='/e-SIGOM/home/clientes/cadastrar'
									class="btn btn-info btn-fill"> <i
									class="nc-icon nc-refresh-02"></i> Limpar
								</a>
							</div>
							<div class="col-md-7"></div>
						</div>
					</div>
				</div>
				<form:form id="inserirPecas" class="modal fade" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Adicionar Peça ao Orçamento</h4>
								<button type="button" class="close" onclick="fecharModal()"
									data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-lg-12">
										<div id="error" class="alert alert-danger"
											style="display: none;">
											<span id="errorMessage"></span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-10">
										<div class="form-group">
											<input placeholder="Informe o nome da Peça"
												name="inputNomeDaPeca" id="inputNomeDaPeca"
												class="form-control">
										</div>
									</div>
									<div class="col-lg-2">
										<div class="form-group">
											<button name="btnEncontrarPeca" id="encontrarPeca"
												type="button" class="btn btn-primary btn-fill">
												<i class="nc-icon nc-zoom-split"></i>&nbsp; Buscar
											</button>
										</div>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-12">
										<table class="table table-bordered table-striped">
											<thead>
												<tr>
													<th class="text-center">Código</th>
													<th class="text-center">Descrição</th>
													<th class="text-center">Valor Unitário</th>
													<th class="text-center">Quantidade</th>
													<th class="text-center">Ação</th>
												</tr>
											</thead>
											<tbody id="tabelaPeca">
												<tr class="odd" id="nenhumEncontrado">
													<td valign="top" colspan="7"
														class="dataTables_empty text-center">Nenhum registro
														encontrado com os parâmetros informados.</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
				</form:form>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../template/rodape.jsp" />
</body>
<script>
// Remover, subtrair
	// Total Geral
	var totalGeral = 0;
	var totalGeralFormatado = "";
	
	if(!totalGeralFormatado){
		$('#totalGeralFormatado').html("Valor Total: R$00,00");
	}
	
	// Array com as Peças
	var listPecas = [];


	// Remover Item
	function removerItemGrid(id) {
 		var idTr = id;
		var parent = document.getElementById("tabelaIndexPeca");
		var child = document.getElementById(idTr);
		parent.removeChild(child);
		
		// Remover do Array
		var index = listPecas.map(x => {
			  return x.id;
			}).indexOf(id);

		listPecas.splice(index, 1);
		showNotification('top', 'right', 'A peça foi removida do orçamento!');

		
		if(listPecas.length == 0){
			$('#nenhumEncontrado')
			.append(
					'<td valign="top" colspan="7"'
		+'class="dataTables_empty text-center">Nenhum item foi adicionado até o momento.</td>'
							);
		}
	
	}

	function formataDinheiro(n) {
		return "R$ "
				+ n.toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+\,)/g,
						"$1.");
	}

	function fecharModal() {
		$('#inserirPecas').modal('hide');
		$('#tabelaPeca').html("");
		$('#inputNomeDaPeca').val("");
		$('#tabelaPeca')
				.append(
						'<tr class="odd">'
								+ '<td valign="top" colspan="7"'
			+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
								+ '</tr>');
	}

	function adicionarNaTabela() {
		$('#inserirPecas').modal({
			backdrop : 'static',
			keyboard : false
		});
	}

	function adicionarItemPeca(id, descricao, quantidade, valorUnitario) {

		var stringInput = "#inputQtdPecas" + id;
		var valorTotalQtde = $('' + stringInput + '').val();

		var valorUnitarioFormatado = parseInt(valorUnitario.replace("R$", ''));
		var subTotalFinalFormatado = formataDinheiro(valorTotalQtde
				* valorUnitarioFormatado);
		
		var subTotalInteger = parseInt(valorTotalQtde * valorUnitarioFormatado);
		
		// Fechar Modal
		$('#inserirPecas').modal('hide');

		// Limpar modal
		$('#tabelaPeca').html("");
		$('#inputNomeDaPeca').val("");

		$('#tabelaPeca')
				.append(
						'<tr class="odd">'
								+ '<td valign="top" colspan="7"'
					+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
								+ '</tr>');

		// Resetar Tabela
		$('#nenhumEncontrado').html("");

		// Adicionar Item Tabela
		$('#tabelaIndexPeca').append(
				'<tr id="'
				+id
				+'">'
				// ID
				+ '<td class="text-center">' + id + '</td>'

				// Descrição
				+ '<td>' + descricao + '</td>'

				// Quantidade
				+ '<td class="text-center">' + valorTotalQtde + '</td>'

				/* 			+ '<td class="text-center"><input type="text" maxlength="40" minlength="1" class="form-control" value="1" size="1" id="inputQtdPecas'
								+id
								+'"placeholder="Quantidade"></td>' */

				// Valor Unitário
				+ '<td class="text-center">' + valorUnitario + '</td>'

				// SubTotal
				+ '<td class="text-center">' + subTotalFinalFormatado + '</td>'

				// Ação
				+ '<td class="text-center">'
						+ '<button rel="tooltip" name="btnSubmit"'
						+ 'data-original-title="Excluir" id="btnSubmit"'
						+ 'onclick="removerItemGrid(' + id + ')" type="button"'
						+ 'class="btn btn-danger btn-fill">'
						+ '<i class="nc-icon nc-simple-remove"></i>'
						+ '</button>' + '</td>'

						+ '</tr>');

		// Msg de sucesso
		showNotification('top', 'right', 'A peça foi adicionada ao orçamento!');

		// Adicionar a lista
		var id = {
			id : id,
			quantidade : valorTotalQtde,
			subTotal: subTotalInteger,
		}
		listPecas.push(id);
		
		// Formatar Total Geral
		totalGeral = totalGeral + subTotalInteger;
		totalGeralFormatado = formataDinheiro(totalGeral);
		$('#totalGeralFormatado').html("Valor Total: "+totalGeralFormatado);
	}

	// Evento 2: Botão Adicionar Unidade Gestora
	$('#encontrarPeca')
			.click(

					function() {
						// Armazena em variável valor do Input
						var inputNomeDaPeca = $("#inputNomeDaPeca").val();

						// Caso não esteja preenchido, formata erro
						if (!inputNomeDaPeca) {
							$('#tabelaPeca').html("");

							$('#tabelaPeca')
									.append(
											'<tr class="odd">'
													+ '<td valign="top" colspan="7"'
					+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
													+ '</tr>');

							$('#errorMessage').html("");
							$('#errorMessage')
									.append(
											'Erro!'
													+ "&nbsp;"
													+ 'Campo Nome da Peça não informado.'
													+ "&nbsp;");

							$("#error").show();

							// Senão chama ajax
						} else {
							$('#errorMessage').html("");
							$("#error").hide();
							$
									.ajax(
											{
												url : 'getPesquisaPeca/'
														+ inputNomeDaPeca,
												type : 'GET',
												data : {
													nome : inputNomeDaPeca
												}
											})
									.done(
											function(response) {
												if (response) {
													if (response.length > 0) {
														$('#tabelaPeca').html(
																"");
														response
																.forEach(function(
																		valor) {

																	var quantidade = 1;

																	$(
																			'#tabelaPeca')
																			.append(
																					'<tr><td class="text-center">'
																							+ valor.id
																							+ '</td>'
																							+ '<td>'
																							+ valor.descricao
																							+ '</td>'
																							+ '<td class="text-center">'
																							+ valor.valorVenda
																							+ '</td>'

																							// Quantidade
																							+ '<td class="text-center"><input type="text" maxlength="40" minlength="1" class="form-control" value="1" size="1" id="inputQtdPecas'
																							+valor.id
																							+'"placeholder="Quantidade"></td>'

																							// Ação
																							+ '<td class="text-center">'
																							+ '<button rel="tooltip"'
																							+ 'data-original-title="Adicionar Peça"'
																							+ 'onclick="adicionarItemPeca('
																							+ valor.id
																							+ ','
																							+ "'"
																							+ valor.descricao
																							+ "'"
																							+ ','
																							+ quantidade
																							+ ','
																							+ "'"
																							+ valor.valorVenda
																							+ "'"
																							+ ')" type="button"'
																							+ 'class="btn btn-warning btn-fill">'
																							+ '<i class="nc-icon nc-simple-add"></i> Adicionar'
																							+ '</button>'
																							+ '</td></tr>');

																});
													} else {
														$('#tabelaPeca').html(
																"");
														$('#tabelaPeca')
																.append(
																		'<tr class="odd">'
																				+ '<td valign="top" colspan="7"'
														+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
																				+ '</tr>');
													}
												}
											});
						}
					});

	$(document).ready(
			function() {

				var mascara = $("#cpf");
				mascara.mask('000.000.000-00', {
					reverse : true
				});

				function limpa_formulário_cep() {
					// Limpa valores do formulário de cep.
					$("#rua").val("");
					$("#bairro").val("");
					$("#cidade").val("");
					$("#estado").val("");
				}

				//Quando o campo cep perde o foco.
				$("#cep").blur(
						function() {
							//Nova variável "cep" somente com dígitos.
							var cep = $(this).val().replace(/\D/g, '');

							//Verifica se campo cep possui valor informado.
							if (cep != "") {

								//Expressão regular para validar o CEP.
								var validacep = /^[0-9]{8}$/;

								//Valida o formato do CEP.
								if (validacep.test(cep)) {

									//Preenche os campos com "..." enquanto consulta webservice.
									$("#rua").val("...");
									$("#bairro").val("...");
									$("#cidade").val("...");
									$("#estado").val("...");

									//Consulta o webservice viacep.com.br/
									$.getJSON("https://viacep.com.br/ws/" + cep
											+ "/json/?callback=?", function(
											dados) {

										if (!("erro" in dados)) {
											//Atualiza os campos com os valores da consulta.
											$("#rua").val(dados.logradouro);
											$("#bairro").val(dados.bairro);
											$("#cidade").val(dados.localidade);
											$("#estado").val(dados.uf);
										} //end if.
										else {
											//CEP pesquisado não foi encontrado.
											limpa_formulário_cep();
											alert("CEP não encontrado.");
										}
									});
								} //end if.
								else {
									//cep é inválido.
									limpa_formulário_cep();
									alert("Formato de CEP inválido.");
								}
							} //end if.
							else {
								//cep sem valor, limpa formulário.
								limpa_formulário_cep();
							}
						});
			});

	//DatePicker
	$('#dt_nascimento').mask('00/00/0000');

	$(function() {
		$('#dt_nascimento').datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior',
					onClose : function(dateText, inst) {
						if (!validaDat(dateText)) {
							$('#btnSubmit').prop("disabled", "disabled");
						} else {
							$('#btnSubmit').prop("disabled", "");
						}
					}
				});

	});

	function validaDat(valor) {
		var date = valor;
		var ardt = new Array;
		var ExpReg = new RegExp(
				"(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}");
		ardt = date.split("/");
		erro = false;
		if (date.search(ExpReg) == -1) {
			erro = true;
		} else if (((ardt[1] == 4) || (ardt[1] == 6) || (ardt[1] == 9) || (ardt[1] == 11))
				&& (ardt[0] > 30))
			erro = true;
		else if (ardt[1] == 2) {
			if ((ardt[0] > 28) && ((ardt[2] % 4) != 0))
				erro = true;
			if ((ardt[0] > 29) && ((ardt[2] % 4) == 0))
				erro = true;
		}
		if (erro) {
			return false;
		}
		return true;
	}
</script>
</body>
<jsp:include page="../template/scripts-rodape.jsp" />
</html>