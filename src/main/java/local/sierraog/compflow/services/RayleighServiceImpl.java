package local.sierraog.compflow.services;

import local.sierraog.compflow.exceptions.IncorrectInputTypeException;
import local.sierraog.compflow.exceptions.InputOutOfBoundsException;
import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Rayleigh;
import org.springframework.stereotype.Service;

@Service(value = "rayleighService")
public class RayleighServiceImpl extends RayBaseFunctions {
    @Override
    public Rayleigh findRayleighFlow(Input input) {
        Rayleigh rayleighFlow;
        double gamma = input.getGamma();
        double mach;
        double totostar;
        double ttstar;
        double ppstar;
        double popostar;
        double uustar;
        double sstarsr;

        if (gamma <= 1.0) {
            throw new InputOutOfBoundsException("Gamma must be greater than 1");
        }

        switch (input.getInputType()){
            case "mach":
                mach = input.getInputValue();
                if (mach <= 0.0){
                    throw new InputOutOfBoundsException("Mach number must be greater than 0");
                }
                break;
            default:
                throw new IncorrectInputTypeException();
        }
        totostar = totos(mach, gamma);
        ttstar = tts(mach, gamma);
        ppstar = pps(mach, gamma);
        popostar = popos(mach, gamma);
        uustar = uus(mach, gamma);
        sstarsr = ssr(mach, gamma);
        rayleighFlow = new Rayleigh(gamma, mach, totostar, ttstar, ppstar, popostar, uustar, sstarsr);
        return rayleighFlow;
    }
}
