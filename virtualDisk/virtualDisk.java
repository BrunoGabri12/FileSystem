package virtualDisk;
//classe que representa o disco virtual, onde serão armazenadas as estruturas 
public class virtualDisk {
    private byte[] VD; //disco virtual 


    public virtualDisk(int size) {
        this.VD = new byte[size] ;
    }
    public void insertNode(int position, byte element){
        
        if(position < VD.length){
            this.VD[position] = element;
        } 
        else {
            System.out.println("index out of range");
        }

    }
    public void insertNode(int positionI, byte element[]){
        if( positionI > 0 && (positionI+element.length<VD.length)  && element.length!=0 ){

            for(int i = positionI, j=0 ;  i< (positionI+element.length) ; i++, j++ ){
                VD[i] = element[j];
            }

        }
        else {
            System.out.println("Inserção Inválida");
        }

    }

    public byte getElement(int positionI){
        return VD[positionI];
    }
}
