let base = 1000;
let kedvezmeny = 1;
let odaVissza = 1;
let osztaly = 1;
let userName = localStorage.getItem("userName");


document.querySelector('#kedvezmeny').addEventListener("change", function() {
    if (this.value === "nincs") {
        console.log('Nincs');
        kedvezmeny = 1;
    }else if (this.value === "nyugger"){
        console.log('Nyugger');
        kedvezmeny = 0.25;
    }else if (this.value === "diak"){
        console.log('Diák');
        kedvezmeny = 0.5;
    }else if (this.value === "vasutas"){
        console.log('Vasútas selected');
        kedvezmeny = 0;
    }
    updateAr();
});

document.querySelector('#jegy_vasarlo_gomb').addEventListener("mouseover", function() {
    document.querySelector('#kamu_ar').value = document.querySelector('#ar').value;

});

document.querySelector('#oda_vissza').addEventListener("change", function() {
    if(this.value === "igen") odaVissza = 1.5;
    else odaVissza = 1;

    updateAr();
});

document.querySelector('#kocsiosztaly').addEventListener("change", function() {
    if(this.value === "1") osztaly = 2;
    else osztaly = 1;
    updateAr();
});

function updateAr(){
    document.querySelector('#ar').value = ((base * odaVissza) * kedvezmeny) * osztaly;
}

document.querySelector('#jegy_vasarlo_gomb').addEventListener("mouseover", function() {
    updateAr();
    document.querySelector('#civ').value = localStorage.getItem("userName");
    console.log(localStorage.getItem("userName"));

});



function toJegyeim(){
    window.location.href = "/jegyeim/" + userName;
}

function toOffBerletek(){
    window.location.href = "/offline_berlet/" + userName;
}

window.onload = function load() {
    console.log(localStorage.getItem("userName"));
    updateAr();
}

