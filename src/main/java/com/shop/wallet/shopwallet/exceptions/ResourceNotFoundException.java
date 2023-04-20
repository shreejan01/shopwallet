package com.shop.wallet.shopwallet.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Supplier;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    private String fieldStringValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s ", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldStringValue) {
        super(String.format("%s not found with %s : %s ", resourceName,fieldName,fieldStringValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldStringValue = fieldStringValue;
    }

}
