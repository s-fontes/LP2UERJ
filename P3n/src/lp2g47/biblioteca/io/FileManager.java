package lp2g47.biblioteca.io;

import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;
import lp2g47.biblioteca.selector.Selector;

import java.io.File;
import java.io.FileNotFoundException;

public final class FileManager {
    public static File getFolderFile(String folder, String title, String message) throws FileNotFoundException, ExitApplication, Return {
        File[] files = readFolder(folder);
        Selector<File> selector = new Selector<>(files, title, message);
        return selector.select();
    }

    public static File[] readFolder(String folder) throws FileNotFoundException {
        File folderFile = new File(folder);
        if (!folderFile.exists()) {
            throw new FileNotFoundException("Pasta não encontrada");
        }
        File[] files = folderFile.listFiles();
        if (files == null || files.length == 0) {
            throw new FileNotFoundException("Pasta vazia");
        }
        return files;
    }
}
