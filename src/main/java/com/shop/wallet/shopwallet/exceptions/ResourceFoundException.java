package com.shop.wallet.shopwallet.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.transaction.HeuristicRollbackException;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;
    private String stringValue;


    public ResourceFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s already created with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceFoundException(String resourceName, String fieldName, String stringValue) {
        super(String.format("%s already created with %s : %s",resourceName,fieldName,stringValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.stringValue = stringValue;
    }
}
