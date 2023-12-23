import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // создаем коробку, в которую потом будем класть игрушки
        ToyBox toyBox = new ToyBox();
        // для работы с файлом
        String fileName = "results.txt";
        File file = new File(fileName);
        // удаляем файл результатов если он уже есть
        file.delete();

        // добавляем игрушки в коробку
        toyBox.addToy(new Toy(1, "Плюшевая кошка", 1, 6));
        toyBox.addToy(new Toy(2, "Плюшевая собака", 1, 7));
        toyBox.addToy(new Toy(3, "Плюшевый медведь", 1, 5));
        toyBox.addToy(new Toy(3, "Ружье", 1, 1));

        // Организуем розыгрыш, в данном случае - 10 раз
        for (int i = 0; i < 10; i++) {
            // вызываем розыгрыш
            Toy toy = toyBox.drawToy();

            // выводим результат на экран и пытаемся записать их в файл
            try {
                System.out.print("Попытка " + (i + 1) + ": ");
                System.out.println("Ваш приз -  " + toy.getName() + "! Таких игрушек осталось " + toy.getAmount());

                FileWriter writer = new FileWriter(fileName, true);

                writer.write("Попытка " + (i + 1) + " - " + toy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
            // когда коробка пустая выходим из цикла
            if (toyBox.isEmpty()) {
                System.out.println("Больше игрушек нет, все были разыграны.");
                break;
            }

        }

    }

}
