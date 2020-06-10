package local.sierraog.compflow.services;

import local.sierraog.compflow.exceptions.IncorrectInputTypeException;
import local.sierraog.compflow.exceptions.InputOutOfBoundsException;
import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.NormalShock;
import org.springframework.stereotype.Service;

@Service(value = "normalService")
public class NormalShockServiceImpl extends NormBaseFunctions {
    @Override
    public NormalShock findNormalFlow(Input input){
        NormalShock normalFlow;
        double gamma = input.getGamma();
        double mach;
        double mach2;
        double po2po1;
        double p1po2;
        double p2p1;
        double rho2rho1;
        double t2t1;

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
            case "mach2":
                if(input.getInputValue() >= 1.0 || input.getInputValue() <= Math.sqrt((gamma - 1.0)/2.0/gamma)) {
                    throw new InputOutOfBoundsException("M2 must be between " + Math.sqrt((gamma - 1.0) / 2.0 / gamma) + " and 1");
                }
                mach = mach2(input.getInputValue(), gamma);
                break;
            case "pres":
                if (input.getInputValue() <= 1.0){
                    throw new InputOutOfBoundsException("P2/P1 must be greater than 1");
                }
                mach = Math.sqrt((input.getInputValue() - 1.0)*(gamma + 1.0)/2.0/gamma + 1.0);
                break;
            case "rho":
                if(input.getInputValue() <= 1.0 || input.getInputValue() >= (gamma + 1.0)/(gamma - 1.0)) {
                    throw new InputOutOfBoundsException("rho2/rho1 must be between 1 and "+ ((gamma + 1.0)/(gamma - 1.0)));
                }
                mach = Math.sqrt(2.0*input.getInputValue()/(gamma + 1.0 - input.getInputValue()*(gamma - 1.0)));
                break;
            case "temp":
                if (input.getInputValue() <= 1.0){
                    throw new InputOutOfBoundsException("T2/T1 must be greater than 1");
                }
                double aa=2.0*gamma*(gamma-1.0);
                double bb=4.0*gamma-(gamma-1.0)*(gamma-1.0)-input.getInputValue()*(gamma+1.0)*(gamma+1.0);
                double cc=-2.0*(gamma-1.0);
                mach = Math.sqrt((-bb+Math.sqrt(bb*bb-4.0*aa*cc))/2.0/aa);
                break;
            case "stagpres":
                if(input.getInputValue() >= 1.0 || input.getInputValue() <= 0.0) {
                    throw new InputOutOfBoundsException("P02/P01 must be between 0 and 1");
                }
                double mnew = 2.0;
                mach = 0.0;
                double al;
                double be;
                double daldm1;
                double dbedm1;
                double fm;
                double fdm;
                while( Math.abs(mnew - mach) > 0.00001) {
                    mach = mnew;
                    al = (gamma + 1.0)*mach*mach/((gamma - 1.0)*mach*mach + 2.0);
                    be = (gamma + 1.0)/(2.0*gamma*mach*mach-(gamma - 1.0));
                    daldm1 = (2.0/mach - 2.0*mach*(gamma - 1.0)/((gamma - 1.0)*mach*mach+2.0))*al;
                    dbedm1 = -4.0*gamma*mach*be/(2.0*gamma*mach*mach-(gamma - 1.0));
                    fm = Math.pow(al,gamma/(gamma - 1.0))*Math.pow(be,1.0/(gamma-1.0))-input.getInputValue();
                    fdm = gamma/(gamma - 1.0)*Math.pow(al,1.0/(gamma - 1.0))*daldm1*Math.pow(be, 1.0/(gamma - 1.0))+Math.pow(al, gamma/(gamma - 1.0))/(gamma - 1.0)*Math.pow(be,(2.0 - gamma)/(gamma - 1.0))*dbedm1;
                    mnew = mach - fm/fdm;
                }
            case "presstagpres":
                double vmax=Math.pow((gamma + 1.0)/2.0,-gamma/(gamma - 1.0));
                if(input.getInputValue() >= vmax || input.getInputValue() <= 0.0) {
                    throw new InputOutOfBoundsException("p1/p02 must be between 0 and "+ vmax);
                }
                mnew = 2.0;
                mach = 0.0;
                while( Math.abs(mnew - mach) > 0.00001) {
                    mach = mnew;
                    al = (gamma + 1.0)*mach*mach/2.0;
                    be = (gamma + 1.0)/(2.0*gamma*mach*mach-(gamma - 1.0));
                    daldm1 = mach*(gamma + 1.0);
                    dbedm1 = -4.0*gamma*mach*be/(2.0*gamma*mach*mach-(gamma - 1.0));
                    fm = Math.pow(al, gamma/(gamma - 1.0))*Math.pow(be, 1.0/(gamma - 1.0))-1.0/input.getInputValue();
                    fdm = gamma/(gamma - 1.0)*Math.pow(al, 1/(gamma - 1.0))*daldm1*Math.pow(be, 1.0/(gamma - 1.0))+Math.pow(al, gamma/(gamma - 1.0))/(gamma - 1.0)*Math.pow(be, (2.0 - gamma)/(gamma - 1.0))*dbedm1;
                    mnew = mach-fm/fdm;
                }
            default:
                throw new IncorrectInputTypeException();
        }
        mach2 = mach2(mach, gamma);
        p2p1 = 1.0 + 2.0*gamma/(gamma+1.0)*(mach*mach - 1.0);
        po2po1 = ppo(mach, gamma)/ppo(mach2, gamma)*p2p1;
        rho2rho1 = rro(mach2, gamma)/rro(mach, gamma)*po2po1;
        t2t1 = tto(mach2, gamma)/tto(mach, gamma);
        p1po2 = ppo(mach, gamma)/po2po1;
        normalFlow = new NormalShock(gamma, mach, mach2, po2po1, p1po2, p2p1, rho2rho1, t2t1);
        return normalFlow;
    }
}
