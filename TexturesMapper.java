package texturesmapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

//@author Talal
public class TexturesMapper {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter ps2 game name in CRC32 format");
            String EntCRC = myObj.nextLine();
            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter game textures directory that you wish to load");
            String dir = myObj2.nextLine();
            String yamldir = dir.replace("\\", "/");

            String sa = yamldir;
            String[] split = sa.split("textures/");
            String firstSubString = split[0];
            String secondSubString = split[1];

            File file = new File(EntCRC + ".yaml");
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            System.out.println("ProcessTEX: ");
            String[] fileNames
                    = Files.list(Paths.get(dir)).filter(
                            Files::isRegularFile).map(
                                    p -> p.toFile().getName()).toArray(String[]::new);
            char star = '"';

            for (String s : fileNames) {

                String str = s;
                String search = ".dds";
                int index = str.lastIndexOf(search);

                if (index > 0) {
                    str = str.substring(0, index);
                    ps = new PrintStream(fos);
                    System.setOut(ps);
                    System.out.println("  0x" + str + ": \"" + secondSubString + "/" + s + star);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
