package local.sierraog.compflow.models;

public class Fanno {
    private double gamma;

    private double mach;

    private double ttstar;

    private double ppstar;

    private double popostar;

    private double uustar;

    private double flstard;

    private double sstarsr;

    public Fanno() {
    }

    public Fanno(double gamma, double mach, double ttstar, double ppstar, double popostar, double uustar, double flstard, double sstarsr) {
        this.gamma = gamma;
        this.mach = mach;
        this.ttstar = ttstar;
        this.ppstar = ppstar;
        this.popostar = popostar;
        this.uustar = uustar;
        this.flstard = flstard;
        this.sstarsr = sstarsr;
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

    public double getTtstar() {
        return ttstar;
    }

    public void setTtstar(double ttstar) {
        this.ttstar = ttstar;
    }

    public double getPpstar() {
        return ppstar;
    }

    public void setPpstar(double ppstar) {
        this.ppstar = ppstar;
    }

    public double getPopostar() {
        return popostar;
    }

    public void setPopostar(double popostar) {
        this.popostar = popostar;
    }

    public double getUustar() {
        return uustar;
    }

    public void setUustar(double uustar) {
        this.uustar = uustar;
    }

    public double getFlstard() {
        return flstard;
    }

    public void setFlstard(double flstard) {
        this.flstard = flstard;
    }

    public double getSstarsr() {
        return sstarsr;
    }

    public void setSstarsr(double sstarsr) {
        this.sstarsr = sstarsr;
    }

}
