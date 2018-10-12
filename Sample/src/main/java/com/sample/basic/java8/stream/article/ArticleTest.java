package com.sample.basic.java8.stream.article;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleTest {
    static List<Article> articles = new ArrayList<>();

    public static void main(String[] args) {
        initArticles();

//        Optional<Article> possibleArticle = getFirstJavaArticle();
//        if (possibleArticle.isPresent()) {
//            System.out.println(possibleArticle.get());
//        }

        List<Article> javaArticles = getAllJavaArticles();
//        javaArticles.forEach(System.out::println);
//        System.out.println(javaArticles);

        Map<String, List<Article>> map = groupByAuthor();
        System.out.println(map);
    }

    public static Optional<Article> getFirstJavaArticle() {
        return articles.stream().filter(
                (a) -> a.getTags().contains("Java")
        ).findAny();
    }

    public static List<Article> getAllJavaArticles() {
        return articles.stream().filter(
                (a) -> a.getTags().contains("Java")
        ).collect(Collectors.toList());
    }

    public static Map<String, List<Article>> groupByAuthor() {
        return articles.stream()
            .collect(Collectors.groupingBy(Article::getAuthor));
    }

    public static void initArticles() {
        List<String> tags1 = Arrays.asList("Java", "Programming", "IT");
        List<String> tags2 = Arrays.asList("Oracle", "Database", "IT");
        List<String> tags3 = Arrays.asList("Java", "Design", "Pattern");
        List<String> tags4 = Arrays.asList("Novel", "Science Fiction", "Entertainment");
        Article a1 = new Article("Java Core", "author1", tags1);
        Article a2 = new Article("PL/SQL", "author2", tags2);
        Article a3 = new Article("Java Pattern", "author1", tags3);
        Article a4 = new Article("3 body problem", "author4", tags4);
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
    }
}
