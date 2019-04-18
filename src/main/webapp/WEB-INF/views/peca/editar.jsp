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
						<h4 class="card-title">Cadastrar Peça</h4>
					</div>
					<div class="card-body">
						<form:form method="POST" modelAttribute="obj"
							cssClass='form-horizontal'>
							<div class="row">
							<div class="col-md-2">
									<div class="form-group">
										<label>Tipo</label> <select name="tipoId" required id="tipoId"
											class="form-control">
											<option value="">Selecione</option>
											<option value="1">Peça</option>
											<option value="2">Óleo</option>
											<option value="3">Acessório</option>
											<option value="4">Outros</option>
										</select>
									</div>
								</div>
								
								<div class="col-md-6">
									<div class="form-group">
										<label>Descrição</label> <input type="text" maxlength='50'
											minlength='1' required id="descricao"
											value='${obj.descricao}' name="descricao"
											class="form-control" placeholder="Descrição">
									</div>
								</div>
								
								<div class="col-md-2">
									<div class="form-group">
										<label>Categoria</label> <select name="categoriaId" required
											id="categoriaId" class="form-control">
											<option value="">Selecione</option>
											<option value="1">Motor</option>
											<option value="2">Suspensão</option>
											<option value="3">Cambio</option>
											<option value="4">Escapamento</option>
											<option value="5">Outros</option>
										</select>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<label>Valor (R$)</label> <input maxlength='10'
											autocomplete="off" placeholder="Valor" id="valor"
											value='${obj.valor}' name="valor" type="text"
											class="form-control" placeholder="Valor">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-5">
									<a href='/e-SIGOM/home/pecas' type="button"
										class="btn btn-warning btn-fill"> <i
										class="nc-icon nc-stre-left"></i> Consulta
									</a>

									<button type="submit" type="button"
										class="btn btn-success btn-fill">
										<i class="nc-icon nc-send"></i> Salvar
									</button>

									<a href='/e-SIGOM/home/pecas/${obj.id}'
										class="btn btn-info btn-fill"> <i
										class="nc-icon nc-refresh-02"></i> Atualizar
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
	$(document).ready(function() {
		$(function() {
			
			var categoriaId = ${obj.categoriaId};
			categoriaId ? document.getElementById("categoriaId").value = categoriaId : document.getElementById("categoriaId").value = '';

			
			var tipoId = ${obj.tipoId};
			tipoId ? document.getElementById("tipoId").value = tipoId : document.getElementById("tipoId").value = '';

			
			$("#valor").maskMoney({
				symbol : 'R$ ',
				showSymbol : true,
				thousands : '.',
				decimal : '.',
				symbolStay : true
			});
		});
	});
</script>
</body>
<jsp:include page="../template/scripts-rodape.jsp" />
</html>