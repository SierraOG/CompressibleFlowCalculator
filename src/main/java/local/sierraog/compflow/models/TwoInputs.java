package local.sierraog.compflow.models;

public class TwoInputs {
    private double gamma;
    private double mach;
    private double secondInputValue;
    private String secondInputType;

    public TwoInputs() {
    }

    public TwoInputs(double gamma, double mach, double secondInputValue, String secondInputType) {
        this.gamma = gamma;
        this.mach = mach;
        this.secondInputValue = secondInputValue;
        this.secondInputType = secondInputType;
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

    public double getSecondInputValue() {
        return secondInputValue;
    }

    public void setSecondInputValue(double secondInputValue) {
        this.secondInputValue = secondInputValue;
    }

    public String getSecondInputType() {
        return secondInputType;
    }

    public void setSecondInputType(String secondInputType) {
        this.secondInputType = secondInputType;
    }
}
