package local.sierraog.compflow.controllers;

import local.sierraog.compflow.models.ObliqueShock;
import local.sierraog.compflow.models.TwoInputs;
import local.sierraog.compflow.services.ObliqueShockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObliqueShockController {
    @Autowired
    private ObliqueShockService obliqueShockService;

    @PostMapping(value = "/oblique", produces = {"application/json"})
    public ResponseEntity<?> findOliqueFlow(@RequestBody TwoInputs input){
        ObliqueShock obliqueFlow = obliqueShockService.findObliqueFlow(input);
        return new ResponseEntity<>(obliqueFlow, HttpStatus.OK);
    }
}
