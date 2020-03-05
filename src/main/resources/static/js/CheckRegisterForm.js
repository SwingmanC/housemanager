function usernameIsExist() {
    var username = $("#username").val();
    $.ajax({
        async:true,
        type:'post',
        url:'/account/usernameIsExist',
        data:{'username':username},
        dataType:'json',
        cache:false,
        success:function (data) {
            console.log(data);
            if (data["msg"]==='Exist')
            {
                $('#usernameMsg').html("<font color='red'>This username has been used!</font>");
            }
            else
            {
                $('#usernameMsg').html("<font color='green'>This username can be used!</font>");
            }
        },
        error:function () {
            alert("error");
        }
    })
}

function passwordIsValid() {
    var pass=$("#password").val();

    var div =document.getElementById("passwordMsg");

    if(pass.trim().length>0&&pass.trim().length<6)
    {
        div.innerHTML="<font color='red'>Password length should not be less than 6 bits!</font>";
        return false;
    }
    else if(pass.trim().length>=6) {
        div.innerHTML = "<font color='green'>This password can be used</font>";
        return true;
    }
}

function passwordIsSame(){
    var pass1=$("#password").val();
    var pass2=$("#repeatedPassword").val();

    var div=document.getElementById("repeatedPasswordMsg");

    if(pass1!=pass2&&pass2.trim().length>0){
        div.innerHTML="<font color='red'>The passwords you enter twice must be the same!</font>";
        return false;
    }
    else if(pass1==pass2&&pass1.trim().length>0)
    {
        div.innerHTML="<font color='green'>ok</font>";
        return true;
    }
}

function emailIsValid(){
    var email=$("#email").val();
    console.log(email);
    var div=document.getElementById("emailMsg");

    if(email.trim().length>0) {
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var isok= reg.test(email);
        if(!isok) {
            div.innerHTML="<font color='red'>Error in email format!</font>";
            return false;
        }
        else
        {
            div.innerHTML="<font color='green'>This email can be used</font>";
            return true;
        }
    }
}

function checkAllRegisterForm()
{
    var username=$("#username").val();
    var pass1=$("#password").val();
    var pass2=$("#repeatedPassword").val();
    var email=$("#email").val();

    var div=document.getElementById("usernameMsg").innerText;

    if(username.trim().length==0||pass1.trim().length==0||pass2.trim().length==0||email.trim().length==0)
    {
        alert("Please fill in the information.");
        return false;
    }
    else if(div=="This username has been used!"||!passwordIsValid()||!passwordIsSame()||!emailIsValid())
    {
        alert("Please fill in the correct information.")
        return false;
    }
    else
        return true;
}
