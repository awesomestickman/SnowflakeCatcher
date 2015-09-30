import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

Snowflake a = new Snowflake();
catcher [] line = new catcher[1000];
Snowflake [] storm;
int counter=0;
public void setup()
{
  //your code here
  size(300, 300);
  stormMaker();
  noStroke();
}
public void draw()
{
  background(0);
  for(int i = 0;i<line.length;i++){
    if(line[i] != null){
   line[i].show(); 
    }
  }
  for(int i = 0;i<storm.length;i++){
    
   storm[i].show(); 
    storm[i].move();
    storm[i].wrap();
    storm[i].lookDown();
  }
  
  a.show();
  a.move();
  a.wrap();
  a.lookDown();
  if(counter>997){
    text("you ran out of ink!",200,200);
  }
  //your code here
}
public void mouseDragged()
{
  //your code here
  fill(40,40,0);
  if(counter<line.length){
  line[counter]=new catcher(mouseX,mouseY);
  };
  counter++;
}
public void stormMaker()
{
  storm=new Snowflake[500];
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
  public void show(){
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
    isMoving=true;
    //class member variable initializations
  }
  public void show()
  {
    //your code here
    fill(255,255,255);
    ellipse(x, y, 5, 5);
  }
  public void lookDown()
  {
    
    //your code here
    if(y>0&&y<290){
      if(get(x,y+2) != color(0,0,0) && get(x,y+2) != color(255,255,255))
        isMoving=false;
    }
  }
  public void erase()
  {
    //your code here
    fill(255);
  }
  public void move()
  {
    //your code here
    if(isMoving==true){
      this.y++;
    }
  }
  public void wrap()
  {
    if(this.y>310){
      this.y=0;
      this.x=(int)(Math.random()*297+2);
    }
    //your code here
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
