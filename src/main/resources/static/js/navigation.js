userName = localStorage.getItem("userName");

function toJegyeim(){
    window.location.href = "/jegyeim/" + userName;
}

function toOffBerletek(){
    window.location.href = "/offline_berlet/" + userName;
}

if (userName === "admin") {}
else document.getElementById("jegy_admin_nav").style.display = "none";

if (userName === "admin" || userName === "user") {}
else document.getElementById("jegyeim_nav").style.display = "none";

if (userName === "admin" || userName === "user") {}
else document.getElementById("berleteim_nav").style.display = "none";

console.log(userName);