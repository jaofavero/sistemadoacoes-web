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
 
function validForm(acao)
{
	switch(acao)
	{
		case 1:
			var nome = document.querySelector("#name");
			var telefone = document.querySelector("#telefone");
			if(nome.value == '' || telefone.value == '')
			{
				alert("Nome ou telefone vazios, para cadastrar preencha os dados por favor.");
				return false;
			}
			return true;
		break;
	}
	
}
