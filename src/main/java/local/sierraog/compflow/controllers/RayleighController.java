package local.sierraog.compflow.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import local.sierraog.compflow.models.Rayleigh;
import local.sierraog.compflow.services.RayleighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RayleighController {
    @Autowired
    private RayleighService rayleighService;

    @ApiOperation(value = "returns Rayleigh flow properties for given input.",
            response = Rayleigh.class)
    @GetMapping(value = "/rayleigh/{gamma}/{inputType}/{inputValue}", produces = "application/json")
    public ResponseEntity<?> findRayleighFlow(@ApiParam(value = "The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions.",
            required = true,
            example = "1.4")
                                                  @PathVariable double gamma,
                                              @ApiParam(value = "Describes the value passed to base the calculations on. Currently only an inputType of 'mach' is supported for Rayleigh Flow.",
                                                      required = true,
                                                      example = "mach")
                                              @PathVariable String inputType,
                                              @ApiParam(value = "The actual value passed to base the calculations on. Currently can only be the mach number for Rayleigh Flow.",
                                                      required = true,
                                                      example = "2")
                                              @PathVariable double inputValue){
        Rayleigh rayleighFlow = rayleighService.findRayleighFlow(gamma, inputType, inputValue);
        return new ResponseEntity<>(rayleighFlow, HttpStatus.OK);
    }
}
