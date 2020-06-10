package local.sierraog.compflow.controllers;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.NormalShock;
import local.sierraog.compflow.services.NormalShockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalShockController {
    @Autowired
    private NormalShockService normalShockService;

    @PostMapping(value = "/normalshock", consumes = {"application/json"})
    public ResponseEntity<?> findNormalShock(@RequestBody Input input){
        NormalShock normalFlow = normalShockService.findNormalFlow(input);
        return new ResponseEntity<>(normalFlow, HttpStatus.OK);
    }
}
