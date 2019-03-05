class Enemy{

    constructor(x,y){
        this.x=x;
        this.y=y;
        this.lastX = x;
        this.lastY = y;
        this.imgSrc='img1/cacciatore.jpg';
        this.timeout=1500;
        this.interval=null;
        this.player=null;
        this.playground=null;
    }
    followHim(){
        this.interval = setInterval(()=>{
            this.lastY=this.y;
            this.lastX=this.x;
            if(!this.player.armed){
                if (this.y < player.y && this.checkValid(this.x, this.y + 1)) {
                    this.y++;
                } else if (this.y > player.y && this.checkValid(this.x, this.y - 1)) {
                    this.y--;
                } else if (this.x < player.x && this.checkValid(this.x + 1, this.y)) {
                    this.x++;
                } else if (this.x > player.x && this.checkValid(this.x - 1, this.y)) {
                    this.x--;
                }
            }else {
                if (this.y < player.y && this.checkValid(this.x, this.y + 1)) {
                    if(this.y!==0){
                    this.y--;
                    }
                } else if (this.y > player.y && this.checkValid(this.x, this.y - 1)) {
                    if(this.y<this.playground.y-1){
                        this.y++;
                    }

                } else if (this.x < player.x && this.checkValid(this.x + 1, this.y)) {
                    if(this.x<playground.x-1) {
                        this.x++;
                    }
                } else if (this.x > player.x && this.checkValid(this.x - 1, this.y)) {
                    if(this.x!==0) {
                        this.x--;
                    }
                }
            }
            // console.log('last x :'+this.lastX + ' x: '+this.x);
            //console.log('last y :'+this.lastY + ' y: '+this.y);
            this.playground.setItem(this);

        }, this.timeout);

    }
    setPlayer(player){
        this.player=player;
    }
    setPlayground(playground){
        this.playground=playground;
    }
    stopFollow(){
        clearInterval(this.interval);
    }
     catchYou(){
        if(this.x===player.x && this.y===player.y) {
            console.log('il player è morto');
        }
    }
    checkValid(xCheck,yCheck){
        var checkValue = this.playground.getCellType(xCheck,yCheck);
        if(checkValue==='1'||checkValue==='7'){
            return false;
        }else{
            return true;
        }
    }
}