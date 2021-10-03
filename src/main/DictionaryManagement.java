package main;

import model.Word;
import repository.DictionaryRepository;
import repository.DictionaryRepositoryImpl;

import java.util.*;
import java.util.List;

public class DictionaryManagement {
    public static void main(String[] args) {
        DictionaryCommandLine();
    }

    public static void DictionaryCommandLine() {
        Scanner scan = new Scanner(System.in);
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();

        System.out.println("1.Tra tu");
        System.out.println("2.Hien thi cac tu co trong tu dien");
        System.out.println("3.Them tu vao tu dien");
        System.out.println("4.Xuat du lieu ra file");
        System.out.print("Nhap lua chon cua ban: ");

        int number = scan.nextInt();
        scan.nextLine();

        switch (number) {
            case 1:
                System.out.print("Nhap tu tieng Anh: ");
                String word_target = scan.nextLine();
                List<Word> words = dictionaryRepository.getWordByEnglish(word_target);
                if (words == null) {
                    System.out.println("Khong tim thay tu muon tra.");
                } else {
                    System.out.println("No" + "\t" + "|English" + "\t\t" + "|Vietnamese");
                    for (Word word : words) {
                        System.out.println(word.getId() + "\t" + "|" + word.getWord_target() + "\t\t" + "|" + word.getWord_explain());
                    }
                }
                break;

            case 2:
                List<Word> listWords = dictionaryRepository.getAllWords();
                System.out.println("No" + "\t" + "|English" + "\t\t" + "|Vietnamese");
                for (Word word : listWords) {
                    System.out.println(word.getId() + "\t" + "|" + word.getWord_target() + "\t\t\t" + "|" + word.getWord_explain());
                }
                break;

            case 3:
                System.out.print("Nhap tu tieng Anh: ");
                String english = scan.nextLine();
                System.out.print("Nhap giai thich sang tieng Viet: ");
                String vietnamese = scan.nextLine();

                int count = dictionaryRepository.insertWord(english, vietnamese);
                System.out.println(count);
                break;

            case 4:
                List<Word> listWordsExport = dictionaryRepository.getAllWords();
                dictionaryRepository.exportToFile(listWordsExport);
                break;

            default:
                System.out.println("Vui long chay lai.");
        }
    }
}
