$(document).ready(function(){
	var cinSender = $("#cinSender");
    var nameReceiver = $("#nameReceiver");
    var amount = $("#amount");
	$("#code").hide();
    $('#send').click(function() {
        $.ajax({
            url: 'http://localhost:8080/service-transfer/sendMoney',
            data: JSON.stringify({cinSender: cinSender.val(), nameReceiver: nameReceiver.val(), amount: amount.val()}),
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
				    var notification = new Notification("MONEY SENT SUCCESSFULLY!");
				  }
				  else if (Notification.permission !== "denied") {
				    Notification.requestPermission().then(function (permission) {
				      if (permission === "granted") {
				        var notification = new Notification("MONEY SENT SUCCESSFULLY!");
				      }
				    });
				  }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        }); 
    });
    function remplir(data) {
        var ligne="";
        ligne+='<img src="/img/success.png" height="200" width="200"/>';
        ligne+='<h3 color="green">DONE SUCCESSFULLY!!</h3>';
        ligne+='<div class="alert alert-info">The code of the transfer: <strong>'+data+'</strong></div>';
        $('#code').html(ligne);
        $("#code").show();
        $("#form").hide();
    }
    
});