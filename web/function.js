function changePassword(){
    window.location = "http://localhost:8080/quinielero/changePassword2.html";
}

function changeNewPassword(e){
    var user = document.getElementById("user").value;
    var oldPassword = document.getElementById("oldPassword").value;
    var newPass = document.getElementById("newPass").value;
    var ConfirmPass = document.getElementById("ConfirmPass").value;
    if(newPass !== ConfirmPass){
        document.getElementById("status").innerHTML = "No coinciden";
        e.preventDefault();
    } else {
        window.location = "changePassword.jsp?user="+user+"&oldPassword="+oldPassword+"&newPassword="+newPass;
    }
}