function validate(){
    var name = document.getElementById("name").value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var email = document.getElementById("email").value;
    var website = document.getElementById("website").value;
    var imagelink = document.getElementById("imagelink").value;

    var gender ="";
    var skill = "";
    if(document.getElementById('male').checked){
        gender=document.getElementById("male").value;
    }
   else if(document.getElementById('female').checked){
        gender=document.getElementById("female").value;
    }
    if(document.getElementById('java').checked){
        skill=skill+" "+document.getElementById("java").value;
    }
    if(document.getElementById('html').checked){
        skill=skill+" "+document.getElementById("html").value;
    }
    if(document.getElementById('css').checked){
        skill=skill+" "+document.getElementById("css").value;
    }
    if (name == null || name == "" || name.trim()=="") {
         alert("Please enter your name.");
         document.getElementsByClassName("message").innerHTML="Please fill it"
        return false;
    }
    else if (email == null || email == "" || !email.match(mailformat)) {
        alert("Something wrong with email.");
        return false;
    }
    else if (website == null || website == "") {
        alert("Please enter website.");
        return false;
    }
    else if (imagelink == null || imagelink == "") {
        alert("Please enter website.");
        return false;
    }
    else if (gender == null || gender == "") {
        alert("Please enter gender.");
        return false;
    }
    else if (skill == null || skill == "") {
        alert("Please enter skill.");
        return false;
    }

    return true;
}
function studentUpdate(){
    if(validate()){
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var website = document.getElementById("website").value;
    var imagelink = document.getElementById("imagelink").value;

    var gender;
    var skill = "";
    if(document.getElementById('male').checked){
        gender=document.getElementById("male").value;
    }
   else if(document.getElementById('female').checked){
        gender=document.getElementById("female").value;
    }
    if(document.getElementById('java').checked){
        skill=skill+" "+document.getElementById("java").value;
    }
    if(document.getElementById('html').checked){
        skill=skill+" "+document.getElementById("html").value;
    }
    if(document.getElementById('css').checked){
        skill=skill+" "+document.getElementById("css").value;
    }
    document.getElementById("body").innerHTML = document.getElementById("body").innerHTML +
    '<tr>'+"<td id='newData' class='animated fadeIn'><p><b>" + name + '</b><br>' + gender + '<br>' + email + '</p><a target="_blank" href ="' + website + '">' + website + ' </a><p>'
    + skill + '</p></td>' +
    "<td id='newData' class='animated fadeIn'>" + '<a href="' + $("#imagelink").val() + '" target="_blank">' + '<img src="'
    + $("#imagelink").val() + '" alt="Photo" title="Click to open in new tab" style="width:100%;height:100%"></a>' + "</td>" + "</tr>";
}
// formClear();
document.getElementById("clearForm").reset();
}
// function formClear(){

//     $("#name").val("");
//     $("#email").val("") ;
//     $("#website").val("") ;
//     $("#imagelink").val("");
//     document.getElementById("male").checked = false;
//     document.getElementById("female").checked = false;
//     document.getElementById("java").checked = false;
//     document.getElementById("html").checked = false;
//     document.getElementById("css").checked = false;

// }