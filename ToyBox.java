import java.util.*;

public class ToyBox {
    // весь список игрушек
    public List<Toy> toys = new ArrayList<>();

    // добавить игрушку
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    // изменить шансы выпадения
    public void changeDropRate(int id, int newDropRate) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setDropRate(newDropRate);
                break;
            }
        }
    }

    // проверка листа игрушек на пустоту
    public boolean isEmpty() {
        for (Toy toy : toys) {
            if (toy.getAmount() > 0) {
                return false;
            }
        }
        return true;
    }

    // разыграть игрушку

    public Toy drawToy() {
        int totalDropRate = 0;
        for (Toy toy : toys) {
            totalDropRate += toy.getDropRate();
        }

        int random = new Random().nextInt(totalDropRate);
        int currentDropRate = 0;

        for (Toy toy : toys) {
            currentDropRate += toy.getDropRate();
            if (random < currentDropRate) {
                if (toy != null) {
                    if (toy.getAmount() >= 1) {
                        toy.decreaseAmount();
                        if (toy.getAmount() == 0) {
                            toys.remove(toy);
                            // System.out.println("следующая позиция была удалена из спика " + toys.size());
                        }
                        return toy;
                    }

                }

            }
        }

        return null;
    }
}
