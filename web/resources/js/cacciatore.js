function Cacciatore(x, y, nome) {
	this.x = x; // posizione iniziale del cacciatore
	this.y = y; // posizione iniziale del cacciatore
	this.nome = nome; // proprietà utilizzata per caricare immagine del
	// cacciatore (es. blu.jpg)
}

Cacciatore.prototype.insegui1 = function() {

	var precX = this.x;
	var precY = this.y;

	var newX = this.x;
	var newY = this.y;
	
	if (this.y < ominoY) {
		newY = this.y + 1;
	}else
	if (this.y > ominoY) {
		newY = this.y - 1;
	}else
	if (this.x < ominoX) {
		newX = this.x + 1;
	}else
	if (this.x > ominoX) {
		newX = this.x - 1;
	}



	// adesso prima di spostare controlliamo che non ci sia un ostacolo nella
	// cella:

	if (piano[newX][newY] != OSTACOLO) {
		// assume la nuova posizione
		this.x = newX;
		this.y = newY;
		// si disegna il cacciatore nella nuova cella
		document.getElementById("c" + precX + "_" + precY).src = pathImg+piano[precX][precY]
				+ ".jpg";
		document.getElementById("c" + this.x + "_" + this.y).src = pathImg+this.nome
				+ ".jpg";
	}
	
	
} 


Cacciatore.prototype.insegui2 = function() {

	var precX = this.x;
	var precY = this.y;

	var newX = this.x;
	var newY = this.y;

	if (this.x < ominoX) {
		newX = this.x + 1;
	}else
	if (this.x > ominoX) {
		newX = this.x - 1;
	}else

	if (this.y < ominoY) {
		newY = this.y + 1;
	}else
	if (this.y > ominoY) {
		newY = this.y - 1;
	}

	// adesso prima di spostare controlliamo che non ci sia un ostacolo nella
	// cella:

	if (piano[newX][newY] != OSTACOLO) {
		// assume la nuova posizione
		this.x = newX;
		this.y = newY;
		// si disegna il cacciatore nella nuova cella
		document.getElementById("c" + precX + "_" + precY).src = pathImg+piano[precX][precY]
				+ ".jpg";
		document.getElementById("c" + this.x + "_" + this.y).src = pathImg+this.nome
				+ ".jpg";
	}

		// il this.nome coincide con il nome dell’immagine nel file system
		
		if (this.x == ominoX && this.y == ominoY) {
			gameOver();
		}

}

var c1 = new Cacciatore(9,9,"cacciatore");
var c2 = new Cacciatore(1,1,"cacciatore");
setInterval("c2.insegui2()",500);
setInterval("c1.insegui1()",1000);
