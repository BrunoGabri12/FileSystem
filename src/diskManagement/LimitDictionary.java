package src.diskManagement;

public class LimitDictionary {

    private int minFilePerBlock = 16; 
    private int maxFilePerBlock = 65536;
    private int blocksSize = 128;
    private int diskBlockSize = 128;
    private int sNodeSize = 28;

    public int getMinFilePerBlocks(){
        return minFilePerBlock;
    }

    public int getMaxFilePerBlocks(){
        return maxFilePerBlock;
    }
    
    public int geBlocksSize(){
        return blocksSize;
    }
    
    public int getdiskBlockSize(){
        return diskBlockSize;
    }

    public int getSNodeSize(){
        return sNodeSize; 
    }
}