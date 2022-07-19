package src.diskSimulator;
import src.operators.convertElements;

public class SNode{
    // tamanho fixo de 28 bytes em disco

    protected byte FileType;
    protected byte Generation;
    protected long CreationDate;
    protected long ModificationDate;

    protected short Length; 
    protected short DataBlock_01; //representa o apontador dentro do vetor 
    protected short DataBlock_02;
    protected short DataBlock_03;
    protected short DataBlock_04;



    public SNode(byte[] SNodeInVirtualDisk){
        
        convertElements operator = new convertElements(); 


        this.FileType = SNodeInVirtualDisk[0];
        this.Generation = SNodeInVirtualDisk[1];
        this.CreationDate = operator.convertByteToLong(operator.concatInArry(SNodeInVirtualDisk, 2, 10));
        this.ModificationDate = operator.convertByteToLong(operator.concatInArry(SNodeInVirtualDisk, 10, 18));
        this.Length = operator.convertByteToShort(operator.concatInArry(SNodeInVirtualDisk, 18, 20));
        this.DataBlock_01 = operator.convertByteToShort(operator.concatInArry(SNodeInVirtualDisk, 20, 22));
        this.DataBlock_02 = operator.convertByteToShort(operator.concatInArry(SNodeInVirtualDisk, 22, 24));
        this.DataBlock_03 = operator.convertByteToShort(operator.concatInArry(SNodeInVirtualDisk, 24, 26));
        this.DataBlock_03 = operator.convertByteToShort(operator.concatInArry(SNodeInVirtualDisk, 26, 28));
    }

    public SNode(byte fileType, byte Generation, long CreationDate, long ModificationDate, short DataBlock_01){ //*construtor para diretórios */
        this.FileType= FileType;
        this.Generation= Generation;
        this.CreationDate= CreationDate;
        this.ModificationDate= ModificationDate;
        this.Length= (short)128;
        this.DataBlock_01= DataBlock_01;
    }
    
    
    //construtor da classe 
    public SNode(byte FileType,byte Generation, long CreationDate, long ModificationDate, short Length, short DataBlock_01, short DataBlock_02, short DataBlock_03, short DataBlock_04){
        this.FileType= FileType;
        this.Generation= Generation;
        this.CreationDate= CreationDate;
        this.ModificationDate= ModificationDate;
        this.Length= Length;
        this.DataBlock_01= DataBlock_01;
        this.DataBlock_02= DataBlock_02;
        this.DataBlock_03= DataBlock_03; 
        this.DataBlock_04= DataBlock_04;

    
    }


    public byte[] convertSNodeInBytes(){

        byte[] SNodeByte = new byte[28];

        byte[] Data = new byte[4];
        byte[] shortvalue = new byte[2];
        convertElements convert = new convertElements();

        SNodeByte[0] = FileType; //fileType
        SNodeByte[1] = Generation; //generation
        

       
        Data = convert.convertDatetoBytes(CreationDate);

        SNodeByte[3] = Data[0]; //Data 
        SNodeByte[4] = Data[1]; //resolver depois 
        SNodeByte[5] = Data[2];
        SNodeByte[6] = Data[3];
        SNodeByte[7] = Data[4]; 
        SNodeByte[8] = Data[5];
        SNodeByte[9] = Data[6];
        SNodeByte[10] = Data[7];

        Data = convert.convertDatetoBytes(ModificationDate);

        SNodeByte[11] = Data[0]; //Data 
        SNodeByte[12] = Data[1];
        SNodeByte[13] = Data[2];
        SNodeByte[14] = Data[3];
        SNodeByte[15] = Data[4]; 
        SNodeByte[16] = Data[5];
        SNodeByte[17] = Data[6];
        SNodeByte[18] = Data[7];
        
        shortvalue = convert.convertShortToBytes(Length);

        SNodeByte[19] = shortvalue[0];
        SNodeByte[20] = shortvalue[1];

        shortvalue = convert.convertShortToBytes(DataBlock_01);

        SNodeByte[21] = shortvalue[0]; 
        SNodeByte[22] = shortvalue[1];

        shortvalue = convert.convertShortToBytes(DataBlock_02);

        SNodeByte[23] = shortvalue[0]; 
        SNodeByte[24] = shortvalue[1];

        shortvalue = convert.convertShortToBytes(DataBlock_03);

        SNodeByte[25] = shortvalue[0]; 
        SNodeByte[26] = shortvalue[1];
        
        shortvalue = convert.convertShortToBytes(DataBlock_04);

        SNodeByte[27] = shortvalue[0]; 
        SNodeByte[28] = shortvalue[1];
        
      
   
        
        return SNodeByte;
    }


}
