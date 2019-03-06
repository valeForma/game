class Playground {

    constructor( x , y,imgPath){
        this.x=x;
        this.y=y;
        this.matrix = [];
        this.imgPath=imgPath;
        this.backgroundDefault = imgPath+'bg.png';
     
    }
    generatePlayground(){
        for(var i=0 ;i<this.y;i++){
            this.matrix [i] = [];
            for(var j=0 ; j<this.x ;j++){
                var img=this.generateImage();
                this.matrix[i][j] =  img;
            }
        }
        this.dispose();
    }
    generateImage(){
        var img =new Image();
        //img.borderColor = balck;
        img.className = imgPath+'myImg';
        img.src = this.backgroundDefault;
        return img;
    }
    dispose(){
        document.getElementById('myGame').innerHTML='';
         var myTable = document.createElement("TABLE");
        
        myTable.className = "myTable";
        for(var i=0 ;i<this.y;i++){
             var myRow=myTable.insertRow();
            for(var j=0 ; j<this.x ;j++){
                var cell =myRow.insertCell();
                cell.appendChild(this.matrix[i][j]);
            }
        }
        document.getElementById('myGame').appendChild(myTable);

    }
    setItem(item){
        this.matrix[item.lastY][item.lastX].src =this.backgroundDefault;
        this.matrix[item.y][item.x].src=item.imgSrc;
    }
    rotateItem(item , angle){
        document.getElementsByClassName('myTable').rows[item.y].cells[item.x].rotate(angle); 
       
    }
    getCellType(x,y){
        //console.log('x pos: '+x+'y pos : '+y);
       var  imgsrc=this.matrix[y][x].src;
       //console.log(imgsrc);
        var regExString = new RegExp("(?:resources/img1/)(.*?)(?:.jpg)", "ig");
       imgsrc=regExString.exec(imgsrc)[1];
       //console.log(imgsrc);


        return imgsrc;
    }
}
