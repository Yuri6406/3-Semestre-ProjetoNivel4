/**
 * 
 * Confirmação de esclusão de um contato
 * @author Yuri
 */

 
 
 function confirmar(idProduto){
	
	let resposta = confirm("Confima a exclusão deste produto? ")
	if (resposta === true){
		window.location.href = "delete?idProduto = " + idProduto
	}
 }