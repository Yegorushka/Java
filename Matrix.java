package matrix;

import java.io.*;
import java.util.*;

public class Matrix{
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        while(true) {   //цикл для запроса на повтор 
            Scanner in = new Scanner(System.in);
            File file = new File("Данные в текстовом файле");
            try (PrintWriter pw = new PrintWriter(file)) {//запись в файл
            //Thread.sleep(300); задеркжка в 0,3 сек

            System.out.println("Это программа создана для реализации алгоритма для вычисления обратной матрицы");Thread.sleep(300);
            System.out.println("Так как для этой реализации используются только квадратные матрицы");Thread.sleep(300);
            System.out.println("Все данные хранятся в файле <--Данные в текстовом файле-->");Thread.sleep(300);
            System.out.print("Хотите ли вы ввести данные матрицы или это все сделает рандомайзер?[Y/N]-->");

            String y_n = in.nextLine();
            boolean strsw1 = y_n.startsWith("Y");
            boolean strsw2 = y_n.startsWith("y");
            boolean strsw3 = y_n.startsWith("N");
            boolean strsw4 = y_n.startsWith("n");

            if(strsw1 == true || strsw2 == true || strsw3 == true || strsw4 == true){
            if(strsw1 == true || strsw2 == true){
            float[][] obrat = new float[3][3];
            float[][] e = new float[3][3];
            for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
            int q = i + 1, r = j + 1;
            System.out.print("\tВведитеданныематрицыА"+q+r+" - ");
            e[i][j] = in.nextInt();pw.println("\tВведитеданныематрицыА"+r+q+" - "+e[i][j]);}}
            System.out.println("----------------------------------------");Thread.sleep(300);
            pw.println("----------------------------------------");
            for (float[] e1 : e) {
            for (int j = 0; j < e[0].length; j++) {
            System.out.printf("%4.0f",e1[j]);
            pw.printf("%4.0f",e1[j]);}
            System.out.println();
            pw.println();}
            System.out.println("----------------------------------------");Thread.sleep(300);
            pw.println("----------------------------------------");
            System.out.println("Вычисляемопределительматрицы:");Thread.sleep(200);
            pw.println("Вычисляем определитель матрицы:");

            float opred1 = e[0][0] * e[1][1] * e[2][2];
            float opred2 = e[0][1] * e[1][2] * e[2][0];
            float opred3 = e[0][2] * e[1][0] * e[2][1];
            float opred4 = e[0][2] * e[1][1] * e[2][0];
            float opred5 = e[0][1] * e[1][0] * e[2][2];
            float opred6 = e[0][0] * e[1][2] * e[2][1];
            float a = opred4 + opred5 + opred6;
            float b = opred1 + opred2 + opred3;
            float opred = b - a;

            System.out.printf("%4.0f",opred);
            pw.printf("%4.0f",opred);
            System.out.println("\nНаходимматрицуалебраическихдополненийА:");Thread.sleep(200);
            pw.println("\nНаходим матрицу алебраических дополнений А:");

            float c, d;
            if(opred> 0){d = -1;c = 1;}else{d = 1;c = -1;}

            obrat[0][0] = (e[1][1]*e[2][2]-e[2][1]*e[1][2])*d;
            obrat[1][0] = (e[1][0]*e[2][2]-e[2][0]*e[1][2])*c;
            obrat[2][0] = (e[1][0]*e[2][1]-e[2][0]*e[1][1])*d;

            obrat[0][1] = (e[0][1]*e[2][2]-e[2][1]*e[0][2])*c;
            obrat[1][1] = (e[0][0]*e[2][2]-e[2][0]*e[0][2])*d;
            obrat[2][1] = (e[0][0]*e[1][2]-e[0][2]*e[1][0])*c;

            obrat[0][2] = (e[0][1]*e[1][2]-e[1][1]*e[0][2])*d;
            obrat[1][2] = (e[0][0]*e[2][1]-e[0][1]*e[2][0])*c;
            obrat[2][2] = (e[0][0]*e[1][1]-e[1][0]*e[0][1])*d;

            System.out.println("A 1,1:\t"+obrat[0][0]);pw.println("A 1,1:\t"+obrat[0][0]);                        
            System.out.println("A 1,2:\t"+obrat[1][0]);pw.println("A 2,1:\t"+obrat[1][0]);                        
            System.out.println("A 1,3:\t"+obrat[2][0]);pw.println("A 3,1:\t"+obrat[2][0]);

            System.out.println("A 2,1:\t"+obrat[0][1]);pw.println("A 1,2:\t"+obrat[0][1]);                       
            System.out.println("A 2,2:\t"+obrat[1][1]);pw.println("A 2,2:\t"+obrat[1][1]);                      
            System.out.println("A 2,3:\t"+obrat[1][2]);pw.println("A 3,2:\t"+obrat[1][2]);

            System.out.println("A 3,1:\t"+obrat[0][2]);pw.println("A 1,3:\t"+obrat[0][2]);                
            System.out.println("A 3,2:\t"+obrat[2][1]);pw.println("A 2,3:\t"+obrat[2][1]);        
            System.out.println("A 3,3:\t"+obrat[2][2]);pw.println("A 3,3:\t"+obrat[2][2]);

            System.out.println("--------------------\nКонечный вид матрицы дополнений");
            pw.println("--------------------\nКонечный вид матрицы дополнений");Thread.sleep(300);
            for (int i = 0; i<obrat.length; i++) {
            for (int j = i+1; j <obrat.length; j++) {
            float temp = obrat[i][j];
            obrat[i][j] = obrat[j][i];
            obrat[j][i] = temp;}}

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.printf("%4.0f",obrat1[j]);
            pw.printf("%4.0f",obrat1[j]);}
            System.out.println();
            pw.println();}

