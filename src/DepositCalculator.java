package src;

import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double a, double y, int d) { //я бы переименовал эти методы в более понятные типа calculateWithCompounding
        double pay = a * Math.pow((1 + y / 12), 12 * d); //здесь, мне кажется, также стоит параметры прописать словами, вместо a, y и d 
        return doRound(pay, 2); //можно просто round, это тоже глагол будет
        //return по канонам, вроде, должен быть с отбивкой строки
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return doRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double doRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void Calculate() {//с маленькой буквы по идее должно быть, это же метод
        int period;
        int action;
        double out = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().Calculate();
    }
}
