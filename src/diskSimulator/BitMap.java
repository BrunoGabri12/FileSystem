package src.diskSimulator;
public class BitMap {


    private byte[] BitMap;




    public BitMap(int size){
        
        BitMap = new byte[size];
        
        for(int i =0 ; i<BitMap.length;i++){
            BitMap[i] = 0 ; //inicialização com todos os espaços disponíveis 
        }
    }

    public boolean insertNode(int position){

        int validation = SearchInByteVector(position);

        if(validation == 1){
            return false;
        }
        else { 
              
            int positionSlot;
        
            if(position<8){
                    positionSlot = 0;
            }
                
                
            else {
                    positionSlot = (int)position/8; //irá pegar o slot que o elemento pertence
            }
            
            
            int positionElementInSlot = (int) Math.abs(positionSlot*8 - position); 
            
            
             
            byte maskByte = 0b00000001;
            maskByte =  (byte) (maskByte << positionElementInSlot); //dá um shift na mascara
            BitMap[positionSlot] = (byte) (maskByte | BitMap[positionSlot]);  //irá realizar operação bit a bit para adicionar que o elemento está ocupando o local 
            
            return true;
            }
    
    }
    

    public boolean removeNode(int position){

            int validation = SearchInByteVector(position);
    
            if(validation == 1){
                return false;
            }
            else { 
                  
                int positionSlot;
            
                if(position<8){
                        positionSlot = 0;
                }
                    
                    
                else {
                        positionSlot = (int)position/8; //irá pegar o slot que o elemento pertence
                }
                
                
                int positionElementInSlot = (int) Math.abs(positionSlot*8 - position); 
                
                
                 
                byte maskByte = 0b00000001;
                maskByte =  (byte) (maskByte << positionElementInSlot); //dá um shift na mascara
                BitMap[positionSlot] = (byte) (maskByte ^ BitMap[positionSlot]);  //irá realizar operação bit a bit para adicionar que o elemento está ocupando o local 
                
                return true;
                }
        
        }


    private int SearchInByteVector(int position){

        
        int positionSlot;
       
        if(position<8){
            positionSlot = 0;
        }
        else {
            positionSlot = (int)position/8; //irá pegar o slot que o elemento pertence 
        }
        
        
        int positionElementInSlot = (int) Math.abs(positionSlot*8 - position); 
        
        
        
        byte maskByte = 0b00000001;
        maskByte =  (byte) (maskByte << positionElementInSlot); //dá um shift na mascara


        return (int) maskByte & BitMap[positionSlot]; //irá retornar 0 se o espaço estiver vazio ou 1 se ele estiver ocupado 

            

    }

}
