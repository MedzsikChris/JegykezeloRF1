let update_button = document.getElementsByClassName('update_button');
let update_civ = document.getElementsByClassName('up_civ');
let update_kezdo_megallo = document.getElementsByClassName('up_kezdo_megallo');
let update_vegallomas = document.getElementsByClassName('up_vegallomas');
let update_kocsiosztaly = document.getElementsByClassName('up_kocsiosztaly');
let update_oda_vissza = document.getElementsByClassName('up_oda_vissza');
let update_ar = document.getElementsByClassName('up_ar');
let update_ervenyes_ettol = document.getElementsByClassName('up_ervenyes_ettol');
let update_ervenyes_eddig = document.getElementsByClassName('up_ervenyes_eddig');
let update_datum = document.getElementsByClassName('up_datum');
let update_kedvezmeny = document.getElementsByClassName('up_kedvezmeny');

for(let i = 0; i < update_button.length; i++) {
    (function(index) {
        update_button[index].addEventListener("click", function() {

            update_civ[index].value = document.getElementById("civ").value;
            update_kezdo_megallo[index].value = document.getElementById("kezdo_megallo").value;
            update_vegallomas[index].value = document.getElementById("vegallomas").value;
            update_kocsiosztaly[index].value = document.getElementById("kocsiosztaly").value;
            update_oda_vissza[index].value = document.getElementById("oda_vissza").value;
            update_ar[index].value = document.getElementById("ar").value;
            update_ervenyes_ettol[index].value = document.getElementById("ervenyes_ettol").value;
            update_ervenyes_eddig[index].value = document.getElementById("ervenyes_eddig").value;
            update_datum[index].value = document.getElementById("datum").value;
            update_kedvezmeny[index].value = document.getElementById("kedvezmeny").value;
        })
    })(i);
}

window.onload = function load(){
    console.log(localStorage.getItem("userName"));
}