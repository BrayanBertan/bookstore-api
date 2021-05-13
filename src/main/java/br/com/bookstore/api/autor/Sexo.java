/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookstore.api.autor;

/**
 *
 * @author brayanbertan
 */
enum Sexo {
    
    
    M("M"),
    F("F");
    
    private String valor;

    private Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    
}
