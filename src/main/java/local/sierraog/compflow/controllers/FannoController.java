package local.sierraog.compflow.controllers;

import local.sierraog.compflow.models.Fanno;
import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.services.FannoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FannoController {
    @Autowired
    private FannoService fannoService;

    @PostMapping(value = "/fanno", consumes = {"application/json"})
    public ResponseEntity<?> getFannoFlow(@RequestBody Input input){
        Fanno myfanno = fannoService.findFannoFlow(input);
        return new ResponseEntity<>(myfanno, HttpStatus.OK);
    }
}
