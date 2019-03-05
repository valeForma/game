class Level {
     constructor(){
         this.levelNum=1;
         this.gemToPick=5;
         this.enemySpeed=1500;
         this.itemsInterval=5000;
         this.energyIncrease=10;
         this.energyDecrese=10;
         this.enemyNum=1;
         this.armedTime=5000;
         this.scoreSurviveIncrese=1;
         this.enemyRegenerationTime=3000;

     }
     upLevel(){
         this.levelNum+=1;
         this.gemToPick+=2;
         if(this.enemySpeed>=200){
             this.enemySpeed-=100;
         }

         this.itemsInterval+=100;
         if(this.energyIncrease > 15) {
             this.energyIncrease -= 5;
         }
         if(this.energyDecrese<=10) {
             this.energyDecrese -= 10;
         }
         this.enemyNum+=1;
         this.armedTime-=500;
         if(this.armedTime<=5000){
             this.armedTime=5000;
         }
         this.scoreSurviveIncrese*=2;
         this.enemyRegenerationTime-=500;
     }

     
}
