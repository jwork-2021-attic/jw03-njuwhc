package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;

import example.classloader.SteganographyClassLoader;

public class Scene {

    public static void main(String[] args) throws Exception {

        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        SteganographyClassLoader loader = new SteganographyClassLoader(
                //new URL("https://cdn.njuics.cn/example.BubbleSorter.png"));
                //new URL("file:////Users/wanghaochen/Desktop/jw03-njuwhc-main/example.BubbleSorter.png"));
                //new URL("file:////Users/wanghaochen/Desktop/jw03-njuwhc-main/example.QuickSorter.png"));
                //new URL("file:////Users/wanghaochen/Desktop/jw03-njuwhc-main/example.SelectionSorter.png"));
                new URL("file:////Users/wanghaochen/Desktop/jw03-njuwhc-main/example.ShellSorter.png"));
                

        //Class c = loader.loadClass("example.BubbleSorter");
        //Class c = loader.loadClass("example.QuickSorter");
        //Class c = loader.loadClass("example.SelectionSorter");
        Class c = loader.loadClass("example.ShellSorter");

        Sorter sorter = (Sorter) c.newInstance();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
