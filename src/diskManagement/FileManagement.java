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
    private FileOutputStream diskFile;
  
   
   
    private int maxFile, maxDir;
 
  
    private FileType type= new FileType();
   
    private DEntry root; 
    
    
    private BitMap bitMap1;
    private BitMap bitMap2;



    private LimitDictionary size = new LimitDictionary();
    private convertElements operator;


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

        this.bitMap1= new BitMap(maxFile/8);
        this.bitMap2 = new BitMap(maxFile/8); //instanciação dos bitmaps para a representação dos elementos 
        this.createRootDisk();
    }

    


    //Método que realiza a criação do Root  
    private void createRootDisk(){ //instanciação do root 
        String fileName = "/";
        root = new DEntry((short) 1, (short)16, type.get("Directory"), (byte) 1, fileName.getBytes());
        

        long millis = Instant.now().toEpochMilli();
        //como os elementos ainda estão em memória, não será necessário utilizar o endereço dos blocos. Estes serão apenas considerados quando os elementos forem persistidos na memória. Será import
        root.allocatNewSNodeDir(type.get("Directory"),(byte) 0 ,millis, millis, (short) 1);  //alocação da root 
        bitMap1.insertNode(1);
    
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