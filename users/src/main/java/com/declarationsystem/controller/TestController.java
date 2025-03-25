package com.declarationsystem.controller; // o package com.imt.users.controller si usas ese paquete

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/db")
    public String testDbConnection() {
        return "Conexión a PostgreSQL funciona correctamente";
    }
}