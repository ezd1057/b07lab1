public class Polynomial {
    public double[] coeffs;

    public Polynomial() {
        coeffs = new double[]{0};
    }

    public Polynomial(double[] arr) {
        coeffs = new double[arr.length];
        for (int i = 0; i < arr.length; i++) coeffs[i] = arr[i];
    }

    public Polynomial add(Polynomial p) {
        double[] newCoeffs;
        int i;
        if (coeffs.length < p.coeffs.length) {
            newCoeffs = new double[p.coeffs.length];
            for (i = 0; i < coeffs.length; i++) newCoeffs[i] = coeffs[i] + p.coeffs[i];
            for (i = coeffs.length; i < p.coeffs.length; i++) newCoeffs[i] = p.coeffs[i];
        } else if (coeffs.length > p.coeffs.length) {
            newCoeffs = new double[coeffs.length];
            for (i = 0; i < p.coeffs.length; i++) newCoeffs[i] = coeffs[i] + p.coeffs[i];
            for (i = p.coeffs.length; i < coeffs.length; i++) newCoeffs[i] = coeffs[i];
        } else {
            newCoeffs = new double[coeffs.length];
            for (i = 0; i < coeffs.length; i++) newCoeffs[i] = coeffs[i] + p.coeffs[i];
        }
        return new Polynomial(newCoeffs);
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coeffs.length; i++) result += coeffs[i] * Math.pow(x, i);
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }
}