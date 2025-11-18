package Exceptions;

public class TortException extends RepositoryExceptions{
    public TortException(int id){super ("Exista deja un tort cu id-ul= "+id);}
    public TortException(String message){super(message);}
}