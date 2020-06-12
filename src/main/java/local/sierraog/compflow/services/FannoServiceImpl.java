package local.sierraog.compflow.services;

import local.sierraog.compflow.exceptions.IncorrectInputTypeException;
import local.sierraog.compflow.exceptions.InputOutOfBoundsException;
import local.sierraog.compflow.models.Fanno;
import org.springframework.stereotype.Service;

@Service(value = "fannoService")
public class FannoServiceImpl extends FanBaseFunctions {
    @Override
    public Fanno findFannoFlow(double gamma, String inputType, double inputValue){
        Fanno fannoFlow;
        double mach;
        double ttstar;
        double ppstar;
        double popostar;
        double uustar;
        double flstard;
        double sstarsr;

        if (gamma <= 1.0) {
            throw new InputOutOfBoundsException("Gamma must be greater than 1");
        }

        switch (inputType){
            case "mach":
                mach = inputValue;

                if (mach <= 0.0){
                    throw new InputOutOfBoundsException("Mach number must be greater than 0");
                }

                break;
            default:
                throw new IncorrectInputTypeException();
        }
        ttstar = tts(mach, gamma);
        ppstar = pps(mach, gamma);
        popostar = popos(mach, gamma);
        uustar = uus(mach, gamma);
        flstard = flsd(mach, gamma);
        sstarsr = ssr(mach, gamma);
        fannoFlow = new Fanno(gamma, mach, ttstar, ppstar, popostar, uustar, flstard, sstarsr);
        return fannoFlow;
    }
}
