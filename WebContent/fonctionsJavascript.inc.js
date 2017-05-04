function gotoUrl($url) {
    window.location = $url;
}

// validation inscription
function validerInscription()
{
    var ok = 1;
    nom = document.getElementById('nom');
    prenom = document.getElementById('prenom');
    mail = document.getElementById('mail');
    tel = document.getElementById('tel');
    login = document.getElementById('login');
    mdp = document.getElementById('mdp');

    //NOM
    if (nom.value == "" || nom.value.length < 2)
    {
        nom.style.outline = 'red auto 5px';
        ok = 0;
        nom.focus();
        return false;
    } else {
        nom.style.outline = 'green auto 5px';
    }
    //PRENOM
    if (prenom.value == "" || prenom.value.length < 2)
    {
        prenom.style.outline = 'red auto 5px';
        ok = 0;
        document.getElementById('prenom').focus();
        return false;
    } else {
        prenom.style.outline = 'green auto 5px';
    }
    //EMAIL
    var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');
    if (mail.value == "")
    {
        mail.style.outline = 'red auto 5px';
        ok = 0;
        mail.focus();
        return false;
    } else if (reg.test(mail.value) === false)
    {
        mail.style.outline = 'red auto 5px';
        ok = 0;
        mail.focus();
        return false;
    } else {
        mail.style.outline = 'green auto 5px';
    }
    //TELEPHONE
    if (tel.value == "")
    {
        tel.style.outline = 'red auto 5px';
        ok = 0;
        tel.focus();
        return false;
    }
    if (isNaN(tel.value))
    {
        tel.style.outline = 'red auto 5px';
        ok = 0;
        tel.focus();
        return false;
    }
    if ((tel.value.length > 10) || (tel.value.length < 10))
    {
        tel.style.outline = 'red auto 5px';
        ok = 0;
        tel.focus();
        return false;
    } else {
        tel.style.outline = 'green auto 5px';
    }
    //LOGIN
    if (login.value == "")
    {
        login.style.outline = 'red auto 5px';
        ok = 0;
        login.focus();
        return false;
    } else {
        login.style.outline = 'green auto 5px';
    }
    //PASSWORD
    if (mdp.value == "")
    {
        mdp.style.outline = 'red auto 5px';
        ok = 0;
        mdp.focus();
        return false;
    }
    if (mdp.value.length < 7)
    {
        mdp.style.outline = 'red auto 5px';
        ok = 0;
        mdp.focus();
        return false;
    } else {
        mdp.style.outline = 'green auto 5px';
    }
    //CHECK PASSWORD
    if (mdp2.value == "")
    {
        mdp2.style.outline = 'red auto 5px';
        ok = 0;
        mdp2.focus();
        return false;
    }
    if ((mdp.value) != (mdp2.value))
    {
        mdp2.style.outline = 'red auto 5px';
        ok = 0;
        mdp2.focus();
        return false;
    } else {
        mdp2.style.outline = 'green auto 5px';
    }

    if (ok == 1) {
        document.submit();
    }
}
