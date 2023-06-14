package model;

/**
 * Класс Calculator отвечает за расчёт необходимых данных. Он содержит в себе 4 переменные, значения которых берутся из базы данных и 7 переменных для получения 7 различных результатов вычисления. Также имеет геттеры и сеттеры для доступа к содержимому.
 */
public class Calculator {
    private double a; // yes yes
    private double b; // yes no
    private double c; // no yes
    private double d; // no no

    /**
     * Метод calcSensitivity() – производит вычисление значения и возвращает результат вычислений chuvs.
     *
     * @return
     */
    public double calcSensitivity(double a, double b) {
        return Math.round(a / (a + b) * 100);
    }

    /**
     * Метод calcSpec() – производит вычисление значения и возвращает результат вычислений в переменную spec.
     *
     * @return
     */
    public double calcSpecificity(double c, double d) {
        return Math.round(d / (d + c) * 100);
    }

    public double calcPrecision(double a, double c) {
        return Math.round(a / (a + c) * 100);
    }

    public double calcNPV(double b, double d) {
        return Math.round(d / (d + b) * 100);
    }

    public double calcFNR(double b, double a) {
        return Math.round(b / (b + a) * 100);
    }

    public double calcFPR(double c, double d) {
        return Math.round(c / (c + d) * 100);
    }

    public double calcFDR(double c, double a) {
        return Math.round(c / (c + a) * 100);
    }

    public double calcFOR(double b, double d) {
        return Math.round(b / (b + d) * 100);
    }

    public double calcLRplus(double chuys, double spec) {
        return Math.round(chuys / spec);
    }

    public double calcLRmin(double fnr, double spec) {
        return Math.round(fnr / spec);
    }

    public double calcPrevalence(double a, double b, double c, double d) {
        return Math.round((a + b) / (a + b + c + d) * 100);
    }

    public double calcACC(double a, double b, double c, double d) {
        return Math.round((a + d) / (a + b + c + d) * 100);
    }
}




