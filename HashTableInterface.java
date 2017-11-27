import java.util.List;

public interface HashTableInterface {
    boolean put(String key, int value);
    String get(String key);
    int remove(String key);
    boolean containsKey(String key);
    List values();
    List keys();
}
