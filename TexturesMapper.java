package texturesmapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
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
            System.out.println("Enter game textures root directory that you wish to map");
            String dir = myObj2.nextLine();
            String yamldir = dir.replace("\\", "/");
            String subsdir = dir.replace("\\", "/");
            String outputpath = dir.replaceAll("textures.*", "");

            String sa = yamldir;
            String saa = subsdir;
            String[] split = sa.split("textures/");
            String[] split2 = saa.split("textures/");
            
            File subdir = new File(yamldir);
            String[] directories = subdir.list(new FilenameFilter() {
                @Override
                public boolean accept(File current, String name) {
                    return new File(current, name).isDirectory();
                }
            });

            String SSubString = split[1];
            String Subdirrr = split2[1];

            File file = new File(outputpath + "\\txtconfig\\" + EntCRC + ".yaml");

            FileOutputStream fos = new FileOutputStream(file);

            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            System.out.println("ProcessTEX: ");
            
            for (int i = 0; i < directories.length; i++) {
                System.out.println("  // " + directories[i]);
                String Subs = sa + "/" + directories[i];
                
            
                        String[] fileNames
                    = Files.list(Paths.get(Subs)).filter(
                            Files::isRegularFile).map(
                                    p -> p.toFile().getName()).toArray(String[]::new);
                
            for (String s : fileNames) {
                String str = s;
                String search = ".dds";
                int index = str.lastIndexOf(search);

                if (index > 0) {
                    str = str.substring(0, index);
                    ps = new PrintStream(fos);
                    System.setOut(ps);
                    System.out.println("  0x" + str + ": \"" + Subdirrr + "/" + directories[i] + "/" + s + '"');
                }
            }

            }
            System.out.println("  // Root");
            String[] fileNamesog
                    = Files.list(Paths.get(dir)).filter(
                            Files::isRegularFile).map(
                                    p -> p.toFile().getName()).toArray(String[]::new);

            for (String s : fileNamesog) {
                String str = s;
                String search = ".dds";
                int index = str.lastIndexOf(search);

                if (index > 0) {
                    str = str.substring(0, index);
                    ps = new PrintStream(fos);
                    System.setOut(ps);
                    System.out.println("  0x" + str + ": \"" + SSubString + "/" + s + '"');

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
