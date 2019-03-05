class Items {
    constructor(x, y,type) {
        this.x = x;
        this.y = y;
        this.lastX = x;
        this.lastY = y;
        this.type=type;
        this.setImage();

    }
    setImage(){
        switch(this.type){

            case 'GEM':{
                this.imgSrc = imgPath+'0.jpg';
                break;
            }
            case 'OBSTACLE':{
                this.imgSrc = imgPath+'1.jpg';
                break;
            }
            case 'ENERGYMINUS':{
                this.imgSrc = imgPath+'2.jpg';
                break;
            }
            case 'ENERGYPLUS':{
                this.imgSrc = imgPath+'3.jpg';
                break;
            }
            case 'LIFEUP':{
                this.imgSrc = imgPath+'4.jpg';
                break;
            }
            case 'LIFEDOWN':{
                this.imgSrc = imgPath+'5.jpg';
                break;
            }
            case 'ARMED': {
                this.imgSrc = imgPath+'6.jpg';
                break;
            }
            case 'EXIT': {
                this.imgSrc = imgPath+'7.jpg';
                break;
            }

            default :{
                return;
            }
        }

    }

}