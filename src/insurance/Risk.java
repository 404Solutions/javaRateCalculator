package insurance;

public abstract class Risk {

    private double basePremium;
    private double valueBase;
    private double valueFactor;

    Risk(double basePremium, double valueBase, double valueFactor) {
        this.basePremium = basePremium;
        this.valueBase = valueBase;
        this.valueFactor = valueFactor;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }

    public double getValueBase() {
        return valueBase;
    }

    public void setValueBase(double valueBase) {
        this.valueBase = valueBase;
    }

    public double getValueFactor() {
        return valueFactor;
    }

    public void setValueFactor(double valueFactor) {
        this.valueFactor = valueFactor;
    }
}
