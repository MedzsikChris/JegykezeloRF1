document.querySelector('#loginButton').addEventListener("click", function() {
    let user = document.querySelector('#email_address').value;
    localStorage.setItem("userName", user);
    alert("Sikeres Bejelentkezés!");
});


window.onload = function load() {

    console.log(localStorage.getItem("userName"));

}
