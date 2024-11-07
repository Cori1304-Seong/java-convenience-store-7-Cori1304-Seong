package store.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {
    private String filePath;
    private String regex = ",";
    private String line;
    private String startsWith = "name";
    protected List<T> modelDataEntries = new ArrayList<>();

    public BaseRepository(String filePath, String regex, String startsWith) {
        this.filePath = filePath;
        this.regex = regex;
        this.startsWith = startsWith;
    }

    public BaseRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<T> loadDataFromMarkdown() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                addModelData(line, startsWith);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); //TODO View로 따로 분해 예정
        }
        return modelDataEntries;
    }

    private void addModelData(String _line, String startsWith) {
        if (_line.isEmpty() || _line.startsWith(startsWith)) {
            return;
        }
        String[] data = _line.split(regex);
        T instance = parseData(data);
        if (instance != null) {
            modelDataEntries.add(instance);
        }
    }

    /* Model마다 colum이 다르기 떄문에 파싱 기능은 저의 필요 */
    protected abstract T parseData(String[] data);
}
