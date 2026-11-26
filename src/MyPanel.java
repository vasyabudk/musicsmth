import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class MyPanel extends JFrame implements MouseListener { // наследуемся от базовой панели

    ArrayList<ArrayList<Pixel>> wsq = new ArrayList<>();
    Pixel pixel = new Pixel(0,0);
    long ltime=0;
    public MyPanel() {
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();        // Обращаемся к стратегии буферизации
        if (bufferStrategy == null) {                               // Если она еще не создана
            createBufferStrategy(2);                                // то создаем ее
            bufferStrategy = getBufferStrategy();                   // и опять обращаемся к уже наверняка созданной стратегии
        }
        g = bufferStrategy.getDrawGraphics();                       // Достаем текущую графику (текущий буфер)
        g.clearRect(0, 0, getWidth(), getHeight());


        long time = System.currentTimeMillis();
        long dtime = time-ltime;
        ltime = time;
        System.out.println(dtime);
        for(int i=0;i<=380;i++){

            for(int j=0;j<=200;j++){
                pixel=wsq.get(i).get(j);
                g.setColor(pixel.Compute());
                if(pixel.light>0){

                pixel.Update();}


                g.fillRect(pixel.x,pixel.y,5,5);


            }
        }

        g.dispose();                // Освободить все временные ресурсы графики (после этого в нее уже нельзя рисовать)
        bufferStrategy.show();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0;i<=380;i++){

            for(int j=0;j<=200;j++){
                pixel=wsq.get(i).get(j);

                if((pixel.x-e.getX())*(pixel.x-e.getX())+(pixel.y-e.getY())*(pixel.y-e.getY())<=10000){
                    pixel.light+=255-((pixel.x-e.getX())*(pixel.x-e.getX())+(pixel.y-e.getY())*(pixel.y-e.getY()))/40;
                }

            }}
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
