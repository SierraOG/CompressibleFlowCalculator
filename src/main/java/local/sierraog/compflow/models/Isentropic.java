package local.sierraog.compflow.models;

public class Isentropic {
    private double gamma;

    private double mach;

    private double machangle;

    private double pmangle;

    private double ppo;

    private double rhorhoo;

    private double tto;

    private double ppstar;

    private double rhorhostar;

    private double ttstar;

    private double aastar;

    public Isentropic() {
    }

    public Isentropic(double gamma, double mach, double machangle, double pmangle, double ppo, double rhorhoo, double tto, double ppstar, double rhorhostar, double ttstar, double aastar) {
        this.gamma = gamma;
        this.mach = mach;
        this.machangle = machangle;
        this.pmangle = pmangle;
        this.ppo = ppo;
        this.rhorhoo = rhorhoo;
        this.tto = tto;
        this.ppstar = ppstar;
        this.rhorhostar = rhorhostar;
        this.ttstar = ttstar;
        this.aastar = aastar;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getMach() {
        return mach;
    }

    public void setMach(double mach) {
        this.mach = mach;
    }

    public double getMachangle() {
        return machangle;
    }

    public void setMachangle(double machangle) {
        this.machangle = machangle;
    }

    public double getPmangle() {
        return pmangle;
    }

    public void setPmangle(double pmangle) {
        this.pmangle = pmangle;
    }

    public double getPpo() {
        return ppo;
    }

    public void setPpo(double ppo) {
        this.ppo = ppo;
    }

    public double getRhorhoo() {
        return rhorhoo;
    }

    public void setRhorhoo(double rhorhoo) {
        this.rhorhoo = rhorhoo;
    }

    public double getTto() {
        return tto;
    }

    public void setTto(double tto) {
        this.tto = tto;
    }

    public double getPpstar() {
        return ppstar;
    }

    public void setPpstar(double ppstar) {
        this.ppstar = ppstar;
    }

    public double getRhorhostar() {
        return rhorhostar;
    }

    public void setRhorhostar(double rhorhostar) {
        this.rhorhostar = rhorhostar;
    }

    public double getTtstar() {
        return ttstar;
    }

    public void setTtstar(double ttstar) {
        this.ttstar = ttstar;
    }

    public double getAastar() {
        return aastar;
    }

    public void setAastar(double aastar) {
        this.aastar = aastar;
    }
}
