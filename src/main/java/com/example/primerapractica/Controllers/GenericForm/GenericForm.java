package com.example.primerapractica.Controllers.GenericForm;

import java.util.List;

public class GenericForm <T>{

    private T obj;
    private String validationUrl;
    private String returnUrl;
    private List<GenericFormField> fields;

    public GenericForm(String returnUrl, List<GenericFormField> fields) {
        this.returnUrl = returnUrl;
        this.fields = fields;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getValidationUrl() {
        return validationUrl;
    }

    public void setValidationUrl(String validationUrl) {
        this.validationUrl = validationUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public List<GenericFormField> getFields() {
        return fields;
    }

    public void setFields(List<GenericFormField> fields) {
        this.fields = fields;
    }
}
