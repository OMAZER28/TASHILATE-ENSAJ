$(document).ready(function(){
	var code = $("#code");
    var cinReceiver = $("#cinReceiver");
	$("#result").hide();
    $("#erreur").hide();
    $('#receive').click(function() {
        $.ajax({
            url: 'http://localhost:8080/service-transfer/receiveMoney',
            data: JSON.stringify({cinReceiver: cinReceiver.val(), code: code.val()}),
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
				    var notification = new Notification("MONEY RECEIVED SUCCESSFULLY!");
				  }
				  else if (Notification.permission !== "denied") {
				    Notification.requestPermission().then(function (permission) {
				      if (permission === "granted") {
				        var notification = new Notification("MONEY RECEIVED SUCCESSFULLY!");
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
        $('#erreur').html('<div class="alert alert-danger text-center">This Transfer does not exist!!</div>');
        $("#erreur").show();
    }
    function remplir(data) {
        var ligne="";
        ligne+='<img src="/img/success.png" height="200" width="200"/>';
        ligne+='<h3 color="green">DONE SUCCESSFULLY!!</h3>';
        ligne+='<div class="alert alert-info text-left">The name of the receiver: <strong>'+data.nameReceiver+'</strong><br/>';
        ligne+='The CIN of the receiver: <strong>'+data.cinReceiver+'</strong><br/>';
        ligne+='The CIN of the sender: <strong>'+data.cinSender+'</strong><br/>';
        ligne+='The amount received: <strong>'+data.amount+' DH</strong><br/>';
        ligne+='The date of sending money: <strong>'+data.dateSending+'</strong><br/>';
        ligne+='The date of the receiving: <strong>'+data.dateReceiving+'</strong><br/>';
        ligne+='</div>';
        $('#result').html(ligne);
        $("#result").show();
        $("#form").hide();
    } 
});