package local.sierraog.compflow.models;

public class NormalShock {
    private double gamma;

    private double mach;

    private double mach2;

    private double po2po1;

    private double p1po2;

    private double p2p1;

    private double rho2rho1;

    private double t2t1;

    public NormalShock() {
    }

    public NormalShock(double gamma, double mach, double mach2, double po2po1, double p1po2, double p2p1, double rho2rho1, double t2t1) {
        this.gamma = gamma;
        this.mach = mach;
        this.mach2 = mach2;
        this.po2po1 = po2po1;
        this.p1po2 = p1po2;
        this.p2p1 = p2p1;
        this.rho2rho1 = rho2rho1;
        this.t2t1 = t2t1;
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

    public double getMach2() {
        return mach2;
    }

    public void setMach2(double mach2) {
        this.mach2 = mach2;
    }

    public double getPo2po1() {
        return po2po1;
    }

    public void setPo2po1(double po2po1) {
        this.po2po1 = po2po1;
    }

    public double getP1po2() {
        return p1po2;
    }

    public void setP1po2(double p1po2) {
        this.p1po2 = p1po2;
    }

    public double getP2p1() {
        return p2p1;
    }

    public void setP2p1(double p2p1) {
        this.p2p1 = p2p1;
    }

    public double getRho2rho1() {
        return rho2rho1;
    }

    public void setRho2rho1(double rho2rho1) {
        this.rho2rho1 = rho2rho1;
    }

    public double getT2t1() {
        return t2t1;
    }

    public void setT2t1(double t2t1) {
        this.t2t1 = t2t1;
    }

}
