package br.com.gubee.marketplace.exception;

public class StackNotFoundException extends Throwable{
    public StackNotFoundException(Long id){
        super("Technology with id " + id +" not found.");
    }
}
