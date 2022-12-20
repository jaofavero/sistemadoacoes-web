//Validação formulário de login
function submeterFormLogin()
{
    let login = document.querySelector("#login");
    let senha = document.querySelector("#senha");

    if(login.value == "")
    {
        alert("Login está vazio, por favor digite um login antes de entrar no programa.");
        login.focus();
        return false;
    }
    if(senha.value == "")
    {
        alert("Senha está vazia, por favor digite uma senha antes de entrar no programa.");
        login.focus();
        return false;
    }
    return true;
}
function remover()
{
	var formExcluir = document.querySelector("#formExcluir");
	
	if(confirm("Deseja realmente excluir esse doador?"))
	{
		formExcluir.submit();
	}
}