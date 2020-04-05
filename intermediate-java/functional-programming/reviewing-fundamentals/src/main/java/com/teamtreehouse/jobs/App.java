package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
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
        // list of company names
        List<String> companies = jobs.stream()
                .map(Job::getCompany)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Email Example - Higher Order Functions
        // higherOrderFunctionsEmailFeature(jobs);

        // Getting date in Indeed format
        // displayDateInIndeedFormatForFirstFiveJobs(jobs);
    }

    private static void displayDateInIndeedFormatForFirstFiveJobs(List<Job> jobs) {
        // Function to get Date from String
        Function<String, LocalDateTime> indeedDateConverter =
                dateString -> LocalDateTime.parse(
                        dateString, DateTimeFormatter.RFC_1123_DATE_TIME);

        // Function to convert date to format 3/15/17
        Function<LocalDateTime, String> siteDateStringConverter =
                date -> date.format(DateTimeFormatter.ofPattern("M / d / YY"));

        // Chained function
        Function<String, String> indeedToSiteDate = indeedDateConverter.andThen(siteDateStringConverter);

        jobs.stream()
                .map(Job::getDateTimeString)
                .map(indeedToSiteDate)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void higherOrderFunctionsEmailFeature(List<Job> jobs) {
        Job firstOne = jobs.get(0);
        System.out.println("First job:" + firstOne);

        Predicate<Job> caJobChecker = job -> job.getState().equals("CA");

        Job caJob = jobs.stream()
                .filter(caJobChecker)
                .findFirst()
                .orElseThrow(NullPointerException::new);

        emailIfMatches(firstOne, caJobChecker);
        // and - default method on the predicate
        emailIfMatches(caJob, caJobChecker.and(App::isJuniorJob));
    }

    private static void emailIfMatches(Job job, Predicate<Job> checker) {
        if (checker.test(job)) {
            System.out.println("I am sending an email about " + job);
        }
    }


    /**
     * Displays companies that name start with N
     *
     * @param companies
     */
    private static void displayCompaniesStartingWithN(List<String> companies) {
        companies.stream()
                .peek(company -> System.out.println("=====>" + company))
                .filter(company -> company.startsWith("N"))
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
