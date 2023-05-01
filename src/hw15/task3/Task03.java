package hw15.task3;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

class AuthorYearComparator implements Comparator<Author>
{
    public int compare(Author a, Author b)
    {
        return b.getBirth().getYear() - a.getBirth().getYear();
    }
}

public class Task03 {
    public static void main(String[] args) {
        // Ќаписать реализацию методов task01 - task05
        // ƒл€ некоторых решений может пригодитьс€ метод flatMap класса Stream
    }

    public static Double task05(ArrayList<Article> articles){
        // ¬ернуть средний возраст авторов
        // Arrays.stream(articles)
        return articles.stream().map
                          (
                             article -> article.getAuthors()
                            .entrySet()
                            .stream()
                            .collect
                            (
                               Collectors
                               .averagingInt
                               (
                                   entry->
                                   {
                                       LocalDate nw = LocalDate.now();
                                       LocalDate birth = entry.getValue().getBirth();
                                       Period diff = Period.between(birth, nw);
                                       Integer age = diff.getYears();
                                       return age;
                                   }
                               )
                            )
                          ).collect(Collectors.averagingDouble(d ->d));
    }
    public static Author task04(ArrayList<Article> articles, Article.Category category){
        // ¬ернуть самого молодого автора статей категории == category
        return articles.stream()
               .filter(article -> article.getCategory().compareTo(category) == 0)
               .map(article -> article.getAuthors().values())
               .flatMap(authors -> authors.stream())
               .min(new AuthorYearComparator()).get();
    }

    public static HashSet<String> task03(ArrayList<Article> articles, Article.Category category){
        // ¬ернуть множество email авторов статей категории == category
       return  articles.stream()
               .filter(article -> article.getCategory().compareTo(category) == 0)
               .map(article -> article.getAuthors().values())
               .flatMap(authors -> authors.stream())
               .map(author -> author.getEmail())
               .collect(Collectors.toCollection(HashSet<String>::new));
    }

    public static Set<Article> task02(ArrayList<Article> articles, Article.Category category, int min, int max){
        // ¬ернуть множество статей категории == category, возраст авторов которых попадает в диапазон от min до max
        return articles.stream()
                .filter(article -> article.getCategory().compareTo(category) == 0)
                .filter(article ->
                        {
                            ArrayList<LocalDate> authors =
                            article.getAuthors().values().stream()
                            .map(author -> author.getBirth())
                            .filter(date ->
                                    {
                                        LocalDate nw = LocalDate.now();
                                        Period diff = Period.between(date, nw);
                                        if(diff.getYears() > min && diff.getYears() < max) return true;
                                        return false;
                                    }
                                   )
                            .collect(Collectors.toCollection(ArrayList<LocalDate>::new));
                            if(authors.size() == article.getAuthors().size()) return true;
                            return false;
                        }
                       )
                .collect(Collectors.toSet());
    }
    public static LinkedList<Article> task01(ArrayList<Article> articles, Article.Category category){
        // ¬ернуть список статей категории == category, опубликованных сегодн€
        return articles.stream()
               .filter(article -> article.getCategory().compareTo(category) == 0)
               .filter(article -> article.getPublished().toLocalDate().compareTo(LocalDate.now()) == 0)
               .collect(Collectors.toCollection(LinkedList::new));
    }
}
