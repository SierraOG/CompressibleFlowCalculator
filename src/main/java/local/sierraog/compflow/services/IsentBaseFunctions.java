package local.sierraog.compflow.services;

abstract class IsentBaseFunctions implements IsentropicService {
    public double tto(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0);
    }
    public double ppo(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-gamma/(gamma-1.0));
    }
    public double rro(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0/(gamma-1.0));
    }
    public double tts(double mach, double gamma){
        return tto(mach, gamma)*(gamma/2.0 + 0.5);
    }
    public double pps(double mach, double gamma){
        return ppo(mach, gamma)*Math.pow((gamma/2.0 + 0.5),gamma/(gamma-1.0));
    }
    public double rrs(double mach, double gamma){
        return rro(mach, gamma)*Math.pow((gamma/2.0 + 0.5),1.0/(gamma-1.0));
    }
    public double aas(double mach, double gamma){
        return 1.0/rrs(mach, gamma)*Math.sqrt(1.0/tts(mach, gamma))/mach;
    }
    public double nu(double mach, double gamma){
        double n=Math.sqrt((gamma + 1.0) / (gamma - 1.0)) * Math.atan(Math.sqrt((gamma - 1.0) / (gamma + 1.0) * (mach * mach - 1.0)));
        n=n - Math.atan(Math.sqrt(mach * mach - 1.0));
        n=n*180./3.14159265359;
        return n;
    }
}
