package com.williambohn.cursomc.service.exceptions;

//Para auxiliar o tratamento da exception que categorias com produtos nao podem ser excluidas
public class DataIntegrityException  extends RuntimeException{

    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause){
        super(msg,cause);
    }
    
}
