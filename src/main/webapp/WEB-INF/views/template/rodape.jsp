<script>
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

	// Limpar
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
		if (e.which == 13)
			$('#btnSubmit').click();
	});
</script>