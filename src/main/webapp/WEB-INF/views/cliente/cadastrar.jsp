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
						<h4 class="card-title">Cadastrar Cliente</h4>
					</div>
					<div class="card-body">
						<form:form method="POST" modelAttribute="obj"
							cssClass='form-horizontal'>
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>Nome</label> <input type="text" maxlength='40'
											minlength='1' required id="nome" name="nome"
											class="form-control" placeholder="Nome">
									</div>
								</div>

								<!-- 	<div class="col-md-2">
									<div class="form-group">
										<label>Data de Nascimento</label> <input type="text"
											maxlength='10' minlength='1' id="dt_nascimento"
											name="dt_nascimento" class="form-control"
											placeholder="Data de Nascimento">
									</div>
								</div> -->

								<div class="col-md-2">
									<div class="form-group">
										<label>Gênero</label> <select name="genero" required
											id="genero" class="form-control">
											<option value="">Selecione</option>
											<option value="1">Masculino</option>
											<option value="2">Feminino</option>
										</select>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Telefone</label> <input type="text" maxlength='40'
											minlength='1' required id="telefone" name="telefone"
											class="form-control" placeholder="Telefone">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Celular</label> <input type="text" maxlength='40'
											minlength='1' required id="celular" name="celular"
											class="form-control" placeholder="Celular">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>E-mail</label> <input type="text" maxlength='40'
											minlength='1' required id="email" name="email"
											class="form-control" placeholder="e-Mail">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Tipo de Pessoa</label> <select name="tp_pessoa"
											required id="tp_pessoa" class="form-control">
											<option value="1">Física</option>
											<option value="2">Jurídica</option>
										</select>
									</div>
								</div>
								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>RG</label> <input id="rg" maxlength='35' minlength='20'
											required name="rg" type="text" class="form-control"
											placeholder="RG">
									</div>
								</div>

								<div class="col-md-2 pl-1">
									<div class="form-group">
										<label>CPF</label> <input id="cpf" maxlength='35'
											minlength='20' required name="cpf" type="text"
											class="form-control" placeholder="CPF">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>CEP</label> <input type="text" maxlength='40'
											minlength='1' required id="cep" name="cep"
											class="form-control" placeholder="CEP">
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>UF</label> <input maxlength='20' minlength='1'
											type="text" id="estado" required disabled="disabled"
											name="estado" class="form-control" placeholder="UF">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Cidade</label> <input type="text" maxlength='40'
											minlength='1' required id="cidade" name="cidade"
											disabled="disabled" class="form-control" placeholder="Cidade">
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group">
										<label>Bairro</label> <input type="text" maxlength='40'
											minlength='1' required disabled="disabled" id="bairro"
											name="bairro" class="form-control" placeholder="Bairro">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label>Rua</label> <input type="text" maxlength='40'
											minlength='1' required disabled="disabled" id="rua"
											name="rua" class="form-control" placeholder="Nome">
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Número</label> <input type="text" maxlength='40'
											minlength='1' required disabled="disabled" id="numero"
											name="numero" class="form-control" placeholder="Número">
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-5">
									<a name="btnSubmit" href='/e-SIGOM/home/cliente/consultar'
										type="button" class="btn btn-warning btn-fill"> <i
										class="nc-icon nc-stre-left"></i> Voltar
									</a>

									<button name="btnSubmit" type="submit" id="btnSubmit"
										type="button" class="btn btn-success btn-fill">
										<i class="nc-icon nc-send"></i> Salvar
									</button>

									<a name="btnSubmit" href='/e-SIGOM/home/cliente/cadastrar'
										id="btnSubmit" type="submit" class="btn btn-info btn-fill">
										<i class="nc-icon nc-refresh-02"></i> Limpar
									</a>
								</div>
								<div class="col-md-7"></div>
							</div>
						</form:form>
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
</script>
</body>
<jsp:include page="../template/scripts-rodape.jsp" />
</html>