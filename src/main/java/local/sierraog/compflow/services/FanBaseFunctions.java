package local.sierraog.compflow.services;

abstract class FanBaseFunctions implements FannoService {
    double tts(double mach, double gamma){
        return (gamma + 1.0)/ (2.0 + (gamma - 1.0)*mach*mach);
    }
    double pps(double mach, double gamma){
        return 1.0/mach*Math.pow((gamma + 1.0)/(2.0 + (gamma - 1.0)*mach*mach) , 0.5);
    }
    double rrs(double mach, double gamma){
        return 1.0/mach*Math.pow((2.0 + (gamma - 1.0)*mach*mach)/(gamma + 1.0), 0.5);
    }
    double popos(double mach, double gamma){
        return 1.0/mach*Math.pow((2.0 + (gamma - 1.0)*mach*mach)/(gamma + 1.0), (gamma + 1.0)/(2*(gamma - 1.0)));
    }
    double uus(double mach, double gamma){
        return mach*Math.sqrt((gamma + 1.0)/(2.0*(1.0+(gamma-1.0)/2.0*mach*mach)));
    }
    double flsd(double mach, double gamma){
        return (1.0 - mach*mach)/(gamma*mach*mach) + (gamma + 1.0)/(2.0*gamma)* Math.log(((gamma + 1.0)*mach*mach)/(2.0 + (gamma - 1.0)*mach*mach));
    }
    double ssr(double mach, double gamma){
        return -Math.log(1.0/popos(mach, gamma));
    }
}
