package src.diskSimulator;

public class SNodeFile extends SNode {

    public SNodeFile(Byte FileType, Byte Generation, long CreationDate, long ModificationDate, short Length,short DataBlock_01,short DataBlock_02,short DataBlock_03,short DataBlock_04) {
        super(FileType, Generation, CreationDate, ModificationDate, Length, DataBlock_01, DataBlock_02, DataBlock_03,DataBlock_04);
        
    }


    
}
