window.onload = function load() {

    if (localStorage.getItem("userName") == null){
        localStorage.setItem("userName", "guest");
    }
    console.log(localStorage.getItem("userName"));

}

function logout() {

    console.log("before: " + localStorage.getItem("userName"));
    localStorage.setItem("userName", "guest");
    console.log("after: " + localStorage.getItem("userName"));
    location.reload();
    alert("sikeres kijelentkezés")
}