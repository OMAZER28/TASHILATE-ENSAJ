$(document).ready(function(){
	var contractNbr = $("#contractNbr");
    var agency = $("#agency");
    $("#bills").hide();
	$("#result").hide();
    $("#erreur").hide();
    $('#search').click(function() {
        $.ajax({
            url: 'http://localhost:8080/service-payment/allBills',
            data: JSON.stringify({contractNbr: contractNbr.val(),agency: agency.val()}),
            headers: { 'Access-Control-Allow-Origin': '*' },
            type: 'POST',
            dataType: "json",
            contentType:"application/json; charset=utf-8",
            async: false,
            success: function(data, textStatus, jqXHR) {
            	remplirTableau(data);               
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
                remplirErreur();
            }
        });
    });
    function remplirErreur() {
        $('#erreur').html('<div class="alert alert-danger text-center">There is no bill for this contract number!!</div>');
        $("#erreur").show();
    }
    function remplir(data) {
        var ligne="";
        ligne+='<div class="alert alert-info text-left mb-2">';
        ligne+='The contract number: <strong>'+data.contractNbr+'</strong><br/>';
        ligne+='The W/E provider: <strong>'+data.agency+'</strong><br/>';
        ligne+='The month: <strong>'+data.month +'\/' +data.year+'</strong><br/>';
        ligne+='The amount: <strong>'+data.amount+' DH</strong><br/>';
        ligne+='The date: <strong>'+data.date+'</strong><br/>';
        ligne+='</div>';
        $('#result').html($('#result').html()+ligne);
        $("#result").show();
        $("#bills").hide();
    }
    function pay(id){
    	$.ajax({
            url: 'http://localhost:8080/service-payment/pay',
            data: JSON.stringify({id: id}),
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
				    var notification = new Notification("PAYMENT DONE SUCCESSFULLY!");
				  }
				  else if (Notification.permission !== "denied") {
				    Notification.requestPermission().then(function (permission) {
				      if (permission === "granted") {
				        var notification = new Notification("PAYMENT DONE SUCCESSFULLY!");
				      }
				    });
				  }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    }
    function remplirTableau(data) {
        var ligne="";
        ligne+='<table class="table table-striped table-bordered"><thead><tr><th scope="col"></th><th scope="col">Amount (DH)</th><th scope="col">Month</th></tr></thead><tbody>';
        for (i = 0; i < data.length; i++) {
            ligne += '<tr class="text-right"><th scope="row"><input class="form-check-input id" type="checkbox" name="id" value="'+data[i].id +'"></th>';
            ligne += '<td>' + data[i].amount + '</td>';
            ligne += '<td>' + data[i].month +'\/' +data[i].year + '</tr>';
        }
        ligne+='</tbody></table>';
        ligne+='<div class="alert alert-info">The total to pay : <strong><span id="total">0.00</span>DH</strong></div>';
        ligne+='<div class="form-group"><button type="submit" name="pay" id="pay" class="btn btn-primary btn-block mb-4" value="Pay">Pay</button></div>';
        $('#bills').html(ligne);
        $("#bills").show();
        $("#form").hide();
        $(document).on('change', '.id', function() {
        	if($(this).is(':checked') == true){
        		var montant = parseFloat($(this).closest('tr').find('td').eq(0).text());
        		$("#total").html((parseFloat($("#total").html())+montant).toFixed(2));
        		
        	}else{
        		var montant = parseFloat($(this).closest('tr').find('td').eq(0).text());
        		$("#total").html((parseFloat($("#total").html())-montant).toFixed(2));
        	}
        })
        $(document).on('click', '#pay', function() {
        	
        	$('input[name="id"]:checked').each(function() {
        		   pay(this.value);
        		});
        })
    }
});