package src.diskSimulator;

public class SNodeDir extends SNode {

    DEntry subFiles[]; //inicializado sem nenhum DEntry 
    
    public SNodeDir(Byte fileType, byte Generation, long CreationDate, long ModificationDate, long DataBlock_01){
        super(fileType, Generation, CreationDate, ModificationDate, (short) 128, (short) DataBlock_01, (short) -1, (short) -1, (short)-1); //estrutura de um diretório
       
    }

    


    
}
