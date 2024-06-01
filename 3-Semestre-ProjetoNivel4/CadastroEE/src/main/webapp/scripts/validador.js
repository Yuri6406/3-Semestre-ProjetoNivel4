/**
 * 
 */

 function validar(){
	let nome = frmProduto.nome.value
	let quantidade = frmProduto.quantidade.value
	let precoVenda = frmProduto.precoVenda.value
	if(nome === ""){
		alert('Preencha o campo nome')
		frmProduto.nome.focus()
		return false
	} else if (quantidade === ""){
		alert('Preencha o campo quantidade')
		frmProduto.quantidade.focus()
		return false
	} else if(precoVenda === ""){
		alert('Preencha o campo precoVenda')
		frmProduto.precoVenda.focus()
		return false
	}else{
		document.forms["frmProduto"].submit()
	}
 }