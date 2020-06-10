package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Fanno;
import local.sierraog.compflow.models.Input;
import org.springframework.stereotype.Service;

@Service(value = "fannoService")
public class FannoServiceImpl extends FanBaseFunctions {
    @Override
    public Fanno findFannoFlow(Input input){
        Fanno fannoFlow;
        double gamma = input.getGamma();
        double mach;
        double ttstar;
        double ppstar;
        double popostar;
        double uustar;
        double flstard;
        double sstarsr;
        switch (input.getInputType()){
            case "mach":
                mach = input.getInputValue();
                break;
            default:
                mach = 0.0;
                break;
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
