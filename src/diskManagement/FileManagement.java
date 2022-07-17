package src.diskManagement;

import java.io.FileOutputStream;
import java.time.Instant;

import src.diskManagement.exceptions.InvalidEntryException;
import src.diskManagement.exceptions.InvalidSNodeException;
import src.diskManagement.interfaces.FileManagementInterface;
import src.diskManagement.interfaces.VirtualDiskInspectionInterface;
import src.diskSimulator.BitMap;
import src.diskSimulator.DBlock;
import src.diskSimulator.DEntry;
import src.diskSimulator.FileType;
import src.diskSimulator.SNode;
import src.diskSimulator.SNodeDir;
import src.diskSimulator.FileType;
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

    
    //criação do root do disco 
    private boolean createRootDisk(){ //instanciação do root 

        try{

            long millis = Instant.now().toEpochMilli();  //criação do root
            SNode root= new SNodeDir(type.get("Directory"),(byte)0, millis, millis, (short)0);
            DBlock blockRoot = new DBlock();

            String namefile = new String("/");
            //DEntry para a Root
            DEntry DEntryRoot = new DEntry((short)17,(short)16, type.get("Directory"),(byte)1, namefile.getBytes());

            
            VD.insertNode(17, root.convertSNodeInBytes()); //estrutura principal da memória  
            VD.insertNode(45,bitMap1.getBitMap());
            VD.insertNode(46,blockRoot.getBlock());
            VD.insertNode(174, bitMap2.getBitMap()); //insere os bitmaps 

            return true;
            
        } catch(Exception IO){ 
            return false; 
        }

    
    }


    //criação do disco 
    private boolean createDisk(){
    
        if((maxFile%8 != 0 || maxDir%8 != 0) || (maxFile<limits.getMinFilePerBlocks() || maxFile>limits.getMaxFilePerBlocks()) || (maxDir<limits.getMinFilePerBlocks() && maxDir>limits.getMaxFilePerBlocks())){ //verificação se os valores estabelecem o critério de criação S 
            return false; 
        }
        else {
           try{ //criação do arquivo binário que simula o disco 
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
        long millis = Instant.now().toEpochMilli();  //criação do root
        SNodeDir Directory = new SNodeDir(type.get("Directory"), (byte)0 , millis, millis, (short)0); //criação de um novo diretório 

        
        //primeiro temos que realizar uma busca para saber em que diretório será adicionado
        //depois precisamos buscar um espaço na memória para armazenar o diretório -> irá buscar no BitMap 

        if(pathname == "/"){ //significa que o caminho é a raiz

        }
        else { //tera que realizar a busca pela memória 
            //começa pelo Root, busca o elemento que ela está buscando, acessa tal elemento e assim por diante até chegar na posição do DEntry. 
            //adiciona o file/directory na posição e atualiza o DEntry do diretório associado 
        }

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
    public boolean addFile(String pathname, String filename, src.diskManagement.interfaces.FileType type, int length)
            throws src.src.diskManagement.exceptions.InvalidEntryException,
            src.diskManagement.interfaces.VirtualFileNotFoundException {
        // TODO Auto-generated method stub
        return false;
    } 
 


}