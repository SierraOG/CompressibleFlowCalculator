package local.sierraog.compflow.models;

public class Input {
    private double gamma;
    private double inputValue;
    private String inputType;

    public Input() {
    }

    public Input(double gamma, double inputValue, String inputType) {
        this.gamma = gamma;
        this.inputValue = inputValue;
        this.inputType = inputType;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getInputValue() {
        return inputValue;
    }

    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
}
