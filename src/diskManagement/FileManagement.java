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
   
    private BitMap bitMap1;
    private BitMap bitMap2;

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

        this.createRootDisk();
    }

    


    //Método que realiza a criação do Root  
    private boolean createRootDisk(){ //instanciação do root 

   

    
    }


    //criação do disco 
    private boolean createDisk(){
    
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



    @Override
    public boolean addDirectory(String pathname, String filename) throws InvalidEntryException, VirtualFileNotFoundException {
        long millis = Instant.now().toEpochMilli();  //data de criação do arquivo 
        SNodeDir Directory = new SNodeDir(type.get("Directory"), (byte)0 , millis, millis, (short)0); //criação de um novo diretório 

        
        //primeiro temos que realizar uma busca para saber em que diretório será adicionado
        //depois precisamos buscar um espaço na memória para armazenar o diretório -> irá buscar no BitMap 


        return false;
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