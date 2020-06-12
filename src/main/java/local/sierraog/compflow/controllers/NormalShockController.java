package local.sierraog.compflow.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import local.sierraog.compflow.models.NormalShock;
import local.sierraog.compflow.services.NormalShockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NormalShockController {
    @Autowired
    private NormalShockService normalShockService;

    @ApiOperation(value = "Returns Normal Shock flow properties for given input.",
            response = NormalShock.class)
    @GetMapping(value = "/normalshock/{gamma}/{inputType}/{inputValue}", produces = {"application/json"})
    public ResponseEntity<?> findNormalShock(@ApiParam(value = "The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions.",
            required = true,
            example = "1.4")
                                                 @PathVariable double gamma,
                                             @ApiParam(value = "Describes the inputValue passed to base the calculations on. Can be 'mach' for incoming Mach number before the shock wave, 'mach2' for Mach number after the shock wave, 'temp' for T2/T1 temperature ratio, 'pres' for P2/P1 pressure ratio, 'rho' for rho2/rho1 density ratio, 'stagpres' for P02/P01 stagnation pressure ratio, 'presstagpres' for P1/P02 pressure to stagnation pressure ratio",
                                                     required = true,
                                                     example = "mach2")
                                             @PathVariable String inputType,
                                             @ApiParam(value = "The corresponding value to do calculations on",
                                                     required = true,
                                                     example = "0.7")
                                             @PathVariable double inputValue){
        NormalShock normalFlow = normalShockService.findNormalFlow(gamma, inputType, inputValue);
        return new ResponseEntity<>(normalFlow, HttpStatus.OK);
    }
}
