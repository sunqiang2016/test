//1
$(function() {
	$(document).ready(function() {
		$("#but").click(function() {
			$("p").hide();
		});
	});
});
// 2.
// $.post(URL,data,callback);
// $(function() {
// $(document).ready(function() {
// $("#but1").click(function() {
// alert("bb");
// $.post("user/showUser",
// {
// id : 1
// },
// function(data,status){
// alert("Data: " + data + "\nStatus: " + status);
// } );
//			
// });
//			
// });
// });

// 3.
$(function() {
	$(document).ready(function() {
		$("#but1").click(function() {
			alert("bb");
			$.ajax({
				url : 'mvc/ajax',
				dataType : 'json',
				success : function(result, status) {
					alert(result);
				}
			});

		});
	});
});
