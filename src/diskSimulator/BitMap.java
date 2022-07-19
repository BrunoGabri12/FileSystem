package src.diskSimulator;
public class BitMap {
    //estrutura de controle que gerencia o BitMap do virtualDisk

    private byte BitMapElement;
    private byte[] BitMap;
    private int sizeBitmap;


    public BitMap(byte BitMapElement, int size){

        BitMap = new byte[size];
        this.sizeBitmap = size; 
        this.BitMapElement = BitMapElement;
        iterateByteToVetor();
        convertVetorToByte();
    }

    public BitMap(int i) {
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
        

        for(int i=0 ; i<this.sizeBitmap; i++){
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
        
        for(int i=0 ; i<this.sizeBitmap ; i++){
            element += String.valueOf(BitMap[i]);
        }

        //converte string em byte 
        BitMapElement = Byte.parseByte(element,2);
    }


    public byte getBitMap() {
        return BitMapElement;
    }
}
