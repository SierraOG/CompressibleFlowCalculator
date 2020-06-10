package local.sierraog.compflow.services;

abstract class NormBaseFunctions implements NormalShockService {
    public double mach2(double mach1, double gamma){
        return Math.sqrt((1.0 + 0.5 * (gamma - 1.0) * mach1 * mach1) / (gamma * mach1 * mach1 - 0.5 * (gamma - 1.0)));
    }
    public double tto(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0);
    }
    public double ppo(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-gamma/(gamma-1.0));
    }
    public double rro(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0/(gamma-1.0));
    }
}
