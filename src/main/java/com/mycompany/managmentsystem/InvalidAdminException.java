/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.managmentsystem;

/**
 *
 * @author sigma
 */
public class InvalidAdminException extends RuntimeException {

    public InvalidAdminException() {
    }
    public InvalidAdminException(String msg)
    {
        super(msg) ;
    }
}
