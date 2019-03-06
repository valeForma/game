var playgroundX=20;
var playgroundY=10;
var playground = null;
var player = null;
var enemies =[];
var level= new Level();
var imgPath="resources/img1/";
var intervalItems=null;
var checkInterval=null;
var catchInterval=null;
var gameStatus='STOPPED';
var audioIniziale=new Audio(URL=imgPath+"sound2.wav");
var audioMonete=new Audio(URL=imgPath+"moneta.wav");
var endAudio= new Audio(URL=imgPath+"gameover3.wav")
var playerArmedInterval=null;


itemsType =['GEM','OBSTACLE','ENERGYMINUS','ENERGYPLUS','LIFEUP','LIFEDOWN','ARMED','EXIT'];






function clickMove(button){
//console.log(button);
console.log(button.target.id);
var pressed = button.target.id;
    if(gameStatus==='STOPPED' || gameStatus==='PAUSED' ){
        return;
    }


    switch (pressed) {
        //move left
        case 'left':{
            ////console.log('moving left');
            if(this.player.x !== 0 && checkPlayerValidity(this.player.x -1, this.player.y)){
                if(!this.player.armed){
                this.player.imgSrc='img1/ominoS.jpg';
                }
                this.player.updatePlayer();
                this.player.x--;
            }
          break;
        }
        //move right
        case 'right':{
            ////console.log('moving right');
            if(this.player.x < this.playgroundX-1 && checkPlayerValidity(this.player.x +1, this.player.y)){
                if(!this.player.armed){
                this.player.imgSrc='img1/ominoD.jpg';
                }
                this.player.updatePlayer();
                this.player.x++;
            }
            break;
        }
        //move up
        case 'up':{
           // //console.log('moving up');
            if(this.player.y !== 0 && checkPlayerValidity(this.player.x, this.player.y-1)) {
                this.player.updatePlayer();
                this.player.y--;
            }
            break;
        }
        //move down
        case 'down':{
            ////console.log('moving down');
            if(this.player.y !== this.playgroundY-1 && checkPlayerValidity(this.player.x , this.player.y+1)){
                this.player.updatePlayer();
                this.player.y++;
            }
            break;
        }
        default:{
            ////console.log(pressed);
            break;
        }
    }
    this.checkCell(this.player.x,this.player.y);
    this.playground.setItem(this.player);
}

