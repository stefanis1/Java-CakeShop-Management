package Exceptions;

public class RepositoryExceptions extends RuntimeException {
    public RepositoryExceptions(String message) { super(message); }
    public RepositoryExceptions(String message, Throwable cause) { super(message, cause); }
}