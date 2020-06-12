package local.sierraog.compflow.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import local.sierraog.compflow.models.ObliqueShock;
import local.sierraog.compflow.services.ObliqueShockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObliqueShockController {
    @Autowired
    private ObliqueShockService obliqueShockService;

    @ApiOperation(value = "Returns Oblique Shock flow properties for given inputs.",
            response = ObliqueShock.class)
    @GetMapping(value = "/oblique/{gamma}/{mach}/{secondInputType}/{secondInputValue}", produces = {"application/json"})
    public ResponseEntity<?> findOliqueFlow(@ApiParam(value = "The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions.",
            required = true,
            example = "1.4")
                                                @PathVariable double gamma,
                                            @ApiParam(value = "The incoming Mach number before the shock.",
                                                    required = true,
                                                    example = "2")
                                            @PathVariable double mach,
                                            @ApiParam(value = "Describes the secondInputValue passed to base the calculations on. Can be 'mach1n' for the normal component for the incoming Mach number, 'beta' for the shock wave angle beta in degrees, 'thetaweak' for the turn angle theta in degrees assuming a weak shock solution, or 'thetastrong' for the turn angle theta in degrees assuming a strong shock solution",
                                                    required = true,
                                                    example = "thetaweak")
                                            @PathVariable String secondInputType,
                                            @ApiParam(value = "The corresponding input value.",
                                                    required = true,
                                                    example = "20")
                                            @PathVariable double secondInputValue){
        ObliqueShock obliqueFlow = obliqueShockService.findObliqueFlow(gamma, mach, secondInputType, secondInputValue);
        return new ResponseEntity<>(obliqueFlow, HttpStatus.OK);
    }
}
