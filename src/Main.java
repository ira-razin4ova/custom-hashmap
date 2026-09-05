
public class Main {
    public static void main(String[] args) {

        MyHashMap<String, String> map = new MyHashMap<>();

        System.out.println("Мапа пуста? " + map.isEmpty()); // true
        System.out.println("Размер: " + map.size()); // 0

        map.put("Кот", "Барсик");
        map.put("Собака", "Шарик");
        map.put("Попугай", "Кеша");


        System.out.println("\nПосле добавления элементов:");
        System.out.println("Размер: " + map.size()); // 3
        System.out.println("Мапа пуста? " + map.isEmpty()); // false

        System.out.println("\nВсе элементы в мапе:");
        System.out.print(map.getFormattedEntries()); // [key = Собака - value = Шарик, key = Попугай - value = Кеша, key = Кот - value = Барсик]

        System.out.println("\n\nКто живет под ключом 'Собака'? " + map.getValue("Собака")); // Шарик
        System.out.println("Кто живет под ключом 'Кот'? " + map.getValue("Кот")); // Барсик

        map.remove("Собака");
        System.out.println("\nПосле удаления 'Собаки':");
        System.out.println("Размер: " + map.size()); // 2
        System.out.println("Попытка найти 'Собаку': " + map.getValue("Собака")); // null

        map.clear();
        System.out.println("\nПосле очистки (clear):");
        System.out.println("Размер: " + map.size()); // 0
        System.out.println("Мапа пуста? " + map.isEmpty()); // true
    }


}