            System.out.println("--------------------");pw.println("--------------------");Thread.sleep(300);

            System.out.println("Транспонируем её и находим союзную матрицу:");
            pw.println("Транспонируем её и находим союзную матрицу:");
            for (int i = 0; i<obrat.length; i++) {
            for (int j = i+1; j <obrat.length; j++) {
            float temp = obrat[i][j];
            obrat[i][j] = obrat[j][i];
            obrat[j][i] = temp;}}

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.printf("%4.0f",obrat1[j]);
            pw.printf("%4.0f",obrat1[j]);}
            System.out.println();
            pw.println();}

            System.out.println("--------------------");pw.println("--------------------");Thread.sleep(300);
            System.out.println("Обратнаяматрица: ");pw.println("Обратнаяматрица: ");
            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat.length; j++) {
            obrat1[j] = 1 / obrat1[j];}}

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.format(obrat1[j]+"    ");
            pw.print(obrat1[j] + "     ");}
            System.out.println();
            pw.println();}

            System.out.println("--------------------");pw.println("--------------------");Thread.sleep(300);
            System.out.println("Конец.");pw.println("Конец.");Thread.sleep(300);
            System.out.print("Хотите ли вы перезапустить код?[Y/N(любая клавиша)] --> ");         
            String q = in.nextLine();
                                    String y_n2 = in.nextLine();

            boolean str1 = y_n2.startsWith("Y");
            boolean str2 = y_n2.startsWith("y");
            if(str1 == true || str2 == true){//циклдля no
            System.out.println("\t\t---Перезапускаем---");pw.println("        ---Перезапускаем---");
            Thread.sleep(300);
            }else{break;}

            }else{
            float[][] obrat = new float[3][3];
            float[][] e = new float[3][3];
            if(strsw3 == true || strsw4 == true){
            Thread.sleep(200);
            System.out.println("Матрица:");
            pw.println("Матрица:");
            for (float[] e1 : e) {
            for (int j = 0; j <e.length; j++) {
            e1[j] = ((float)Math.ceil(Math.random()*9));}}
            Thread.sleep(200);

            for (float[] e1 : e) {
            for (int j = 0; j < e[0].length; j++) {
            System.out.printf("%4.0f",e1[j]);
            pw.printf("%4.0f",e1[j]);}
            System.out.println();
            pw.println();}Thread.sleep(200);

            System.out.println("--------------------\nВычисляемопределительматрицы:");Thread.sleep(300);
            pw.println("--------------------\nВычисляемопределительматрицы:");Thread.sleep(200);
            float opred1 = e[0][0] * e[1][1] * e[2][2];
            float opred2 = e[0][1] * e[1][2] * e[2][0];
            float opred3 = e[0][2] * e[1][0] * e[2][1];
            float opred4 = e[0][2] * e[1][1] * e[2][0];
            float opred5 = e[0][1] * e[1][0] * e[2][2];
            float opred6 = e[0][0] * e[1][2] * e[2][1];
            float a = opred4 + opred5 + opred6;
            float b = opred1 + opred2 + opred3;
            float opred = b - a;
            float c,d;
            if(opred> 0){d = -1;c = 1;}else{d = 1;c = -1;}
            System.out.printf("%4.0f",opred);
            pw.println(opred);
            System.out.println("\nНаходимматрицуалебраическихдополненийА:");Thread.sleep(200);
            pw.println("Находим матрицу алебраических дополнений А:");

            obrat[0][0] = (e[1][1]*e[2][2]-e[2][1]*e[1][2])*d;
            obrat[1][0] = (e[1][0]*e[2][2]-e[2][0]*e[1][2])*c;
            obrat[2][0] = (e[1][0]*e[2][1]-e[2][0]*e[1][1])*d;

            obrat[0][1] = (e[0][1]*e[2][2]-e[2][1]*e[0][2])*c;
            obrat[1][1] = (e[0][0]*e[2][2]-e[2][0]*e[0][2])*d;
            obrat[2][1] = (e[0][0]*e[1][2]-e[0][2]*e[1][0])*c;

            obrat[0][2] = (e[0][1]*e[1][2]-e[1][1]*e[0][2])*d;
            obrat[1][2] = (e[0][0]*e[2][1]-e[0][1]*e[2][0])*c;
            obrat[2][2] = (e[0][0]*e[1][1]-e[1][0]*e[0][1])*d;

            System.out.println("A 1,1:\t"+obrat[0][0]);pw.println("A 1,1:\t"+obrat[0][0]);                        
            System.out.println("A 1,2:\t"+obrat[1][0]);pw.println("A 2,1:\t"+obrat[1][0]);                        
            System.out.println("A 1,3:\t"+obrat[2][0]);pw.println("A 3,1:\t"+obrat[2][0]);

            System.out.println("A 2,1:\t"+obrat[0][1]);pw.println("A 1,2:\t"+obrat[0][1]);                       
            System.out.println("A 2,2:\t"+obrat[1][1]);pw.println("A 2,2:\t"+obrat[1][1]);                      
            System.out.println("A 2,3:\t"+obrat[1][2]);pw.println("A 3,2:\t"+obrat[1][2]);

            System.out.println("A 3,1:\t"+obrat[0][2]);pw.println("A 1,3:\t"+obrat[0][2]);                
            System.out.println("A 3,2:\t"+obrat[2][1]);pw.println("A 2,3:\t"+obrat[2][1]);        
            System.out.println("A 3,3:\t"+obrat[2][2]);pw.println("A 3,3:\t"+obrat[2][2]);

            System.out.println("--------------------\nКонечный вид матрицы дополнений");
            pw.println("--------------------\nКонечный вид матрицы дополнений");Thread.sleep(300);           
            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.printf("%4.0f",obrat1[j]);
            pw.printf("%4.0f",obrat1[j]);}
            System.out.println();
            pw.println();}

            System.out.println("--------------------\nТранспонируем её и находим союзную матрицу:");
            pw.println("--------------------\nТранспонируем её и находим союзную матрицу:");

            for (int i = 0; i<obrat.length; i++) {
            for (int j = i+1; j <obrat.length; j++) {
            float temp = obrat[i][j];
            obrat[i][j] = obrat[j][i];
            obrat[j][i] = temp;}}

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.printf("%4.0f",obrat1[j]);
            pw.printf("%4.0f",obrat1[j]);}
            System.out.println();
            pw.println();}

            System.out.println("--------------------");pw.println("--------------------");Thread.sleep(300);
            System.out.println("Обратнаяматрица: ");pw.println("Обратнаяматрица: ");

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat.length; j++) {
            obrat1[j] = 1 / obrat1[j];}}

            for (float[] obrat1 : obrat) {
            for (int j = 0; j <obrat[0].length; j++) {
            System.out.print("     "+obrat1[j]);
            pw.print(obrat1[j] + "     ");}
            System.out.println();
            pw.println();}

            System.out.println("--------------------");pw.println("--------------------");Thread.sleep(300);
            System.out.println("Конец.");pw.println("Конец.");Thread.sleep(300);

            System.out.print("Хотите ли вы перезапустить код?[Y/N(любая клавиша)] --> ");         
            String y_n1 = in.nextLine();
            boolean strs1 = y_n1.startsWith("Y");
            boolean strs2 = y_n1.startsWith("y");
            if(strs1 == true || strs2 == true){//циклдля no
            System.out.println("\t\t---Перезапускаем---");pw.println("        ---Перезапускаем---");
            Thread.sleep(300);
            }else{break;}}}}

            else{System.out.print("Выввелинеправильнозначение, перезапуститекод. Хотите ли вы перезапустить код?[Y/N(любая клавиша)] --> ");
            pw.println("Вы ввели неправильно значение, перезапустите код. Хотите ли вы перезапустить код?[Y/N(любая клавиша)] --> ");
            String y_n1 = in.nextLine();
            boolean strs1 = y_n1.startsWith("Y");
            boolean strs2 = y_n1.startsWith("y");
            if(strs1 == true || strs2 == true){//циклдля no
            System.out.println("\t\t---Перезапускаем---");pw.println("        ---Перезапускаем---");
            Thread.sleep(300);
            }else{break;}
                        }



            }//запись в файл
        }//повто рцикла
    }
}
