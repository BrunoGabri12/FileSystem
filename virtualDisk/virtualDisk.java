package virtualDisk;
//classe que representa o disco virtual, onde serão armazenadas as estruturas 
public class virtualDisk {
    private byte[] VD; //disco virtual 
    private int LastInsert = 0 ;

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
        int i=0,j;

        if( positionI > 0 && (positionI+element.length<VD.length)  && element.length!=0 ){

            for(i = positionI, j=0 ;  i< (positionI+element.length) ; i++, j++ ){
                VD[i] = element[j];
            }

        }
        else {
            System.out.println("Inserção Inválida");
        }

        this.LastInsert = i;

    }

    public byte[] getElement(int position, int size_element){

        byte[] element = new byte[size_element];
        
        for(int i = position, j = 0; i<size_element; i ++, j++){
            element[j] = VD[i];
        }


        return element;
    }

    public int getLastInsertPosition(){
        return this.LastInsert;
    }
}
