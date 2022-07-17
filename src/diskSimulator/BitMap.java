package src.diskSimulator;
public class BitMap {
    //estrutura de controle que gerencia o BitMap do virtualDisk
    //ainda precisa pensar no caso onde aumentar o bitmap
    //pensar na generalização de um mapa de bits 
    private byte BitMapElement;
    private byte[] BitMap = new byte[8];

    public BitMap(byte BitMapElement){
        this.BitMapElement = BitMapElement;
        iterateByteToVetor();
        convertVetorToByte();
    }

    public boolean insertNode(int position){

        if(BitMap[position] == 1 ){
            return false; 
        }
        else {
            BitMap[position] = 1;
        }

        return true;

    }

    public boolean removeNode(int position){
        BitMap[position] = 0;


        return true;
    } //metodos para inserção de nodes 


    private void iterateByteToVetor(){

        byte maskByte = 0b00000001;
        

        for(int i=0 ; i<8 ; i++){
            if((maskByte & this.BitMapElement) == 1){
                BitMap[i] = 1;
            }else {
                BitMap[i] = 0;
            }
            
            maskByte =  (byte) (maskByte << 1);
        }

    }

    private void convertVetorToByte(){

        String element = ""; 
        
        for(int i=0 ; i<8 ; i++){
            element += String.valueOf(BitMap[i]);
        }

        //converte string em byte 
        BitMapElement = Byte.parseByte(element,2);
    }


    public byte getBitMap() {
        return BitMapElement;
    }
}
