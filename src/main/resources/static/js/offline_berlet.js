userName = localStorage.getItem("userName");


if('caches' in window) {
    caches.open('berlet_cache').then(function(cache) {
        cache.addAll(['/offline_berlet/' + userName, '/assets/image.png']).then(function() {});
        console.log("Cache successfully created!")
    });
}

function deleteCache() {
    caches.delete('berlet_cache').then(function () {
        cacheDate.innerHTML= "Cache successfully deleted!"
    });
}

window.onload = function load(){
    console.log(localStorage.getItem("userName"));
    document.querySelector('#lastUpdateDate').innerHTML = "Last cache update: \n" + Date();
}