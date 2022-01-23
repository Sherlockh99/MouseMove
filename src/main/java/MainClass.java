import java.awt.*;

public class MainClass {
    public static void main(String[] args) throws AWTException{
        moveMouse(200,200,400,400,5);
        moveMouse(400,200,200,400,10);
        moveMouse(400,600,200,200,3);
    }

    /*
    x1,y1 - начальная точка курсора
    x2,y2 - конечная точка курсора
    step - интервал генерирования случайного числа
     */
    private static void moveMouse(int x1, int y1, int x2, int y2,int step) throws AWTException {
        int j;
        int startX = x1;
        int startY = y1;

        Robot robot = new Robot();
        //пока курсор не дойдет до x2,y2 выполняем цикл
        while(!(x1==x2 && y1==y2)){
            j = (int)(Math.random() * step); //генерим число от 0 до step
            if(startX<x2) {
                x1 = x1 + j;
                if (x1 > x2) {
                    x1 = x2;
                }
            }else {
                x1 = x1 - j;
                if (x1 < x2) {
                    x1 = x2;
                }
            }

            j = (int)(Math.random() * step);
            if(startY<y2){
                y1=y1+j;
                if(y1>y2){
                    y1=y2;
                }
            }else{
                y1 = y1-j;
                if(y1<y2){
                    y1=y2;
                }
            }
            robot.delay(10); //задержка
            robot.mouseMove(x1,y1); //перемещение мышки
        }
    }
}
