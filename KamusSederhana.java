import java.util.HashMap;
import java.util.Map;  // Import the Map interface
import java.util.Scanner;

public class KamusSederhana {
    private static HashMap<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Predefined words
        dictionary.put("Apple", "A fruit");
        dictionary.put("Computer", "An electronic device");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan arti kata");
            System.out.println("2. Tambahkan kata baru");
            System.out.println("3. Hapus kata");
            System.out.println("4. Cari kata yang mengandung huruf");
            System.out.println("5. Tampilkan daftar kata");
            System.out.println("6. Cari kata dengan prefix atau suffix");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kata: ");
                    String word = scanner.nextLine();
                    showWordMeaning(word);
                    break;
                case 2:
                    System.out.print("Masukkan kata baru: ");
                    String newWord = scanner.nextLine();
                    System.out.print("Masukkan arti: ");
                    String meaning = scanner.nextLine();
                    addNewWord(newWord, meaning);
                    break;
                case 3:
                    System.out.print("Masukkan kata yang ingin dihapus: ");
                    String wordToRemove = scanner.nextLine();
                    removeWord(wordToRemove);
                    break;
                case 4:
                    System.out.print("Masukkan huruf untuk pencarian: ");
                    String letter = scanner.nextLine();
                    searchWordByLetter(letter);
                    break;
                case 5:
                    showAllWords();
                    break;
                case 6:
                    System.out.print("Masukkan prefix atau suffix: ");
                    String affix = scanner.nextLine();
                    searchWordByPrefixOrSuffix(affix);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }

    // 1. Tampilkan arti kata
    public static void showWordMeaning(String word) {
        if (dictionary.containsKey(word)) {
            System.out.println("Arti dari '" + word + "' adalah: " + dictionary.get(word));
        } else {
            System.out.println("Kata tidak ditemukan dalam kamus.");
        }
    }

    // 2. Tambahkan kata baru
    public static void addNewWord(String word, String meaning) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, meaning);
            System.out.println("Kata '" + word + "' berhasil ditambahkan.");
        } else {
            System.out.println("Kata sudah ada di kamus.");
        }
    }

    // 3. Hapus kata
    public static void removeWord(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.println("Kata '" + word + "' berhasil dihapus.");
        } else {
            System.out.println("Kata tidak ditemukan.");
        }
    }

    // 4. Cari kata yang mengandung huruf tertentu
    public static void searchWordByLetter(String letter) {
        System.out.println("Kata yang mengandung huruf '" + letter + "':");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().contains(letter)) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // 5. Tampilkan daftar kata
    public static void showAllWords() {
        System.out.println("Daftar kata dalam kamus:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 6. Pencarian dengan prefix atau suffix
    public static void searchWordByPrefixOrSuffix(String affix) {
        System.out.println("Kata yang dimulai atau diakhiri dengan '" + affix + "':");
        for (String word : dictionary.keySet()) {
            if (word.startsWith(affix) || word.endsWith(affix)) {
                System.out.println(word);
            }
        }
    }
}
