import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Введена пустая строка");
            }

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }

            if (!phoneNumber.matches("\\d+")) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }

            if (!gender.matches("[fm]")) {
                throw new IllegalArgumentException("Неверный формат пола");
            }

            String fileName = lastName + ".txt";
            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                String formattedData = String.format("%s %s %s %s %s %s%n", lastName, firstName, middleName, birthDate, phoneNumber, gender);
                fileWriter.write(formattedData);
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
