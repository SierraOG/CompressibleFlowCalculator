package local.sierraog.compflow.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import local.sierraog.compflow.models.Isentropic;
import local.sierraog.compflow.services.IsentropicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IsentropicController {
    @Autowired
    private IsentropicService isentropicService;

    @ApiOperation(value = "Returns Isentropic flow properties for given input.",
            response = Isentropic.class)
    @GetMapping(value = "/isentropic/{gamma}/{inputType}/{inputValue}", produces = {"application/json"})
    public ResponseEntity<?> findIsentropicFlow(@ApiParam(value = "The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions.",
            required = true,
            example = "1.4")
                                                    @PathVariable double gamma,
                                                @ApiParam(value = "Describes the inputValue passed to base the calculations on. Can be 'mach' for Mach number, 'temp' for T/T0 temperature ratio, 'pres' for P/P0 pressure ratio, 'rho' for rho/rho0 density ratio, 'areasub' for A/A* area ratio with the subsonic solution, 'areasuper' for A/A* area ratio with supersonic solution, 'pmangle' for Prandtl-Meyer angle in degrees, or 'machangle' for the Mach angle in degrees",
                                                        required = true,
                                                        example = "machangle")
                                                @PathVariable String inputType,
                                                @ApiParam(value = "The corresponding value to do calculations on",
                                                        required = true,
                                                        example = "20")
                                                @PathVariable double inputValue){
        Isentropic myIsenFlow = isentropicService.findIsentropicFlow(gamma, inputType, inputValue);
        return new ResponseEntity<>(myIsenFlow, HttpStatus.OK);
    }
}
