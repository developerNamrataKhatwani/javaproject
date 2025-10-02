package com.practice.javaproject;

import com.practice.javaproject.Streams.LearnStreams;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class JavaprojectApplication implements CommandLineRunner {
    private final LearnStreams learnStreams;

	public static void main(String[] args) {
		SpringApplication.run(JavaprojectApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        learnStreams.stream();

    }
}
