/*!
    * Start Bootstrap - SB Admin v7.0.4 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
//
var nmLine = 1;
var firstAjout = true;
function copyLine(){
    var line = document.getElementById("ligne0");

    var table = document.getElementById("gestionLine");
    var clone = line.cloneNode(true);
    var produit = clone.children[0].children[0];

    var sstotal = clone.children[2].children[0];
    var supprButton = clone.children[4].children[0];
    supprButton.id = nmLine;
    var inst = nmLine;
    produit.onchange = function() {UpdatePrixUnitaire("produit" + inst);};
    sstotal.onchange = function() {UpdatePrixSoustotal("produit" + inst);};
    supprButton.onclick = function() {supprLine(inst);};
    produit.id = "produit" + nmLine;
    clone.id = "ligne" + nmLine;

    nmLine ++;
    table.appendChild(clone);

    if (firstAjout){
        firstAjout = false;
        table.removeChild(table.childNodes[0]);
        table.removeChild(table.childNodes[1]);
    }
    UpdatePrixUnitaire("produit" + inst);


}

function supprLine(numLine) {
    if (numLine > 0 ){
        var table = document.getElementById("gestionLine");
        var goodRow = 0;
        while(table.children[goodRow].id.localeCompare("ligne" + numLine) != 0){
            goodRow = goodRow + 1;
        }

        table.removeChild(table.childNodes[goodRow ]);
        UpdateTotalHT;

    }


}
function UpdatePrixUnitaire(produitID) {
    var table = document.getElementById("gestionLine");
    var idP = produitID.slice(7);
    var goodRow = 0;
    while(table.children[goodRow].id.localeCompare("ligne" + idP) != 0){
        goodRow = goodRow + 1;
    }
    var optionSelected = document.getElementById("produit" + goodRow).options[document.getElementById("produit" + goodRow).options.selectedIndex].id;
    table.children[goodRow].children[1].innerHTML = optionSelected + " €";
    UpdatePrixSoustotal(produitID);
}

function UpdatePrixSoustotal(produitID){
    var table = document.getElementById("gestionLine");
    var idP = produitID.slice(7);
    var goodRow = 0;
    while(table.children[goodRow].id.localeCompare("ligne" + idP) != 0){
        goodRow = goodRow + 1;
    }
    var optionSelected = document.getElementById("produit" + goodRow).options[document.getElementById("produit" + goodRow).options.selectedIndex].id;
    var sstotal = optionSelected * table.children[goodRow].children[2].children[0].value;
    table.children[goodRow].children[3].innerHTML = sstotal + " €" ;
    UpdateTotalHT();


}

function UpdateTotalHT(){
    var table = document.getElementById("gestionLine");
    var total = 0;
    for (i=0; i<table.children.length;i++){
        var lane = table.children[i];
        var a =parseFloat(total);
        var b = parseFloat(lane.children[3].innerHTML.slice(0,lane.children[3].innerHTML.length -1 ));
        total = a + b;
    }


    var totalHT = document.getElementById("totalHT");

    totalHT.innerHTML = total + " €";

}



window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');

    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });

    }

});



