package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Isentropic;
import org.springframework.stereotype.Service;

@Service(value = "isentropicService")
public class IsentropicServiceImpl extends IsentBaseFunctions {
    @Override
    public Isentropic findIsentropicFlow(Input input){
        Isentropic isentropicFlow;
        double gamma = input.getGamma();
        double mach;
        double tto;
        double machangle;
        double pmangle;
        double ppo;
        double rhorhoo;
        double ppstar;
        double rhorhostar;
        double ttstar;
        double aastar;

        switch (input.getInputType()){
            case "mach":
                mach = input.getInputValue();
                break;
            case "temp":
                tto = input.getInputValue();
                mach = Math.sqrt(2.0*((1.0/tto)-1.0)/(gamma-1.0));
                break;
            case "pres":
                ppo = input.getInputValue();
                mach = Math.sqrt(2.0*((1.0/Math.pow(ppo,(gamma-1.0)/gamma))-1.0)/(gamma-1.0));
                break;
            case "rho":
                rhorhoo = input.getInputValue();
                mach = Math.sqrt(2.*((1./Math.pow(rhorhoo,(gamma-1.0)))-1.0)/(gamma-1.0));
                break;
            case "areasub":
            case "areasuper":
                double mnew = (input.getInputType() == "areasuper") ? 2.0 : 0.00001;
                mach = 0.0;
                double phi;
                double s;
                while( Math.abs(mnew-mach) > 0.000001) {
                    mach = mnew;
                    phi = aas(gamma, mach);
                    s = (3.0 - gamma) / (1.0 + gamma);
                    mnew= mach - (phi - input.getInputValue()) / (Math.pow(phi * mach,s) - phi / mach);
                }
                break;
            case "machangle":
                machangle = input.getInputValue();
                mach = 1.0/Math.sin(machangle*3.14159265359/180.0);
                break;
            case "pmangle":
                mnew = 2.0 ;
                mach = 0.0;
                double fm;
                double fdm;
                while( Math.abs(mnew - mach) > 0.00001) {
                    mach = mnew;
                    fm = (nu(mach, gamma) - input.getInputValue())*3.14159265359/180.0;
                    fdm = Math.sqrt(mach*mach - 1.0)/(1+0.5*(gamma - 1.0)*mach*mach)/mach;
                    mnew = mach-fm/fdm;
                }
                break;
            default:
                mach = 0.0;
                break;
        }
        tto = tto(mach, gamma);
        if(mach>1.0) {
            machangle = Math.asin(1.0/mach)*180.0/3.14159265359;
            pmangle = nu(mach, gamma);
        }
        else if (mach==1) {
            machangle = 90.0;
            pmangle = 0.0;
        }
        else {
            machangle = 0.0;
            pmangle = 0.0;
        }
        ppo = ppo(mach, gamma);
        rhorhoo = rro(mach, gamma);
        ppstar = pps(mach, gamma);
        rhorhostar = rrs(mach, gamma);
        ttstar = tts(mach, gamma);
        aastar = aas(mach, gamma);
        isentropicFlow = new Isentropic(gamma, mach, machangle, pmangle, ppo, rhorhoo, tto, ppstar, rhorhostar, ttstar, aastar);
        return isentropicFlow;
    }
}
