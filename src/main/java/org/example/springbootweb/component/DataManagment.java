package org.example.springbootweb.component;

import org.example.springbootweb.service.TasaDeInteresesService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DataManagment {
    @Autowired
    TasaDeInteresesService tasaDeInteresesService;
    public void getData(){

    }
}
