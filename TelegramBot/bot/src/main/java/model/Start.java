package model;

public class Start {
    private Calculator calculator;
    private int a;
    private int b;
    private int c;
    private int d;

    private double chuys;
    private double spec;
    private double ppv;
    private double npv;
    private double fnr;
    private double fpr;
    private double fdr;
    private double forr;
    private double lrpl;
    private double lrmin;
    private double rasp;
    private double acc;



    public Start(){
        calculator = new Calculator();
    }

    public String action() {
        return "Калькулятор расчета статистических данных" +"\n" +
                "Введите данные для расчета (через проблел : \n" +
                "истинно-положительный результат (true-positive, TP) — заболевание есть, тест положительный;\n" +
                "ложно-отрицательный результат (false-negative, FN) — заболевание есть, тест отрицательный; \n" +
                "ложно-положительный результат (false-positive, FP) — заболевания нет, тест положительный;\n" +
                "истинно-отрицательный результат (true-negative, TN) — заболевания нет, тест отрицательный)";
    }

    public void calculate(String answer){
        String[] numbers = answer.split(" ");
        if (numbers.length < 4) {
            // Обработка ошибки недостаточного количества чисел
            return;
        }

        try {
           a = Integer.parseInt(numbers[0]);
             b = Integer.parseInt(numbers[1]);
             c = Integer.parseInt(numbers[2]);
           d = Integer.parseInt(numbers[3]);

            chuys = calculator.calcSensitivity(a, b);
            spec = calculator.calcSpecificity(c, d);
            ppv = calculator.calcPrecision(a, c);
            npv = calculator.calcNPV(b, d);
            fnr = calculator.calcFNR(b, a);
            fpr = calculator.calcFPR(c, d);
            fdr = calculator.calcFDR(c, a);
            forr =calculator.calcFOR(b, d);
            lrpl = calculator.calcLRplus(chuys, spec);
            lrmin = calculator.calcLRmin(fnr, spec);
            rasp = calculator.calcPrevalence(a, b, c, d);
            acc = calculator.calcACC(a, b, c, d);

        } catch (NumberFormatException e) {
            return;
        }
    }

    public String end() {
        return "                 Таблица сопряженности" + "\n" +
                "Матрица       |"  +   "Тест положительный |"  + "Тест отрицательный"   +"\n" +
                "Заболевание есть |               " +         a + "        |       " + b + "\n" +
                "Заболевания нет  |              " +  c +        "         |       " + d + "\n" +
                "\n"+
                "Результаты расчета: " + "\n" +
                "\n"+
                "Чувствительность = " + chuys  + " %" + "\n"+
                "Специфичность = " + spec +  " %" +"\n" +
                "Положительная прогностическая ценность = " + ppv +  " %" +"\n" +
                "Отрицательная прогностическая ценность = " + npv + " %" +"\n" +
                "Частота ложноотрицательных результатов = " + fnr +  " %" + "\n" +
                "Частота ложных выпадений = " + fpr  + " %" + "\n" +
                "Частота ложных открытий = " + fdr + " %" + "\n" +
                "Частота ложных пропусков = " + forr  + " %" + "\n" +
                "Положительное отношение правдоподобия = " + lrpl  +  "\n" +
                "Отрицательное отношение правдоподобия = " + lrmin  +  "\n" +
                "Распространенность = " + rasp  + " %" + "\n" +
                "Точность = " + acc  + " %" + "\n" ;

    }
}
