package br.com.gubee.marketplace.exception;

public class TargetMarketNotFoundException extends Throwable{

    public TargetMarketNotFoundException(Long id){
        super("TargetMarket with id " + id + " not found.");
    }
}
