package P3n.lp2g47.biblioteca.utils;

import java.io.*;

public class DataPersist<T> {

    private final String BASE_PATH;

    public DataPersist(String BASE_PATH) {
        this.BASE_PATH = BASE_PATH;
    }

    public void save(T obj, String fileName) throws IOException {
        String filePath = BASE_PATH + fileName;
        File file = new File(BASE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOut = new FileOutputStream(filePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
    }

    public T load(String fileName) throws IOException, ClassNotFoundException {
        String filePath = BASE_PATH + fileName;
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream in = new ObjectInputStream(file);
        return (T) in.readObject();
    }
}