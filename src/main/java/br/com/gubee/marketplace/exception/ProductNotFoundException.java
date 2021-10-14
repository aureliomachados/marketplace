package br.com.gubee.marketplace.exception;

public class ProductNotFoundException extends Throwable{
    public ProductNotFoundException(Long id){
        super("Product not found with id: " + id);
    }
}
