package src.diskSimulator;
import java.lang.annotation.ElementType;

import src.operators.convertElements;

public class DEntry {
    
    private short SNodeIdentifier; 
    private short EntryLenght; 
    private byte FileType; 
    private byte FileNameLength;
    private byte[] FileName;


    private  SNode element; 


    public DEntry(short SNodeIdentifier, short EntryLenght, byte FileType, byte FileNameLength, byte[] FileName) {
        this.SNodeIdentifier = SNodeIdentifier;
        this.EntryLenght = EntryLenght;
        this.FileType = FileType;
        this.FileNameLength = FileNameLength;
        this.FileName = FileName;


        //tem que garantir essas consistencia ai parça kkk
    
    }



    public void allocatNewSNodeFile(byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01){
        element = new SNode(FileType, Generation, CreationDate, ModificationDate, DataBlock_01);
    }
    public void allocatNewSNodeFile(byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01, short DataBlock_02){
        element = new SNode(FileType, Generation, CreationDate, ModificationDate, DataBlock_01, DataBlock_02);
    }
    public void allocatNewSNodeFile(byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01, short DataBlock_02, short DataBlock_03){
        element = new SNode(FileType, Generation, CreationDate, ModificationDate, DataBlock_01, DataBlock_02, DataBlock_03);
    }
    public void allocatNewSNodeFile(byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01, short DataBlock_02, short DataBlock_03, short DataBlock_04){
        element = new SNode(FileType, Generation, CreationDate, ModificationDate, DataBlock_01, DataBlock_02, DataBlock_03, DataBlock_04);
    }

    public void allocatNewSNodeDir(byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01){
        element = new SNode(FileType, Generation, CreationDate, ModificationDate, DataBlock_01);
    }
    





    public int getSize(){
        return (int)FileNameLength+6;
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
