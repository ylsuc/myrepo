/**
 * 
 */
$(document).ready(function(){
	$(".chkDeleted").click(function(){
		var chkDeleted = $(this).is(":checked");
		var par = $(this).parent().parent();
		console.log(par);
	});
});