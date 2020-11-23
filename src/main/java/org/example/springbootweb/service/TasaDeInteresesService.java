package org.example.springbootweb.service;

import org.example.springbootweb.entity.TasaDeIntereses;

import java.util.Map;

public interface TasaDeInteresesService {
    public Map<String, Object> getTasaDeInteresMap();
    public TasaDeIntereses getTasaDeInteres(Long id);
    public TasaDeIntereses getTasaDeInteresByInteresCode(String code);

}
