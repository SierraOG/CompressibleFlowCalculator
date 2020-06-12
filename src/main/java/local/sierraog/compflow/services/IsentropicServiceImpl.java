package local.sierraog.compflow.services;

import local.sierraog.compflow.exceptions.IncorrectInputTypeException;
import local.sierraog.compflow.exceptions.InputOutOfBoundsException;
import local.sierraog.compflow.models.Isentropic;
import org.springframework.stereotype.Service;

@Service(value = "isentropicService")
public class IsentropicServiceImpl extends IsentBaseFunctions {
    @Override
    public Isentropic findIsentropicFlow(double gamma, String inputType, double inputValue){
        Isentropic isentropicFlow;
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
            case "temp":
                tto = inputValue;
                if (tto >= 1.0 || tto <= 0.0){
                    throw new InputOutOfBoundsException("T/T0 must be between 0 and 1");
                }
                mach = Math.sqrt(2.0*((1.0/tto)-1.0)/(gamma-1.0));
                break;
            case "pres":
                ppo = inputValue;
                if (ppo >= 1.0 || ppo <= 0.0){
                    throw new InputOutOfBoundsException("P/P0 must be between 0 and 1");
                }
                mach = Math.sqrt(2.0*((1.0/Math.pow(ppo,(gamma-1.0)/gamma))-1.0)/(gamma-1.0));
                break;
            case "rho":
                rhorhoo = inputValue;
                if (rhorhoo >= 1.0 || rhorhoo <= 0.0){
                    throw new InputOutOfBoundsException("rho/rho0 must be between 0 and 1");
                }
                mach = Math.sqrt(2.*((1./Math.pow(rhorhoo,(gamma-1.0)))-1.0)/(gamma-1.0));
                break;
            case "areasub":
            case "areasuper":
                if (inputValue <= 1.0){
                    throw new InputOutOfBoundsException("A/A* must be greater than 1");
                }
                double mnew = (inputType == "areasuper") ? 2.0 : 0.00001;
                mach = 0.0;
                double phi;
                double s;
                while( Math.abs(mnew-mach) > 0.000001) {
                    mach = mnew;
                    phi = aas(gamma, mach);
                    s = (3.0 - gamma) / (1.0 + gamma);
                    mnew= mach - (phi - inputValue) / (Math.pow(phi * mach,s) - phi / mach);
                }
                break;
            case "machangle":
                machangle = inputValue;
                if (machangle <= 0.0 || machangle >= 90.0){
                    throw new InputOutOfBoundsException("Mach angle must be between 0 and 90 degrees");
                }
                mach = 1.0/Math.sin(machangle*3.14159265359/180.0);
                break;
            case "pmangle":
                double numax = (Math.sqrt((gamma + 1.0)/(gamma - 1.0)) - 1.0)*90.0;
                if (inputValue <= 0.0 || inputValue >= numax){
                    throw new InputOutOfBoundsException("Prandtl-Meyer angle must be between 0 and " + numax);
                }
                mnew = 2.0 ;
                mach = 0.0;
                double fm;
                double fdm;
                while( Math.abs(mnew - mach) > 0.00001) {
                    mach = mnew;
                    fm = (nu(mach, gamma) - inputValue)*3.14159265359/180.0;
                    fdm = Math.sqrt(mach*mach - 1.0)/(1+0.5*(gamma - 1.0)*mach*mach)/mach;
                    mnew = mach-fm/fdm;
                }
                break;
            default:
                throw new IncorrectInputTypeException();
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
