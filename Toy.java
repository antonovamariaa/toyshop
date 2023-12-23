public class Toy {
    private int id;
    private String name;
    private int amount;
    private int dropRate;

    public Toy(int id, String name, int amount, int dropRate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.dropRate = dropRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDropRate() {
        return dropRate;
    }

    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }

    public void decreaseAmount() {
        if (amount > 0) {
            amount--;
        }
    }
}