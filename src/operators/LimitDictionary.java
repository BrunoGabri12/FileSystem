package src.operators;

import java.util.HashMap;

public class LimitDictionary {

    private int minFilePerBlock = 16; 
    private int maxFilePerBlock = 65536;
    private int blocksSize = 128;
    private int diskBlockSize = 128;
    private int sNodeSize = 28;



    HashMap<String,Integer> sizeDictionary = new HashMap<>();

    public LimitDictionary(){
        this.sizeDictionary.put("minFilePerBlock",16);
        this.sizeDictionary.put("maxFilePerBloc",65536);
        this.sizeDictionary.put("blocksSize",128);
        this.sizeDictionary.put("diskBlockSize",128);
        this.sizeDictionary.put("sNodeSize",28);
        this.sizeDictionary.put("FileType",1);
        this.sizeDictionary.put("Generation",1);
        this.sizeDictionary.put("CreationDate",8);  
        this.sizeDictionary.put("ModificationDate",8);  
        this.sizeDictionary.put("CreationDate",8);  
        this.sizeDictionary.put("Length",2);
        this.sizeDictionary.put("DataBlock",2);
        this.sizeDictionary.put("SNodeIdentifier",2);
        this.sizeDictionary.put("EntryLength",2);
        this.sizeDictionary.put("FileNameLength",1);

           
    }
   
    public int get(String string) {
        return sizeDictionary.get(string);
    }
}
