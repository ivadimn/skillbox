import java.io.*;
import java.nio.file.*;

public class Loader {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к папке откуда будут копироваться файлы : ");
        String pathFrom = reader.readLine();
        System.out.println("Введите путь к папке куда будут копироваться файлы : ");
        String pathTo = reader.readLine();
        copyFiles2(pathFrom, pathTo);
    }


    // копирование с использование пакета nio
    public static void copyFiles(String source, String target) throws IOException {
        if (!Files.exists(Paths.get(source))) {
            System.out.println("Нет такого файла или каталога : " + source);
            return;
        }
        if (!Files.exists(Paths.get(target))) {
            Files.createDirectory(Paths.get(target));
        }

        if (Files.isDirectory(Paths.get(source))) {
            File[] fileList = new File(source).listFiles();
            for (File f : fileList) {
                if (f.isDirectory()) {
                    copyFiles(f.getPath(), target + "/" + f.getName());
                } else {
                    System.out.println(source + "/" + f.getName() + " --> " + target);
                    Files.copy(Paths.get(source + "/" + f.getName()), Paths.get(target + "/" + f.getName()),
                            StandardCopyOption.REPLACE_EXISTING);

                }
            }
        }
        else {
            File f = new File(source);
            System.out.println(source + " --> " + target + "/" + f.getName());
            Files.copy(Paths.get(source), Paths.get(target + "/" + f.getName()),
                            StandardCopyOption.REPLACE_EXISTING);
        }
    }

    //другой способ без использования пакета nio
    public static void copyFiles2(String source, String target) throws IOException {

        File fileSource = new File(source);
        if (!fileSource.exists()) {
            System.out.println("Нет такого файла или каталога: " + source);
            return;
        }
        File fileTarget = new File(target);
        if (!fileTarget.exists()) {
            fileTarget.mkdir();
        }

        if (!fileSource.canRead()) {
            System.out.println("Не хватает прав на чтение файла - " + fileSource.getPath());
            return;
        }
        if (fileSource.isDirectory()) {
            File[] fileList = fileSource.listFiles();
            for (File f : fileList) {
                if (f.isDirectory()) {
                    copyFiles2(f.getPath(), target + "/" + f.getName());
                } else {
                    System.out.println(source + "/" + f.getName() + " --> " + target);
                    copy(source + "/" + f.getName(), target + "/" + f.getName());
                }
            }
        }
        else {
            File f = new File(source);
            System.out.println(source + " --> " + target + "/" + f.getName());
            copy(source, target + "/" + f.getName());
        }
    }

    //другой способ копирования
    public static void copy(String source, String target) {
        FileInputStream from = null;
        FileOutputStream to = null;
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        try {
            from = new FileInputStream(source);
            to = new FileOutputStream(target);
            while ((bytesRead = from.read(buffer)) != -1) {
                to.write(buffer, 0, bytesRead);
            }
            to.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (from != null) from.close();
                if (to != null) to.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }

        }

    }
}
