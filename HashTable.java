import java.util.ArrayList;
import java.util.List;

public class HashTable implements HashTableInterface {

    private Bucket[] array;
    private int size;
    private int max;

    HashTable(int initialSize){
        this.max = initialSize;
        this.size = 0;
        this.array = new Bucket[this.max];
    }
    public boolean put(String key, int value){
        if(key == null && value == 0){
            return false;
        }else if(this.array[HashFunction(key)].exists(key)){
            return false;
        } else{
            this.array[HashFunction(key)].setKey(key);
            this.array[HashFunction(key)].setValue(value);
            this.size++;
            return true;
        }
    }

    public String get(String key){
        if(!this.array[HashFunction(key)].exists(key)){
            return null;
        }

        return this.array[HashFunction(key)].key;

    }

    public int remove(String key){
        if(!this.array[HashFunction(key)].exists(key)){
            return -1;
        }

        int removedValue = array[HashFunction(key)].getValue();

        this.array[HashFunction(key)].setKey("null");
        this.array[HashFunction(key)].setValue(-1);
        this.size--;

        return removedValue;
    }

    public boolean containsKey(String key){
        if(key == null){
            return false;
        }

        for(int i = 0; i < this.max; i++){
            if(this.array[i].getKey() == key){
                return true;
            }
        }
        return false;
    }

    public List values(){
        List myList = new ArrayList();
        //int cursor = 0;
        for(int i = 0; i < this.max; i++){
            if(this.array[i].getKey() != null){
                myList.add(this.array[i].getValue());
            }
            //cursor++;
        }
        return myList;
    }

    public List keys(){
        List myList = new ArrayList();
        //int cursor = 0;
        for(int i = 0; i < this.max; i++){
            if(this.array[i].getKey() != null){
                myList.add(this.array[i].getKey());
            }
            //cursor++;
        }
        return myList;
    }

    int HashFunction(String key){
        return Integer.parseInt(key) % this.max;
    }
}

class Bucket {
    String key;
    int value;

    Bucket(){
        this.key = null;
        this.value = -1;
    }

    boolean exists(String key){
        return this.key == key;
    }

    void setKey(String key){
        this.key = key;
    }

    void setValue(int value){
        this.value = value;
    }

    String getKey(){
        return this.key;
    }

    int getValue(){
        return this.value;
    }
}