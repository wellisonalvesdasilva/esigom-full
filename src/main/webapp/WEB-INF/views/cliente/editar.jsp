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
						<h4 class="card-title">Editar Cliente</h4>
					</div>
					<div class="card-body">
						<form method="POST" modelAttribute="obj">
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Tipo de Pessoa</label> <select name="tp_pessoa"
											required id="tp_pessoa" class="form-control">
											<option value="1">Física</option><!-- 
											<option value="2">Jurídica</option> -->
										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Nome</label> <input type="text" maxlength='40'
											minlength='1' required value='${obj.nome}' id="nome"
											name="nome" class="form-control" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Data de Nascimento</label> <input autocomplete="off"
											placeholder="DD/MM/AAAA" id="dt_nascimento"
											value='${obj.dataFormatada}' name="dt_nascimento" type="text"
											class="form-control dataMask" placeholder="Código">
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<label>Gênero</label> <select value='${obj.genero}'
											name="genero" required id="genero" class="form-control">
											<option value="">Selecione</option>
											<option value="1">Masculino</option>
											<option value="2">Feminino</option>
										</select>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Telefone</label> <input value='${obj.telefone}'
											type="text" maxlength='40' minlength='1' id="telefone"
											name="telefone" class="form-control" placeholder="Telefone">
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Celular</label> <input value='${obj.celular}'
											type="text" maxlength='40' minlength='1' required
											id="celular" name="celular" class="form-control"
											placeholder="Celular">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>E-mail</label> <input type="text" value='${obj.email}'
											maxlength='40' minlength='1' id="email" name="email"
											class="form-control" placeholder="E-mail">
									</div>
								</div>

								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>RG</label> <input id="rg" value='${obj.rg}'
											maxlength='7' name="rg" type="text" class="form-control"
											placeholder="RG">
									</div>
								</div>
								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>CPF</label> <input id="cpf" value='${obj.cpf}'
											maxlength='35' name="cpf" type="text" class="form-control"
											placeholder="CPF">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>CEP</label> <input value='${obj.cep}' type="text"
											maxlength='40' minlength='1' required id="cep" name="cep"
											class="form-control" placeholder="CEP">
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>UF</label> <input maxlength='20' minlength='1'
											type="text" id="estado" value='${obj.estado}' required
											name="estado" class="form-control" placeholder="UF">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Cidade</label> <input type="text" maxlength='40'
											minlength='1' required value='${obj.cidade}' id="cidade"
											name="cidade" class="form-control" placeholder="Cidade">
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label>Bairro</label> <input type="text" maxlength='40'
											minlength='1' required value='${obj.bairro}' id="bairro"
											name="bairro" class="form-control" placeholder="Bairro">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Rua</label> <input type="text" maxlength='40'
											minlength='1' required value='${obj.rua}' id="rua" name="rua"
											class="form-control" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Número</label> <input type="text" maxlength='40'
											minlength='1' required value='${obj.numero}' id="numero"
											name="numero" class="form-control" placeholder="Número">
									</div>
								</div>

							</div>
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
						</form>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../template/rodape.jsp" />
</body>
<script>
	$(document).ready(
			function() {
				
				var tipoDePessoa = ${obj.tp_pessoa};
				tipoDePessoa ? document.getElementById("tp_pessoa").value = tipoDePessoa : document.getElementById("tp_pessoa").value = '';

				var genero = ${obj.genero};
				genero ? document.getElementById("genero").value = tipoDePessoa : document.getElementById("genero").value = '';
				
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

	$(".dataMask").datepicker(
			{
				dateFormat : 'dd/mm/yy',
				dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta',
						'Sexta', 'Sábado' ],
				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
						'Sáb', 'Dom' ],
				monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
						'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
						'Outubro', 'Novembro', 'Dezembro' ],
				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun',
						'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
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