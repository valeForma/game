class Player {

    constructor(x,y,life){
        this.x = x;
        this.y = y;
        this.lastX = x;
        this.lastY = y;
        this.imgSrc = imgPath+'/omino.jpg' ;
        this.armed=false;
        this.score=0;
        this.life = life;
        this.energy = 10;
        this.gems = 0;
    }

    updatePlayer(){
        this.lastX = this.x;
        this.lastY = this.y;
    }

}