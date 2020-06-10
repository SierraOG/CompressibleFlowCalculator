package local.sierraog.compflow.controllers;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Rayleigh;
import local.sierraog.compflow.services.RayleighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RayleighController {
    @Autowired
    private RayleighService rayleighService;

    @PostMapping(value = "/rayleigh", consumes = "application/json")
    public ResponseEntity<?> findRayleighFlow(@RequestBody Input input){
        Rayleigh rayleighFlow = rayleighService.findRayleighFlow(input);
        return new ResponseEntity<>(rayleighFlow, HttpStatus.OK);
    }
}
