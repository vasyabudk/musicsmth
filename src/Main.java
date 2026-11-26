import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        MyPanel frame = new MyPanel();
        ArrayList<Pixel> w =new ArrayList<>();
        ArrayList<ArrayList<Pixel>> wsq = new ArrayList<>();

        for(int i=0;i<=380;i++){
            w.clear();
            for(int j=0;j<=200;j++){
                w.add(new Pixel(i*5,j*5));
            }
            wsq.add(new ArrayList<>(w));
        }
        frame.wsq=wsq;

        // Создаем окно


        frame.setSize(1900, 1000);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            frame.repaint();
        }
    }
}