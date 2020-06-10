package local.sierraog.compflow.models;

public class ObliqueShock {
    private double gamma;

    private double mach;

    private double mach2;

    private double theta;

    private double beta;

    private double po2po1;

    private double p2p1;

    private double rho2rho1;

    private double t2t1;

    private double m1n;

    private double m2n;

    public ObliqueShock() {
    }

    public ObliqueShock(double gamma, double mach, double mach2, double theta, double beta, double po2po1, double p2p1, double rho2rho1, double t2t1, double m1n, double m2n) {
        this.gamma = gamma;
        this.mach = mach;
        this.mach2 = mach2;
        this.theta = theta;
        this.beta = beta;
        this.po2po1 = po2po1;
        this.p2p1 = p2p1;
        this.rho2rho1 = rho2rho1;
        this.t2t1 = t2t1;
        this.m1n = m1n;
        this.m2n = m2n;
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

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getPo2po1() {
        return po2po1;
    }

    public void setPo2po1(double po2po1) {
        this.po2po1 = po2po1;
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

    public double getM1n() {
        return m1n;
    }

    public void setM1n(double m1n) {
        this.m1n = m1n;
    }

    public double getM2n() {
        return m2n;
    }

    public void setM2n(double m2n) {
        this.m2n = m2n;
    }

}
