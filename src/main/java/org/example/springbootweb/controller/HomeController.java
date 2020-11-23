package org.example.springbootweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    private static final Logger LOGGER = LogManager.getLogger(HomeController.class.getName());

    @RequestMapping("/")
    public String home(){
        return "Hello Worlds!";
    }
    // /obtenerSimulacion/1000/A1

    @GetMapping("/obtenerSimulacion/{monto}")
    public Map obtenerSimulacion(@PathVariable String monto){
        LOGGER.debug("Executing task",monto);

        Map result = new HashMap();
        result.put("meses",12);
        result.put("tasaDeInteres",18);
        result.put("monto",monto);
        result.put("montoFinal",Integer.valueOf(monto)*18/100);
        return result;
    }

}
