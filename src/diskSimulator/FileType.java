package src.diskSimulator;
import java.util.HashMap;

public class FileType {
    HashMap<String,Byte> TypeFileMap = new HashMap<>();

    public FileType(){
        this.TypeFileMap.put("Unknown",(byte)0b00000000);
        this.TypeFileMap.put("Regular",(byte)0b00000001);
        this.TypeFileMap.put("Directory",(byte)0b00000010);
        this.TypeFileMap.put("Character_Device",(byte)0b00000011);
        this.TypeFileMap.put("Block_Device",(byte)0b00000100);
        this.TypeFileMap.put("Fifo",(byte)0b00000101);
        this.TypeFileMap.put("Socket",(byte)0b00000110);
        this.TypeFileMap.put("Symbolic_Link",(byte)0b00000111);
    }

    public Byte get(String string) {
        return TypeFileMap.get(string);
    }
    
}