package fifthTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int entityCount = 6;
        int safeCapacity = 10;
        Entity[] entities = {new Entity(1, 3200),
                new Entity( 4, 5400),
                new Entity( 5, 7000),
                new Entity( 23, 650000),
                new Entity( 2, 4000),
                new Entity( 7, 6500),};
        Safe[][] safe = new Safe[entityCount  + 1][safeCapacity + 1];
        for (int i = 0; i < entityCount + 1; i++) {
            for (int j = 0; j < safeCapacity + 1; j++) {
                if (i == 0 || j == 0) { //нулевую строку и столбец заполняем нулями
                    safe[i][j] = new Safe(new Entity[]{}, 0);
                } else if (i == 1) {
                    safe[1][j] = entities[0].getWeight() <= j ? new Safe(new Entity[]{entities[0]}, entities[0].getPrice())
                            : new Safe(new Entity[]{}, 0);
                } else {
                    if (entities[i - 1].getWeight() > j)
                        safe[i][j] = safe[i - 1][j];
                    else {
                        int newPrice = entities[i - 1].getPrice() + safe[i - 1][j - entities[i - 1].getWeight()].getPrice();
                        if (safe[i - 1][j].getPrice() > newPrice)
                            safe[i][j] = safe[i - 1][j];
                        else {
                            safe[i][j] = new Safe(Stream.concat(Arrays.stream(new Entity[]{entities[i - 1]}),
                                    Arrays.stream(safe[i - 1][j - entities[i - 1].getWeight()].getEntitys())).toArray(Entity[]::new), newPrice);
                        }
                    }
                }
            }
        }
        List<Safe> lastColumn = Arrays.stream(safe).map(row -> row[row.length - 1]).collect(Collectors.toList());


        Safe safeWithMax = lastColumn.stream().max(Comparator.comparing(Safe::getPrice)).orElse(new Safe(null, 0));


        System.out.println("Максимальная цена: " + safeWithMax.getPrice());
    }
}
