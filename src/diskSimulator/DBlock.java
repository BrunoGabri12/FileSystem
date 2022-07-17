package src.diskSimulator;

public class DBlock {
    byte[] Data_Block = new byte[128];


    public boolean insertElement(int p1,int p2,byte[] element){
        if(p2<128){
            for(int i=p1,j=0;i<p2 && j<element.length;i++){
                Data_Block[i] = element[j];
            }

            return true;
        }

        else {
            return false;
        }
    }

    public byte[] getBlock(){
        return Data_Block;
    }
}
