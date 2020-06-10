package local.sierraog.compflow.services;

abstract class RayBaseFunctions implements RayleighService {
    double pps(double mach, double gamma) {
        return (1.0 + gamma)/(1.0 + gamma*mach*mach);
    }
    double tts(double mach, double gamma) {
        return mach*mach*Math.pow((1.0 + gamma)/(1.0 + gamma*mach*mach),2.0);
    }
    double rrs(double mach, double gamma){
        return 1.0/(mach*mach)*(1.0 + gamma*mach*mach)/(1.0 + gamma);
    }
    double popos(double mach, double gamma){
        return (1.0 + gamma)/(1.0 + gamma*mach*mach)*Math.pow((2.0 + (gamma - 1.0)*mach*mach)/(gamma + 1.0) , gamma/(gamma - 1.0));
    }
    double totos(double mach, double gamma){
        return ((gamma + 1.0)*mach*mach)/Math.pow(1.0 + gamma*mach*mach, 2.0)*(2.0 + (gamma - 1.0)*mach*mach);
    }
    double uus(double mach, double gamma){
        return ((gamma + 1.0)*mach*mach)/(1.0+gamma*mach*mach);
    }
    double sstarscp(double mach, double gamma){
        return Math.log(1/(mach*mach)*Math.pow((1 + gamma*mach*mach)/(1.0 + gamma), (gamma+1.0)/gamma));
    }
    double ssr(double mach, double gamma){
        return  sstarscp(mach, gamma)*gamma/(gamma - 1.0);
    }
}
