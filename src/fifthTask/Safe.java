package fifthTask;


public class Safe {
    Entity[] entities;
    int price;
    public Safe(Entity[] items, int price) {
        this.entities = items;
        this.price = price;
    }

    public Entity[] getEntitys() {
        return entities;
    }

    public int getPrice() {
        return price;
    }
}
