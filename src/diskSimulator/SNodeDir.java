package src.diskSimulator;

public class SNodeDir extends SNode {

    private DEntry[] elementInDirectory ;


    public SNodeDir(byte FileType, byte Generation, long CreationDate, long ModificationDate,short DataBlock_01) {
        
        super(FileType, Generation, CreationDate, ModificationDate, DataBlock_01);
      
    }


    public void creatNewDEntry (short SNodeIdentifier, short EntryLenght, byte FileType, byte FileNameLength, byte[] FileName){
        DEntry element = new DEntry(SNodeIdentifier, EntryLenght, FileType, FileNameLength, FileName);

        if(element.getSize()<128 && getSizeDEntryVector()+ element.getSize() <128){
            elementInDirectory.add(element); //tenho que pensar como resolver isso 
        }
    }


    public void  createNewFile (byte FileType,byte Generation, long CreationDate, long ModificationDate, short DataBlock_01){
        
    }

    private int getSizeDEntryVector(){
        int size = 0; 

        for(int i=0;i<elementInDirectory.length;i++){
            size += elementInDirectory[i].getSize();
        }

        return size; 
        
    }
    
}
