import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {
    int x=10;
    int y=10;
    double moveTimer=0.0;
    int velocityX=1;
    int velocityY=1;
    String key = new String();



    void Draw(ArrayList<ArrayList<Pixel>> w){
        for(int i=x;i<=x+3;i++){
            for(int j=y;j<=y+3;j++){
                w.get(i).get(j).type=2;
            }
        }
    }
    void Move(int keyCode,long dtime){
        moveTimer+=dtime;

        y+=velocityY;
        x+=velocityX;
        if(y<=14){y=14;}//        if(40<=gx   &&  1500>=gx && 70<=gy && 860>=gy){
        if(y>= 169){y=169;}
        if(x<=8){x=8;}
        if(x>= 297){x=297;}

        if(keyCode== KeyEvent.VK_A){velocityX=-1;}
        else if(keyCode == KeyEvent.VK_D){velocityX=1;}
        else {velocityX=0;}
        if(keyCode== KeyEvent.VK_S){velocityY=1;}
        else if(keyCode== KeyEvent.VK_W){velocityY=-1;}
        else{velocityY=0;}



    }


}
