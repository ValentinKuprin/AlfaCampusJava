public class MathTask {
    public static void main(String[] args) {

        int sideAB = 35;
        int sideBC = 65;
        int cornerAB = 45;

        int areaTriangle = (int) Math.round(0.5 * sideAB * sideBC * Math.sin(Math.toRadians(cornerAB)));
        System.out.println("Площадь треугольника со сторонами " + sideAB + " и " + sideBC + " и углом " + cornerAB
                + " градусов равна " + areaTriangle);

        int radius = 9;
        int areaCircle = (int) Math.round(Math.PI * Math.pow(radius, 2));
        System.out.println("Площадь круга с радиусом " + radius + " равна " + areaCircle);


        int randomNumber = (int) (Math.random() * 101);
        System.out.println("Случайное целое число от 0 до 100: " + randomNumber);


        int[][] doubleDArray = new int[5][5];

        for (int i = 0; i < doubleDArray.length; i++) {
            for (int j = 0; j < doubleDArray.length; j++) {
                doubleDArray[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < doubleDArray.length; i++) {
            for (int j = 0; j < doubleDArray.length; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(doubleDArray[i][j]);
            }
            System.out.println();
        }
    }
}
