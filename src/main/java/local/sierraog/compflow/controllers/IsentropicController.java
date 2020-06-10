package local.sierraog.compflow.controllers;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Isentropic;
import local.sierraog.compflow.services.IsentropicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsentropicController {
    @Autowired
    private IsentropicService isentropicService;

    @PostMapping(value = "/isentropic", consumes = {"application/json"})
    public ResponseEntity<?> findIsentropicFlow(@RequestBody Input input){
        Isentropic myIsenFlow = isentropicService.findIsentropicFlow(input);
        return new ResponseEntity<>(myIsenFlow, HttpStatus.OK);
    }
}
