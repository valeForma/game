//gestione dell'evento onkeydown:
function checkKeyDown(e) {
    e = e || window.event;
    switch (e.keyCode) {
        case 39:
            destra();
            break;
        case 40:
            giu();
            break;
        case 37:
            sinistra();
            break;
        case 38:
            su();
            break;
    }
    //alert ("The Unicode character code is: " + e.keyCode);   
}

// gestione dell'evento onkey press:
function checkKeyPress(event) {
    var chCode = ('charCode' in event) ? event.charCode : event.keyCode;

    switch (chCode) {
        case 100:
            destra();
            break;
        case 115:
            giu();
            break;
        case 97:
            sinistra();
            break;
        case 119:
            su();
            break;
    }
    //alert ("The Unicode character code is: " + chCode);   
}

function controllaNuovaPosizione() {
    // se la cella contiene pillola energia si incrementa il valore di energia,
    // si cambia il valore totale visualizzato
    // si sbianca la cella per dare l'impressione che l'omino abbia raccolto la pillola
    // infine si decrementa il contatore degli oggetti da raccogliere
    if (piano[ominoX][ominoY] == ENERGIA) {
        energia = energia + DELTA_ENERGIA;
        document.getElementById("energia").innerHTML = energia;
        piano[ominoX][ominoY] = SFONDO;
        countPillole--;
    }
    // se nella cella c'è l'arma allora il valore della immagine da visualizzare cambia
    if (ominoX == armaX && ominoY == armaY) {
        omino = ominoConSpada;
        disegnaOmino();
    }

    // se il contatore pillole è zero vuol dire che il giocatore le ha raccolte tutte.
    if (countPillole == 0) {
        document.getElementById("energia").innerHTML = "<img src=\"coppa.jpg\" >";

    }
}

function controllaCella(x, y) {
    switch (piano[x][y]) {
        case OSTACOLO:
            return false;
        case PILLOLA:
            energia = energia + DELTA_ENERGIA;
            document.getElementById("energia").innerHTML = energia;
            piano[x][y] = SFONDO;
            countPillole--;
            if (countPillole == 0) {
                document.getElementById("energia").innerHTML = "<img src=\"coppa.jpg\" >";
            }
            return true;
        case GROTTA:
            sposta(posX1, posY1, posX2, posY2);
            return true;
        default:
            return true;
    }


    return true;
}

function sposta(daX, daY, aX, aY) {
    if (controllaCella(aX, aY)) {
        var daSrc = "c" + daX + "_" + daY;
        var aSrc = "c" + aX + "_" + aY;
        console.log(daSrc + " " + aSrc);
        document.getElementById(daSrc).src = pathImg + piano[daX][daY] + ".jpg";
        //document.getElementById(aSrc).src = pathImg + omino + ".jpg";
        ominoX = aX;
        ominoY = aY;
        disegnaOmino();
    }
}

function su() {
    var newX = (ominoX - 1 + R) % R;
    sposta(ominoX, ominoY, newX, ominoY);
}

function sinistra() {
    var newY = (ominoY - 1 + C) % C;
    sposta(ominoX, ominoY, ominoX, newY);
}

function giu() {
    var newX = (ominoX + 1 + R) % R;
    sposta(ominoX, ominoY, newX, ominoY);
}

function destra() {
    var newY = (ominoY + 1 + C) % C;
    sposta(ominoX, ominoY, ominoX, newY);
}