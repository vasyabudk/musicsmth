import java.awt.*;
import java.util.ArrayList;

public class Pixel {
    int x;
    int y;
    ArrayList<Double> color= new ArrayList<>();
    double light = 0;
    // size=5x5

    Pixel(int gx,int gy){
        x=gx;
        y=gy;
        color.add((double) x/25);
        color.add((double) y/25);
        color.add(20.0);




    }
    Color Compute(){
        return new Color(   (int) Math.floor(Math.min(255,color.get(0)+light)),
                            (int) Math.floor(Math.min(255,color.get(1)+light)),
                            (int) Math.floor(Math.min(255,color.get(2)+light)));
    }
    void Update(){
        light*=0.85;
        light=Math.max(0,light-2);

        if(light<0){light=0;}
    }



}
