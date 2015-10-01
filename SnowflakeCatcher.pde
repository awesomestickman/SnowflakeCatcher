
catcher [] line = new catcher[500];
Snowflake [] storm;
int counter=0;
void setup()
{
  //your code here
  
  size(300, 300);
  background(0);
  stormMaker();
  noStroke();
}
void draw()
{
  background(0);
  for(int i = 0;i<line.length;i++){
   if(line[i] != null){
   line[i].show(); 
   }
 }
  for(int i = 0;i<storm.length;i++){
    storm[i].erase();
    storm[i].lookDown();
    storm[i].move();
    storm[i].wrap();
    storm[i].show();
    
  }
  
  
  if(counter>497){
    fill(220,220,220);
    text("you ran out of ink!",200,200);
  }
  //your code here
}
void mouseDragged()
{
  //your code here
  fill(40,40,0);
  if(counter<line.length){
  line[counter]=new catcher(mouseX,mouseY);
  };
  counter++;
}
void stormMaker()
{
  storm=new Snowflake[100];
  for(int i=0;i<storm.length;i++){
   storm[i]=new Snowflake(); 
  }
  
}
class catcher
{
  int x,y;
  catcher(int x,int y){
   this.x=x;
   this.y=y;

  }
  void show(){
    fill(157,157,162);
    ellipse(x,y,4,4);

  }
}

class Snowflake
{
  //class member variable declarations
  int x,y;
  boolean isMoving;
  Snowflake()
  {
    this.x=(int)(Math.random()*297+2);
    //this.y=0;
    this.y=(int)(Math.random()*297+2);
    //this.y=0;
    isMoving=true;
    //class member variable initializations
  }
  void show()
  {
    //your code here
    noStroke();
    fill(220,220,220);
    ellipse(x, y, 5, 5);
  }
  void lookDown()
  {
    
    //your code here
    if(y>0&&y<290){
      if(get(x,y+4) != color(0,0,0)){
        isMoving=false;
      }
      else{
        isMoving=true;
      }
    }
    
    
  }
  void erase()
  {
    //your code here
    fill(0,0,0);
    ellipse(x,y,8,8);
  }
  void move()
  {
    //your code here
    if(isMoving==true){
      this.y++;
    }
  }
  void wrap()
  {
    if(this.y>300){
      this.y=1;
      this.x=(int)(Math.random()*297+2);
    }
    //your code here
  }
}


