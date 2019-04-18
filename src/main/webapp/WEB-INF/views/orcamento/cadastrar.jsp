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
										<label>Forma de Pagamento</label> <select name="tp_pessoa"
											required id="tp_pessoa" class="form-control">
											<option value="">Selecione</option>
											<option value="1">Dinheiro</option>
											<option value="2">Cartão Débito</option>
											<option value="3">Cartão Crédito</option>
											<!-- 											<option value="2">Jurídica</option> -->
										</select>
									</div>
								</div>

								<!-- <div class="col-md-2">
									<div class="form-group">
										<label>Data do Orçamento</label> <input autocomplete="off"
											placeholder="DD/MM/AAAA" id="data" name="data" type="text"
											class="form-control dataMask" placeholder="Data">
									</div>
								</div> -->
								<div class="col-md-2">
									<div class="form-group">
										<label>CPF do Cliente</label> <input type="text" id="cpf"
											name="cpf" class="form-control" placeholder="CPF do Cliente">
									</div>
								</div>
								<div class="col-md-3 pl-1">
									<div class="form-group">
										<input type="hidden" id="clienteId" name="clienteId" /> <label>Nome</label>
										<input id="nome" name="nome" type="text" class="form-control"
											disabled="disabled" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-3 pl-1">
									<div class="form-group">
										<label>Email</label> <input id="email" name="email"
											type="text" disabled="disabled" class="form-control"
											placeholder="Email">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Telefone</label> <input type="text" maxlength='40'
											minlength='1' required id="telefone" disabled="disabled"
											name="telefone" class="form-control" placeholder="Telefone">
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Celular</label> <input type="text" id="celular"
											disabled="disabled" name="celular" class="form-control"
											placeholder="Celular">
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>Estado</label> <input type="text" disabled="disabled"
											required id="uf" name="uf" class="form-control"
											placeholder="UF">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Cidade</label> <input type="text" disabled="disabled"
											id="cidade" name="cidade" class="form-control"
											placeholder="Cidade">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Bairro</label> <input id="bairro" type="text"
											disabled="disabled" class="form-control" placeholder="Bairro">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Rua</label> <input type="text" id="rua" name="rua"
											disabled="disabled" class="form-control" placeholder="Rua">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Número</label> <input type="text" id="numero"
											name="numero" disabled="disabled" class="form-control"
											placeholder="Número">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Veículo-Placa</label> <input type="text" required
											id="veiculoPlaca" name="veiculoPlaca" class="form-control"
											placeholder="Placa do Veículo">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Marca</label> <input type="text" required id="marca"
											name="marca" class="form-control" placeholder="Marca">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Modelo</label> <input type="text" id="modelo"
											name="modelo" class="form-control" placeholder="Modelo">
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label>Cor</label> <input type="text" id="cor" name="cor"
											class="form-control" placeholder="Cor">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Ano</label> <input type="text" id="ano" name="ano"
											class="form-control" placeholder="Ano">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Odômetro (KM)</label> <input type="text" required
											id="km" name="km" class="form-control"
											placeholder="Odômetro (KM)">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<ul class="nav nav-tabs" id="myTab" role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="home-tab" data-toggle="tab" onclick="alteraTipoItem(1)"
											href="#home" role="tab" aria-controls="home"
											aria-selected="true">Peças e Produtos</a></li>
										<li class="nav-item"><a class="nav-link" id="profile-tab"
											data-toggle="tab" onclick="alteraTipoItem(2)" href="#perfil"
											role="tab" aria-controls="profile" aria-selected="false">Serviços</a></li>
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
																	class="dataTables_empty text-center">Nenhuma peça/produto
																	adicionada até o momento.</td>
															</tr>
														</tbody>
													</table>
												</div>
												<div class="col-md-2 text-center">
													<button name="btnSubmit" rel="tooltip"
														data-original-title="Adicionar Nova Peça"
														onclick="adicionarNaTabela(1)" type="button"
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
																<th class="text-center">Ação</th>
															</tr>
														</thead>
														<tbody id="tabelaIndexServico">
															<tr class="odd" id="nenhumServicoEncontrado">
																<td valign="top" colspan="7"
																	class="dataTables_empty text-center">Nenhum
																	serviço adicionado até o momento.</td>
															</tr>
														</tbody>
													</table>
												</div>
												<div class="col-md-2 text-center">
													<button name="btnSubmit" rel="tooltip"
														data-original-title="Adicionar Novo Serviço"
														onclick="adicionarNaTabela(2)" type="button"
														class="btn btn-default btn-fill btn-pesquisa">
														<i class="nc-icon nc-simple-add"></i> Adicionar
													</button>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-10"></div>
								<div class="col-md-2 text-center" id="totalGeralFormatado"></div>
							</div>
						</form:form>
						<div class="row">
							<div class="col-md-5">
								<a href='/e-SIGOM/home/orcamentos' type="button"
									class="btn btn-warning btn-fill"> <i
									class="nc-icon nc-stre-left"></i> Consulta
								</a>

								<button id="salvar" name="salvar" onclick="salvarCadastro()"
									type="button" class="btn btn-success btn-fill">
									<i class="nc-icon nc-send"></i> Salvar
								</button>

								<a href='/e-SIGOM/home/orcamentos/cadastrar'
									class="btn btn-info btn-fill"> <i
									class="nc-icon nc-refresh-02"></i> Limpar
								</a>
							</div>
							<div class="col-md-7"></div>
						</div>
					</div>
				</div>
				<form:form id="modalAdicionarItem" class="modal fade" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="tituloModal"></h4>
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
											<input placeholder="Busque pelo nome" name="inputNome"
												id="inputNome" class="form-control">
										</div>
									</div>
									<div class="col-lg-2">
										<div class="form-group">
											<button id="encontrarItem" type="button"
												class="btn btn-primary btn-fill">
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
											<tbody id="tabelaModal">
												<tr class="odd" id="nenhumEncontrado">
													<td valign="top" colspan="7"
														class="dataTables_empty text-center">Nenhum registro
														encontrado com os parâmetros informados.</td>
												</tr>
											</tbody>

										</table>
										<div class="row">
											<div class="col-md-12 text-center" id="totalDeRegistrosModal"></div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</form:form>

				<form:form id="clienteNaoCadastrado" class="modal fade"
					role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Cliente não cadastrado</h4>
								<button type="button" class="close" onclick="fecharModal()"
									data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<p>O cliente para quem que você está tentando gerar o
												orçamento ainda não está cadastrado no e-SIGOM.</p>
											<p>Favor cadastrá-lo no sistema.</p>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<div class="row">
									<div class="col-lg-12">
										<a href="/e-SIGOM/home/clientes/cadastrar" type="button"
											class="btn btn-warning btn-fill"> <i
											class="nc-icon nc-single-02"></i> Cadastrar
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
				<form:form id="retornoCadastro" class="modal fade" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="msgRetornoCadastro"></h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<p>Selecione abaixo a ação que deseja realizar.</p>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12 text-right">
										<br> <a href="/e-SIGOM/home/orcamentos/cadastrar"
											type="button" class="btn btn-primary btn-fill"> <i
											class="nc-icon nc-simple-add"></i> Novo Cadastro
										</a> <a href="#" type="button" class="btn btn-success btn-fill">
											<i class="nc-icon nc-tap-01"></i> Imprimir
										</a> <a href="#" type="button" class="btn btn-default btn-fill">
											<i class="nc-icon nc-email-83"></i> Enviar por e-mail
										</a> <a href="#" type="button" class="btn btn-danger btn-fill">
											<i class="nc-icon nc-simple-delete"></i> Excluir
										</a> <a href="/e-SIGOM/home/orcamentos" type="button"
											class="btn btn-warning btn-fill"> <i
											class="nc-icon nc-stre-left"></i> Voltar á Consulta
										</a>
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


	// Arrays
	var listPecas = [];
	var listServicos = [];
	
	var dto = {};
		// Ajax Salvar
		
		
		function salvarCadastro(){
			dto.listPecas = listPecas;
			dto.listServicos = listServicos;
	
			// Campos Preenchidos
			dto.clienteId = $('#clienteId').val();
			dto.veiculoPlaca = $('#veiculoPlaca').val();
			dto.marca = $('#marca').val();
			dto.modelo = $('#modelo').val();
			dto.cor = $('#cor').val();
			dto.ano = $('#ano').val();
			dto.km = $('#km').val();
			
			// Ajax
			$.ajax(
					{
						url : "save",
						type : 'POST',
						data : {
							dto : JSON.stringify(dto)
						}
					})
			.done(
					function(retorno) {
											
				// Se sucesso
						if(retorno){
							$('#msgRetornoCadastro').html("Orçamento nº "+retorno+" gerado com sucesso!");
							
							$('#retornoCadastro').modal({
								backdrop : 'static',
								keyboard : false
							});
						}
					});
		};
	
	// Total Geral
	var totalGeral = 0;
	var totalGeralFormatado = "";
	if(!totalGeralFormatado){
		$('#totalGeralFormatado').html("Total Geral: R$00,00");
	}
	
	// Abrir modal
	var tipoItem = 1;
	function adicionarNaTabela(item) {
		$('#totalDeRegistrosModal').html("");
		
		var tituloModal = "";
		tipoItem = item;
		
		$('#modalAdicionarItem').modal({
			backdrop : 'static',
			keyboard : false
		});
		
		if(item == 1){
			tituloModal = "Adicionar Peça ao Orçamento";
			$('#tituloModal').html(tituloModal);
		}
		
		if(item == 2){
			tituloModal = "Adicionar Serviço ao Orçamento";
			$('#tituloModal').html(tituloModal);
		}
	}
	

	// Altera tipo
	function alteraTipoItem(item){
		tipoItem = item
	}
	
	// Remover Item
	function removerItemGrid(id, valorSubtrair) {
		var idTr = '';
		var idTabela = '';
		var nomeArray = '';
		var resetarTabela = '';
		if(tipoItem == 1){
			idTabela = 'tabelaIndexPeca';
			nomeArray = 'listPecas';
		} else if (tipoItem == 2){
			idTabela = 'tabelaIndexServico';
			nomeArray = 'listServicos';
		}
		
		idTr = id;
		var parent = document.getElementById(idTabela);
		var child = document.getElementById(idTr);
		parent.removeChild(child);
	
		if(tipoItem == 1){
			var index = listPecas.map(x => {
				  return x.id;
				}).indexOf(id);

			listPecas.splice(index, 1);
			showNotification('top', 'right', 'O item foi removido do orçamento!');
			
			if(listPecas.length == 0){
				$('#nenhumEncontrado')
				.append(
						'<td valign="top" colspan="7"'
			+'class="dataTables_empty text-center">Nenhuma peça/produto adicionada até o momento.</td>'
								);
			}

		} else if(tipoItem == 2){
			var index = listServicos.map(x => {
				  return x.id;
				}).indexOf(id);

			listServicos.splice(index, 1);
			showNotification('top', 'right', 'O item foi removido do orçamento!');
			
			if(listServicos.length == 0){
				$('#nenhumServicoEncontrado')
				.append(
						'<td valign="top" colspan="7"'
			+'class="dataTables_empty text-center">Nenhum serviço adicionado até o momento.</td>'
								);
			}
			
		}
		
		// Subtratir valor
		$('#totalGeralFormatado').html("");
		var totalGeral = totalGeralFormatado.replace("R$", '');
		var totalGeral = parseFloat(totalGeral.replace(",",''));
		var tt = formataDinheiro(parseFloat(totalGeral) - parseFloat(valorSubtrair));
		$('#totalGeralFormatado').html("Total Geral: "+tt);
		totalGeralFormatado = tt;
	}

	function formataDinheiro(n) {
		return "R$ "
				+ n.toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+\,)/g,
						"$1.");
	}

	function fecharModal() {
		$('#modalAdicionarItem').modal('hide');
		$('#tabelaModal').html("");
		$('#totalDeRegistrosModal').html("");
		$('#inputNome').val("");
		$('#tabelaModal')
				.append(
						'<tr class="odd">'
								+ '<td valign="top" colspan="7"'
			+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
								+ '</tr>');
	}



	function adicionarItem(id, descricao, quantidade, valorUnitario) {

		var stringInput = "#inputQtdPecas" + id;
		var valorTotalQtde = $('' + stringInput + '').val();

		var valorUnitarioFormatado = parseFloat(valorUnitario.replace("R$", ''));
		var subTotalFinalFormatado = formataDinheiro(valorTotalQtde
				* valorUnitarioFormatado);
		
		var subTotalInteger = parseFloat(valorTotalQtde * valorUnitarioFormatado);
		
		// Fechar Modal
		$('#modalAdicionarItem').modal('hide');

		// Limpar modal
		$('#tabelaModal').html("");
		$('#inputNome').val("");

		$('#tabelaModal')
				.append(
						'<tr class="odd">'
								+ '<td valign="top" colspan="7"'
					+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
								+ '</tr>');

		
		// Parte de inserção nas grid da tela propriamente dita
		var idTabela = '';
		var nomeArray = '';
		var resetarTabela = '';
		if(tipoItem == 1){
			idTabela = '#tabelaIndexPeca';
			resetarTabela = '#nenhumEncontrado';
		} else if (tipoItem == 2){
			idTabela = '#tabelaIndexServico';
			resetarTabela = '#nenhumServicoEncontrado';
		}
		
		// Resetar Tabela
		$(resetarTabela).html("");
		
		// Adicionar Item Tabela
		$(idTabela).append(
				'<tr id="'
				+id
				+'">'
				// ID
				+ '<td class="text-center">' + id + '</td>'

				// Descrição
				+ '<td>' + descricao + '</td>'

				// Quantidade
				+ '<td class="text-center">' + valorTotalQtde + '</td>'

				// Valor Unitário
				+ '<td class="text-center">' + valorUnitario + '</td>'

				// SubTotal
				+ '<td class="text-center">' + subTotalFinalFormatado + '</td>'
				
				// Ação
				+ '<td class="text-center">'
						+ '<button rel="tooltip" name="btnSubmit"'
						+ 'data-original-title="Excluir" id="btnSubmit"'
						+ 'onclick="removerItemGrid(' +id+','+subTotalInteger+')" type="button"'
						+ 'class="btn btn-danger btn-fill">'
						+ '<i class="nc-icon nc-simple-remove"></i>'
						+ '</button>' + '</td>'

						+ '</tr>');

		// Msg de sucesso
		showNotification('top', 'right', 'O item foi adicionado ao orçamento!');

		// Adicionar a lista
		var id = {
			id : id,
			quantidade : valorTotalQtde,
			subTotal: subTotalInteger,
			tipoItem: tipoItem,
		}
		
		if(tipoItem == 1){
			listPecas.push(id);
		} else if(tipoItem == 2){
			listServicos.push(id);
		}
		
		
		// Formatar Total Geral
		totalGeral = totalGeral + subTotalInteger;
		totalGeralFormatado = formataDinheiro(totalGeral);
		$('#totalGeralFormatado').html("Total Geral: "+totalGeralFormatado);
	}

	// Evento 2: Botão Adicionar Unidade Gestora
	$('#encontrarItem')
			.click(
					function() {
						// Armazena em variável valor do Input
						var inputNome = $("#inputNome").val();

						// Caso não esteja preenchido, formata erro
						if (!inputNome) {
							$('#tabelaModal').html("");

							$('#tabelaModal')
									.append(
											'<tr class="odd">'
													+ '<td valign="top" colspan="7"'
					+'class="dataTables_empty text-center">Nenhum registro encontrado com os parâmetros informados.</td>'
													+ '</tr>');
							$('#totalDeRegistrosModal').html("");
							$('#errorMessage').html("");
							$('#errorMessage')
									.append(
											'Erro!'
													+ "&nbsp;"
													+ 'O campo "Nome" é obrigatório para se realizar a pesquisa.'
													+ "&nbsp;");

							$("#error").show();

							// Senão chama ajax
						} else {
							$('#errorMessage').html("");
							$("#error").hide();
							
							var url = '';
							if(tipoItem == 1){
								url = 'getPesquisaPeca/';
							} else if(tipoItem == 2){
								url = 'getPesquisaServico/';
							}
							
							
							$
									.ajax(
											{
												url : url+inputNome,
												type : 'GET',
												data : {
													nome : inputNome
												}
											})
									.done(
											function(response) {
												if (response) {
													if (response.lista.length > 0) {
														$('#tabelaModal').html(
																"");
														response.lista.forEach(function(valor) {

																	var quantidade = 1;

																	$(
																			'#tabelaModal')
																			.append(
																					'<tr><td class="text-center">'
																							+ valor.id
																							+ '</td>'
																							+ '<td>'
																							+ valor.descricao
																							+ '</td>'
																							+ '<td class="text-center">'
																							+ valor.valor
																							+ '</td>'

																							// Quantidade
																							+ '<td class="text-center"><input type="text" maxlength="40" minlength="1" class="form-control" value="1" size="1" id="inputQtdPecas'
																							+valor.id
																							+'"placeholder="Quantidade"></td>'

																							// Ação
																							+ '<td class="text-center">'
																							+ '<button rel="tooltip"'
																							+ 'data-original-title="Adicionar Peça"'
																							+ 'onclick="adicionarItem('
																							+ valor.id
																							+ ','
																							+ "'"
																							+ valor.descricao
																							+ "'"
																							+ ','
																							+ quantidade
																							+ ','
																							+ "'"
																							+ valor.valor
																							+ "'"
																							+ ')" type="button"'
																							+ 'class="btn btn-warning btn-fill">'
																							+ '<i class="nc-icon nc-simple-add"></i> Adicionar'
																							+ '</button>'
																							+ '</td></tr>');
																	
																	
																	
																	$('#totalDeRegistrosModal').html("");
																	$('#totalDeRegistrosModal').html(response.qtdTotalDeRegistros + " registro(s) encontrado(s).")
																
																

																});
													} else {
														$('#totalDeRegistrosModal').html("");
														$('#tabelaModal').html(
																"");
														$('#tabelaModal')
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

				
				
				$("#cpf").blur(
						function() {
							//Nova variável "CPF"
							var cpf = $(this).val();
							console.log(cpf);
							//Verifica se o campo não é vazio
							if (cpf != "") {
									$.ajax(
											{
												url : 'getCliente/'+cpf,
												type : 'GET',
												data : {
													cpf : cpf
												}
											})
									.done(
											function(resultado) {
												
												
												if(resultado){
														$("#clienteId").val(resultado.id);
														$("#nome").val(resultado.nome);
														$("#email").val(resultado.email);
														$("#telefone").val(resultado.telefone);
														$("#celular").val(resultado.celular);
														$("#uf").val(resultado.estado);
														$("#cidade").val(resultado.cidade);
														$("#bairro").val(resultado.bairro);
														$("#rua").val(resultado.rua);
														$("#numero").val(resultado.numero);
												} else {
													
													$('#clienteNaoCadastrado').modal({
														backdrop : 'static',
														keyboard : false
													});
												}
						});
							}
				
						});
				
				
				
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
	$('#data').mask('00/00/0000');

	$(function() {
		$('#data').datepicker(
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