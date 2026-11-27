import java.awt.*;
import java.util.ArrayList;

public class Pixel {
    int x;
    int y;
    int type=1;
    ArrayList<Double> color= new ArrayList<>();
    ArrayList<Double> colorPLayer= new ArrayList<>();
    double light = 0;
    // size=5x5

    Pixel(int gx,int gy){
        x=gx;
        y=gy;
        colorPLayer.add(100.0);
        colorPLayer.add(100.0);
        colorPLayer.add(100.0);
        if(40<=gx   &&  1500>=gx && 70<=gy && 860>=gy){
            color.add(100+25*Math.random());
            color.add(50.0);
            color.add(150+25*Math.random());
        }
        else {
            type =0;
            color.add(0.0);
            color.add(0.0);
            color.add(0.0);
        }



    }

    Color Compute(){
            if(type==2){type=1;
                return new Color((int) Math.floor(Math.min(255, colorPLayer.get(0) + light)),
                    (int) Math.floor(Math.min(255, colorPLayer.get(1) + light)),
                    (int) Math.floor(Math.min(255, colorPLayer.get(2) + light)));

            }
            return new Color((int) Math.floor(Math.min(255, color.get(0) + light)),
                    (int) Math.floor(Math.min(255, color.get(1) + light)),
                    (int) Math.floor(Math.min(255, color.get(2) + light)));


    }
    void Update(){
        light*=0.85;
        light=Math.max(0,light-2);

        if(light<0){light=0;}
    }



}