document.addEventListener('keydown', (event) => { //arrow function
    var pressed = event.keyCode;
    if(gameStatus==='STOPPED' || gameStatus==='PAUSED' ){
        return;
    }

    switch (pressed) {
        //move left
        case 37:{
            ////console.log('moving left');
            if(this.player.x !== 0 && checkPlayerValidity(this.player.x -1, this.player.y)){
                if(!this.player.armed){
                this.player.imgSrc='img1/ominoS.jpg';
                }
                this.player.updatePlayer();
                this.player.x--;
            }
          break;
        }
        //move right
        case 39:{
            ////console.log('moving right');
            if(this.player.x < this.playgroundX-1 && checkPlayerValidity(this.player.x +1, this.player.y)){
                if(!this.player.armed){
                this.player.imgSrc='img1/ominoD.jpg';
                }
                this.player.updatePlayer();
                this.player.x++;
            }
            break;
        }
        //move up
        case 38:{
           // //console.log('moving up');
            if(this.player.y !== 0 && checkPlayerValidity(this.player.x, this.player.y-1)) {
                this.player.updatePlayer();
                this.player.y--;
            }
            break;
        }
        //move down
        case 40:{
            ////console.log('moving down');
            if(this.player.y !== this.playgroundY-1 && checkPlayerValidity(this.player.x , this.player.y+1)){
                this.player.updatePlayer();
                this.player.y++;
            }
            break;
        }
        default:{
            ////console.log(pressed);
            break;
        }

    }
    this.checkCell(this.player.x,this.player.y);
    this.playground.setItem(this.player);
    //console.log('player stats :  life:'+player.life+ ' gems : '+player.gems+ ' energy: '+player.energy)
});
function clearAll(){//clearing all interval
    this.enemies.forEach((e)=>{
        e.stopFollow();
    });
    if(this.intervalItems!=null){
        //console.log('items intervals remouved');
        clearInterval(intervalItems);
    }
    if(this.checkInterval!=null){
        clearInterval(checkInterval);
    }
    if(this.catchInterval!=null){
        clearInterval(this.catchInterval);
    }
    if(this. playerArmedInterval!=null){
        clearInterval( playerArmedInterval);
    }
    this.enemies=[];
}
function setGame() {

    document.getElementById('resetButton').hidden=true;
    document.getElementById('gameStatus').hidden=true;

    clearAll();
    playground = new Playground(playgroundX ,playgroundY,imgPath);
    if(player===null) {
        player = new Player(0, 0, 3);
    }else{
        player.x=0;
        player.y=0;
        player.gems=0;

    }
    document.getElementById("progBar").style.width=this.player.energy+"%";
    this.playground.generatePlayground();
    document.getElementById("gameButton").hidden=false;
    gameStatus='STOPPED';
    //this.playground.matrix[0][0].src='img1/1.jpg';
}
function startGame(){

    this.audioIniziale.play();
    playground.setItem(player);
    this.createEnemies();
    this.generateItem();
    this.checkCatch();
    if(level.levelNum ===1){
        document.getElementById('levelIco').innerText='looks_one';
    }
    else if (level.levelNum ===2){
        document.getElementById('levelIco').innerText = 'looks_two';
    }
    else {
        document.getElementById('levelIco').innerText='looks_'+this.level.levelNum;
    }
    document.getElementById("gameButton").innerText='start level '+this.level.levelNum;
    document.getElementById('gameStatus').hidden=false;
    gameStatus='PLAYING';

}
function resetGame(){

    this.level=new Level();
    player = new Player(0,0, 3);
    document.getElementById("gameButton").innerText='start game ';
    setGame();
    this.audioIniziale.pause();
    this.audioIniziale.currentTime=0.0;
}
function ToggleGamePaused(){
    if(gameStatus==='PAUSED'){
        gameStatus='PLAYING';
    }
    else{
        gameStatus='PAUSED';
    }
}
function nextLevel(){
    setGame();
    this.level.upLevel();
    document.getElementById("gameButton").innerText='start level '+this.level.levelNum;
    document.getElementById('levelIco').innerText='looks_'+this.level.levelNum;

}

function generateItem(){
    this.intervalItems =setInterval(() =>{
        var xVal= Math.floor(Math.random() * playgroundX);
        var yVal = Math.floor(Math.random() * playgroundY);
        var typeNum = Math.floor(Math.random() * this.itemsType.length-1);
        if(typeNum<0){
            typeNum=0;
        }
        console.log('type num :' +typeNum);
        if(gameStatus==='PLAYING'){
            var newItem= new Items(xVal,yVal,this.itemsType[typeNum]);
            //console.log('new item generated');
            //console.log(newItem);
            this.playground.setItem(newItem);
            this.playground.setItem(this.player);
        }
    },this.level.itemsInterval);
}
function updateStats(){
    document.getElementById('lifesValue').innerText=this.player.life ;
    document.getElementById('gemsValue').innerText=this.player.gems+'/'+this.level.gemToPick;
    document.getElementById('score').innerText=this.player.score;


}
function checkCell(x,y){
   // console.log(this.playground.getCellType(x,y));
    var cellType=this.itemsType[+this.playground.getCellType(x,y)];
    //console.log(cellType);
    switch(cellType){
        case 'GEM':{


            this.player.gems++;
            this.audioMonete.play();

            if(this.player.gems === this.level.gemToPick){
                console.log('next level');
                clearInterval(intervalItems);
                var xVal= Math.floor(Math.random() * playgroundX);
                var yVal = Math.floor(Math.random() * playgroundY);
                var newItem= new Items(xVal,yVal,this.itemsType[this.itemsType.length-1]);

                this.playground.setItem(newItem);
            }
            break;
        }
        case 'OBSTACLE':{

            break;
        }
        case 'ENERGYMINUS':{
            decreaseEnergy();
            break;
        }
        case 'ENERGYPLUS':{
            increaseEnergy();
            break;
        }
        case 'LIFEUP':{
            this.player.life++;
            break;
        }
        case 'LIFEDOWN':{
            this.player.life--;
            if(this.player.life===0){
                showMessager('failDiv','GAME OVER!!!!!!  Your score is  '+this.player.score);
                this.endAudio.play();
                resetGame();
            }
            break;
        }
        case 'ARMED':{

            console.log('spada generata');
            this.player.armed=true;
            this.player.imgSrc=imgPath+'bad.jpg';
            playerArmedInterval = setInterval(()=>{
                var rotation=45;
                this.enemies.forEach((e)=>{
                    this.playground.rotateItem(e,rotation)
                })
                if(rotation>0){
                    roatation=rotation-90;
                }else{
                    rotation=rotation+90;
                }
            },500);

            setTimeout(()=>{
                this.player.armed=false;
                clearInterval(this.playerArmedInterval);
                this.player.imgSrc=imgPath+'omino.jpg';
            },this.level.armedTime);


            break;
        }
        case 'EXIT':{
            console.log('start next level');
            if(this.level.levelNum==10){
                showMessager('successDiv','you won the  game your score is  '+this.player.score );
                resetGame();
            }
            else{
                showMessager('successDiv','congratulation  level '+this.level.levelNum +' completed!!!!!!');
                nextLevel();
            }



            break;
        }
        default :{
           break;
        }
    }

}



