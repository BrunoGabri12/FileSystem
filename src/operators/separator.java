package src.operators;

public class separator {
    // tera que quebrar a string em pedaços de acordo com a divisão do /

    String[] pathnames;


    public separator(String pathname){
            
        pathnames = pathname.split("/");
        

    }

    String[] get(){

        return pathnames;
    }

}
