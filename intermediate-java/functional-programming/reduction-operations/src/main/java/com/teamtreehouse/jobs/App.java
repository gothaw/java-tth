package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        JobService service = new JobService();
        boolean shouldRefresh = false;
        try {
            if (shouldRefresh) {
                service.refresh();
            }
            List<Job> jobs = service.loadJobs();
            System.out.printf("Total jobs:  %d %n %n", jobs.size());
            explore(jobs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void explore(List<Job> jobs) {
        List<String> companies = jobs.stream()
                .map(Job::getCompany)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        int pageSize = 20;
        int numPages = companies.size() / pageSize;

        IntStream.iterate(1, i -> i + pageSize)
                .mapToObj(i -> String.format("%d. %s", i, companies.get(i)))
                .limit(numPages)
                .forEach(System.out::println);
    }

    /**
     * Displays companies names using range
     *
     * @param companies
     */
    private static void displayCompaniesMenuUsingRange(List<String> companies) {
        IntStream.rangeClosed(1, 20)
                .mapToObj(i -> String.format("%d. %s", i, companies.get(i - 1)))
                .forEach(System.out::println);
    }

    /**
     * Displays companies names imperatively
     *
     * @param companies
     */
    private static void displayCompaniesMenuImperatively(List<String> companies) {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%d. %s %n", i + 1, companies.get(i));
        }
    }

    /**
     * Lucky search - returns first job with the keyword
     *
     * @param jobs
     * @param searchTerm
     */
    private static void luckySearchJob(List<Job> jobs, String searchTerm) {
        Optional<Job> foundJob = jobs.stream()
                .filter(job -> job.getTitle().contains(searchTerm))
                .findFirst();
        foundJob.ifPresent(job -> System.out.println(job.getTitle()));
    }

    /**
     * Count words in snippets declaratively
     *
     * @param jobs
     * @return
     */
    public static Map<String, Long> getSnippetWordCountsStream(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getSnippet)
                .map(snippet -> snippet.split("\\W+"))
                .flatMap(words -> Stream.of(words))
                .filter(word -> word.length() > 0)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    /**
     * Count words in snippets imperatively
     *
     * @param jobs
     * @return
     */
    public static Map<String, Long> getSnippetWordCountsImperatively(List<Job> jobs) {

        Map<String, Long> wordCounts = new HashMap<>();

        for (Job job : jobs) {
            String[] words = job.getSnippet().split("\\W+");
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                // lowercase of the word
                String lWord = word.toLowerCase();
                // gets the current count of the word
                Long count = wordCounts.get(lWord);
                // if word does not exist count is null
                if (count == null) {
                    count = 0L;
                }
                // updates lword in map, uses pre increment!
                wordCounts.put(lWord, ++count);
            }
        }
        return wordCounts;
    }

    /**
     * Declarative approach to print 3 junior jobs in strings
     *
     * @param jobs
     * @return
     */
    private static List<String> getCaptionsStream(List<Job> jobs) {
        return jobs.stream()
                .filter(App::isJuniorJob)
                .map(Job::getCaption)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Imperative approach to print 3 junior jobs in strings
     *
     * @param jobs
     * @return
     */
    private static List<String> getCaptionsImperatively(List<Job> jobs) {
        List<String> captions = new ArrayList<>();
        for (Job job : jobs) {
            if (isJuniorJob(job)) {
                String caption = job.getCaption();
                captions.add(caption);
                if (captions.size() >= 3) {
                    break;
                }
            }
        }
        return captions;
    }

    /**
     * Declarative way to get 3 junior jobs
     *
     * @param jobs
     * @return
     */
    private static List<Job> getThreeJuniorJobsStream(List<Job> jobs) {
        return jobs.stream()
                .filter(App::isJuniorJob)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Imperative approach to print 3 junior jobs
     *
     * @param jobs
     * @return
     */
    private static List<Job> getThreeJuniorJobsImperatively(List<Job> jobs) {
        List<Job> juniorJobs = new ArrayList<>();
        for (Job job : jobs) {
            if (isJuniorJob(job)) {
                juniorJobs.add(job);
                if (juniorJobs.size() >= 3) {
                    break;
                }
            }
        }
        return juniorJobs;
    }

    /**
     * Declarative approach to print jobs in Portland
     *
     * @param jobs
     */
    private static void printPortlandJobsStream(List<Job> jobs) {
        jobs.stream()
                .filter(job -> job.getState().equals("OR"))
                .filter(job -> job.getCity().equals("Portland"))
                .forEach(System.out::println);
    }

    /**
     * Imperative approach to print jobs in Portland
     *
     * @param jobs
     */
    private static void printPortlandJobsImperatively(List<Job> jobs) {
        for (Job job : jobs) {
            if (job.getState().equals("OR") && job.getCity().equals("Portland")) {
                System.out.println(job);
            }
        }
    }

    /**
     * Helper method
     *
     * @param job
     * @return
     */
    private static boolean isJuniorJob(Job job) {
        String title = job.getTitle().toLowerCase();
        return title.contains("junior") || title.contains("jr");
    }
}