function  increaseEnergy (){
    this.player.energy+=this.level.energyIncrease;
    this.player.score+=this.level.energyIncrease;

    if(this.player.energy>100){
        this.player.energy=100;
    }
    document.getElementById("progBar").style.width=this.player.energy+"%";
}
function  decreaseEnergy (){
    this.player.energy-=this.level.energyDecrese;
    this.player.score-=this.level.energyDecrese;
    if(this.player.energy< 0){
        this.player.life--;
        setGame();
    }
    document.getElementById("progBar").style.width=this.player.energy+"%";
}

function checkCatch(){

    this.catchInterval=setInterval(()=>{
        var deadPos=-1;
        updateStats();
        this.enemies.forEach((e,index)=> {
            if(e.x===this.player.x && e.y===this.player.y){
                if(this.player.armed){
                   deadPos=index;

                }else{

                this.player.life--;
                if(this.player.life===0){
                    showMessager('failDiv','GAME OVER!!!!!! \n Your score is  '+this.player.score);
                    resetGame();
                }
                else {
                    showMessager('failDiv','You are Dead !!!!!!!!!!');

                    this.setGame();
                }
                }
            }
            else{
                this.player.score+=this.level.scoreSurviveIncrese;
            }
        });
        if(deadPos!==-1){
            this.enemies[deadPos].stopFollow();
            this.enemies.splice(deadPos,1);
            this.player.armed=false;
            this.player.imgSrc=imgPath+'omino.jpg';

            setTimeout(()=>{
                this.enemies.push(createEnemy());
            }, this.level.enemyRegenerationTime);

        }
    },100);
}

function createEnemy(){
    var xEnemy=0;
    var yEnemy=0;
    var coordinateOk=true;
    do {
        xEnemy = Math.floor(Math.random() * (playgroundX / 2)) + Math.floor(playgroundX / 3);
        yEnemy = Math.floor(Math.random() * (playgroundY / 2)) + Math.floor(playgroundY / 3);
        enemies.forEach((e)=>{
           if(xEnemy === e.x && yEnemy === e.y){
                coordinateOk=false;
           }
        });
    }while (!coordinateOk);
    var e=new Enemy(xEnemy,yEnemy);
    e.setPlayground(this.playground);
    e.setPlayer(this.player);
    e.timeout=this.level.enemySpeed;
    e.followHim();

    this.playground.setItem(e);
    return e;
}




function createEnemies(){
    for(var i=0; i<this.level.enemyNum; i++){

        enemies.push(createEnemy());
    }
}
function  checkPlayerValidity(xCheck,yCheck){
    var checkValue = this.playground.getCellType(xCheck,yCheck);
    if(checkValue==='1'){
        return false;
    }else{
        return true;
    }
}
function showMessager(type,message){

    var messagerDiv=document.getElementById('messagerDiv');
    messagerDiv.className=type;
    messagerDiv.innerText=message;
    var imgFinale= new Image();
    if(message.includes('You are Dead')){
        imgFinale.src= imgPath+'imgfin.jpg';
    }   else if(message.includes('congratulation')){
             imgFinale.src= imgPath+'win.jpg';
        }

    messagerDiv.appendChild(imgFinale);
    messagerDiv.hidden=false;
    setTimeout(()=>{
        messagerDiv.hidden=true;
    },2000);
}
