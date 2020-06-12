package local.sierraog.compflow.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import local.sierraog.compflow.models.Fanno;
import local.sierraog.compflow.services.FannoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FannoController {
    @Autowired
    private FannoService fannoService;

    @ApiOperation(value = "Returns Fanno flow properties for given input.",
            response = Fanno.class)
    @GetMapping(value = "/fanno/{gamma}/{inputType}/{inputValue}", produces = {"application/json"})
    public ResponseEntity<?> getFannoFlow(@ApiParam(value = "The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions.",
            required = true,
            example = "1.4")
                                              @PathVariable double gamma,
                                          @ApiParam(value = "Describes the value passed to base the calculations on. Currently only an inputType of 'mach' is supported for Fanno Flow.",
                                                  required = true,
                                                  example = "mach")
                                          @PathVariable String inputType,
                                          @ApiParam(value = "The actual value passed to base the calculations on. Currently can only be the mach number for Fanno Flow.",
                                                  required = true,
                                                  example = "2")
                                          @PathVariable double inputValue){
        Fanno myfanno = fannoService.findFannoFlow(gamma, inputType, inputValue);
        return new ResponseEntity<>(myfanno, HttpStatus.OK);
    }
}
