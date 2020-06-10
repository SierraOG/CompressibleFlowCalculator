package local.sierraog.compflow.services;

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

        switch (input.getInputType()){
            case "mach":
                mach = input.getInputValue();
                break;
            default:
                mach = 0.0;
                break;
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
