$(document).ready(function(){
	var numTel = $("#numTel");
    var amount = $("#amount");
	$("#result").hide();
    $("#erreur").hide();
    $('#recharge').click(function() {
        $.ajax({
            url: 'http://localhost:8080/service-recharge/recharge',
            data: JSON.stringify({numTel: numTel.val(), typeRecharge: $("input[name='typeRecharge']:checked").val(),amount: amount.val(), operator: $("input[name='operator']:checked").val()}),
            headers: { 'Access-Control-Allow-Origin': '*' },
            type: 'POST',
            dataType: "json",
            contentType:"application/json; charset=utf-8",
            async: false,
            success: function(data, textStatus, jqXHR) {
            	remplir(data);  
            	if (!("Notification" in window)) {
				    alert("This browser does not support desktop notification");
				  }
				  else if (Notification.permission === "granted") {
				    var notification = new Notification("PHONE RECHARGED SUCCESSFULLY!");
				  }
				  else if (Notification.permission !== "denied") {
				    Notification.requestPermission().then(function (permission) {
				      if (permission === "granted") {
				        var notification = new Notification("PHONE RECHARGED SUCCESSFULLY!");
				      }
				    });
				  }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
                remplirErreur();
            }
        });
    });
    function remplirErreur() {
        $('#erreur').html('<div class="alert alert-danger text-center">This phone number is not correct!!</div>');
        $("#erreur").show();
    }
    function remplir(data) {
        var ligne="";
        ligne+='<img src="/img/success.png" height="200" width="200"/>';
        ligne+='<h3 color="green">DONE SUCCESSFULLY!!</h3>';
        ligne+='<div class="alert alert-info text-left">The phone number: <strong>'+data.numTel+'</strong><br/>';
        ligne+='The amount: <strong>'+data.amount+' DH</strong><br/>';
        ligne+='The operator: <strong>'+data.operator+'</strong><br/>';
        ligne+='The type of the recharge: <strong>'+data.typeRecharge+'</strong><br/>';
        ligne+='The date of the recharge: <strong>'+data.date+'</strong><br/>';
        ligne+='</div>';
        $('#result').html(ligne);
        $("#result").show();
        $("#form").hide();
    }
});