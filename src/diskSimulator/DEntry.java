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


        if(FileName.length> 122){
            System.out.println("Nome do elemento maior do que o máximo estipulado");
        }
    
    }

    public short getSNodeIdentifier(){
        return this.SNodeIdentifier;
    }
    public short getEntryLenght(){
        return this.EntryLenght;
    }
    public byte getFileType(){
        return this.FileType;
    }
    public byte getFileNameLength(){
        return this.FileNameLength;
    }
    public byte[]getFileName(){
        return this.FileName;
    }



    public DEntry(byte[] DEntryElement){

        convertElements operator = new convertElements();

        this.SNodeIdentifier = operator.convertByteToShort(operator.concatInArry(DEntryElement, 0, 2));
        this.EntryLenght = operator.convertByteToShort(operator.concatInArry(DEntryElement, 2, 4));
        this.FileType = DEntryElement[4];
        this.FileNameLength= DEntryElement[5];
        this.FileName = operator.concatInArry(DEntryElement, 5, DEntryElement.length);

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
