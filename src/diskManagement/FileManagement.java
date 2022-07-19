package src.diskManagement;

import java.io.FileOutputStream;
import java.time.Instant;

import src.diskManagement.exceptions.*;
import src.diskManagement.interfaces.*;
import src.diskSimulator.*;
import src.operators.*;
import virtualDisk.virtualDisk;

//classe que implementa o gerenciador de disco 
public class FileManagement implements FileManagementInterface,VirtualDiskInspectionInterface {
    
    private String NameOfDisk; 
    private LimitDictionary limits;

    private FileOutputStream diskFile;
    private int maxFile, maxDir;
    private virtualDisk VD;    
    private FileType type= new FileType();
   
    private BitMap bitMapBlocks;
    private BitMap bitMapSNode;

    private LimitDictionary size = new LimitDictionary();

    private convertElements operator;

    /*
     * como não temos comando para alteração de tamanho de arquivo, os arquivos serão adicionados de forma sequencial.
     * Na hora de removermos eles, eles apenas serão deletados do map de bits 
     */

    /**Inicialização do disco virtual
     *@param NameOfDisk nome do disco 
     *@param maxFile tamanho máximo do disco
     *@param maxDir tamanho máximo de diretorio
     */

    /*inicialização do disco */
     public FileManagement(String NameOfDisk, int maxFile, int maxDir){
        this.NameOfDisk = NameOfDisk; 
        this.maxDir = maxDir;
        this.maxFile = maxFile; 

        VD= new virtualDisk(28*maxFile + 128*maxFile); //alocação do espaço necessário para armanezamento 
        //28*maxfile refere-se ao SNode necessário para representar um block 
        //128*maxFile refere-se a quantidade de blocos alocadas  


        this.createRootDisk();
    }

    


    //Método que realiza a criação do Root  
    private boolean createRootDisk(){ //instanciação do root 

        long millis = Instant.now().toEpochMilli();  //data de criação do arquivo 

        DEntry rootDEntry = new DEntry((short)8, (short)6, type.get("Directory"), (byte)1, operator.convertStringInBytesVector("/"));
        SNode root = new SNode(type.get("Directory"), (byte)0 , millis,millis,  (short) (bitMap1.gitSizeBitMap() + 36)); //adicionando um SNode associado ao root 
        
        VD.insertNode(0,rootDEntry.convertDEntryInBytes()); //inserção no disco virtual do DEntry associado ao Root  
        VD.insertNode(VD.getLastInsertPosition()+1, root.convertSNodeInBytes()); //todos elementos será deslocados 8bits para frente, pois os primeiros 8bits são do DEntry do root 

        bitMapBlocks.insertNode(0); //insere posição do Bloco da Root 



        return true;
    
    }


    //criação do disco 
    private boolean createDiskInMemoria(){
    
        if((maxFile%8 != 0 || maxDir%8 != 0) || (maxFile<size.get("MinFilePerBlocks")) || maxFile>size.get("MaxFilePerBlocks") || (maxDir<size.get("MinFilePerBlocks")) && maxDir>size.get("MaxFilePerBlocks")){ //verificação se os valores estabelecem o critério de criação S 
            return false; 
        }
        else {
           try{ //criação +do arquivo binário que simula o disco 
              this.diskFile = new FileOutputStream("../disk/"+this.NameOfDisk+".dat");
              return true;
            } catch(Exception e){ //disco não foi criado com exito 
                System.out.println(e);
            }
            
        }

        return false; 
    }


    /**
    * Metodo que adiciona nova entrada (diretorio) em um diretorio existente
    * @param pathname - caminho absoluto do diretorio alvo da operacao
    * @param filename - identificador do novo diretorio sendo criado
    * @return true se operacao realizada com sucesso, false se operacao nao pode ser realizada
    * @throws InvalidEntryException - se formato de pathname ou filename for invalido ou entrada for duplicada
    * @throws VirtualFileNotFoundException - se diretorio identificado por pathname nao for encontrado 
   */

    @Override
    public boolean addDirectory(String pathname, String filename) throws InvalidEntryException, VirtualFileNotFoundException {
        long millis = Instant.now().toEpochMilli();  //data de criação do arquivo 
        SNode Directory = new SNode(type.get("Directory"), (byte)0 , millis, millis, (short)0); //criação de um novo diretório 

        


    
        return false;
    }

    private short searchInPath(String pathname){
        separator separatorOfPath = new separator(pathname);
        String[] elements = separatorOfPath.get(); //retorna o vetor do caminho


        //caso seja o root, retorna o endereço do DEntry do root 
        int FileNameLength;

        /*
         * compara o elements como FileName do entry, caso seja falso. expeção 
         * caso verdadeiro, pega o endereço do SNodeIdentifier. Dentro do SNodeIdentifier
         * Ir para SNode, realizar a busca no DataBlock associado. Caso não encontrado, 
         * exceção 
         * 
         * Caso encontrado, ir para o SNodeIdentifier, até encontrar a posição desejada 
         * 
         * 
         */
         SNode auxSNode; 
         DEntry auxDEntry; 



         auxDEntry = new DEntry(VD.getElement(0, 8)); //pegamos inicialmente o DEntry do Root


    
        for(int i = 0; i< elements.length; i++){

            if(auxDEntry. == elements[i]){ //realiza a comparação entre o elemento
                 
                

            }
            else { 
                 
            }


        }

        //irá retornar a posição na memória 


    }



    @Override
    public boolean addFile(String pathname, String filename, FileType type, int length) throws InvalidEntryException, VirtualFileNotFoundException {

        return false;
    }

    @Override
    public boolean deleteFile(String pathname, String filename) throws InvalidEntryException, VirtualFileNotFoundException {
      
        return false;
    }

    @Override
    public String[] listDirectory(String pathname) throws InvalidEntryException, VirtualFileNotFoundException {
        
        return null;
    }

    @Override
    public boolean parseCommandFile(String pathname) {
       
        return false;
    }

    @Override
    public boolean saveVirtualDisk() {
       
        return false;
    }

    @Override
    public String getSNodeInfo(int snodeId) throws InvalidSNodeException {
       
        return null;
    }

    @Override
    public String getSnodeBitmap() {
      
        return null;
    }

    @Override
    public String getDataBlockBitmap() {
        
        return null;
    }


    @Override
    public boolean addFile(String pathname, String filename, src.src.operators.FileType type, int length)
            throws src.src.diskManagement.exceptions.InvalidEntryException,
            src.src.diskManagement.exceptions.VirtualFileNotFoundException {
        // TODO Auto-generated method stub
        return false;
    } 
 


}