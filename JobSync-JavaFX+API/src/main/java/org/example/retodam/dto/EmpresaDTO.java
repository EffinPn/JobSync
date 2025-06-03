package org.example.retodam.dto;


public class EmpresaDTO {

    private String razon_social;

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public EmpresaDTO(String razon_social) {
        this.razon_social = razon_social;
    }

    public EmpresaDTO() {
    }
}
