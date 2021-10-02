class Main {
    public static void main(String[] args) {
        //экземпляр класса Calculator через вызов статической переменной instance
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        int d = calc.multiply.apply(2, 4);
        int e = calc.pow.apply(3);
        int f = calc.abs.apply(4);
        boolean g = calc.isPositive.test(3);

        calc.println.accept(c);
        calc.println.accept(d);
        calc.println.accept(e);
        calc.println.accept(f);
        System.out.println(g);
    }
}
