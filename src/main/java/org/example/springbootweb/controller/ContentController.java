package org.example.springbootweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.springbootweb.entity.TasaDeIntereses;
import org.example.springbootweb.service.TasaDeInteresesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ContentController {


    @Autowired
    private TasaDeInteresesService tasaDeInteresesService;

    private static final Logger LOGGER = LogManager.getLogger(ContentController.class.getName());


    @GetMapping("/cargarTasasDeInteres")
    public Map cargarTasasDeInteres() throws Exception{
        //Credential from Authorization
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //Metadata
        Map resultMap = tasaDeInteresesService.getTasaDeInteresMap();
        return resultMap;
    }

    @GetMapping("/obtenerTasaDeInteres/{id}")
    public TasaDeIntereses obtenerTasaDeInteres(@PathVariable String id) throws Exception{
        //Credential from Authorization
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //Metadata
        TasaDeIntereses tasaDeInteres = tasaDeInteresesService.getTasaDeInteres(Long.valueOf(id));
        return tasaDeInteres;
    }

    @GetMapping("/obtenerTasaDeInteresPorCodigo/{codigo}")
    public TasaDeIntereses obtenerTasaDeInteresPorCodigo(@PathVariable String codigo) throws Exception{
        //Credential from Authorization
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //Metadata
        TasaDeIntereses tasaDeInteres = tasaDeInteresesService.getTasaDeInteresByInteresCode(codigo);
        return tasaDeInteres;
    }

    @GetMapping("/obtenerTasaDeInteres/{monto}/{codigo}")
    public Long obtenerTasaDeInteres(@PathVariable String monto,@PathVariable String codigo){
        LOGGER.debug("Executing task",monto);
        TasaDeIntereses tasaDeIntereses = tasaDeInteresesService.getTasaDeInteresByInteresCode(codigo);
        Long tasaMontoInteres = Long.valueOf(tasaDeIntereses.getInteresMonto());
        var result = tasaMontoInteres * Long.valueOf(monto)/100;
        return result;
    }
}
