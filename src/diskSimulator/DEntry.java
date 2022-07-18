package src.diskSimulator;
import src.operators.convertElements;

public class DEntry {
    
    private short SNodeIdentifier; 
    private short EntryLenght; 
    private byte FileType; 
    private byte FileNameLength;
    private byte[] FileName;


    public DEntry(short SNodeIdentifier, short EntryLenght, byte FileType, byte FileNameLength, byte[] FileName) {
        this.SNodeIdentifier = SNodeIdentifier;
        this.EntryLenght = EntryLenght;
        this.FileType = FileType;
        this.FileNameLength = FileNameLength;
        this.FileName = FileName;


        //tem que garantir essas consistencia ai parça kkk
    
    }

    public byte[] convertDEntryInBytes(){
   
        
        byte[] SNodeByte = new byte[6+FileName.length];

        convertElements convert = new convertElements();

        byte[] shortElement = new byte[2];
        
        shortElement = convert.convertShortToBytes(SNodeIdentifier);

        SNodeByte[0] = shortElement[0];
        SNodeByte[1] = shortElement[1];
       
        shortElement = convert.convertShortToBytes(EntryLenght);

        SNodeByte[2] = shortElement[0];
        SNodeByte[3] = shortElement[1];
       
    
        SNodeByte[4] = FileType;
        SNodeByte[5] = FileNameLength;

        for(int i = 5 ; i< SNodeByte.length; i++){
            SNodeByte[i] = FileName[i];
        }

            
        return SNodeByte;
    }


}
