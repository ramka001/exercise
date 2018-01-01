package com.heavenhr.exercise;

import com.heavenhr.exercise.data.model.Application;

import com.heavenhr.exercise.data.model.Offer;
import com.heavenhr.exercise.data.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.heavenhr.exercise.data.model.ApplicationStatus.APPLIED;



@SpringBootApplication
public class ExerciseApplication implements CommandLineRunner {

	private final OfferRepository offerRepository;

	@Autowired
	public ExerciseApplication(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		final Map<String,Application> applications1 = new LinkedHashMap<>();
		final Map<String,Application> applications2 = new LinkedHashMap<>();
		final Map<String,Application> applications3 = new LinkedHashMap<>();


		final String startDate = "01/02/2018";
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		final Date date = dateFormat.parse(startDate);

		final Offer offer1 = new Offer();
		offer1.setJobTitle("Software Engineer");
		offer1.setStartDate(date);
		offerRepository.save(offer1);

		final Offer offer2 = new Offer();
		offer2.setJobTitle("Solution Architect");
		offer2.setStartDate(date);
		offerRepository.save(offer2);

		final Offer offer3 = new Offer();
		offer3.setJobTitle("Integration Engineer");
		offer3.setStartDate(date);
		offerRepository.save(offer2);


		final Application application1 = new Application();
		application1.setOffer(offer1);
		application1.setCandidateEmail("john.doe@gmail.com");
		application1.setResumeText("Test Resume.pdf");
		application1.setApplicationStatus(APPLIED);

		final Application application2 = new Application();
		application2.setOffer(offer1);
		application2.setCandidateEmail("peter.smith@gmail.com");
		application2.setResumeText("Peter_Smith's_CV.docx");
		application2.setApplicationStatus(APPLIED);


		applications1.put(application1.getCandidateEmail(),application1);
		applications1.put(application2.getCandidateEmail(),application2);

		offer1.setApplications(applications1);
		offer1.setNumberOfApplications(applications1.size());
		offerRepository.saveAndFlush(offer1);



		final Application application3 = new Application();
		application3.setOffer(offer2);
		application3.setCandidateEmail("peter.smith@gmail.com");
		application3.setResumeText("Peter_Smith's_CV.docx");
		application3.setApplicationStatus(APPLIED);
		applications2.put(application3.getCandidateEmail(),application3);


		offer2.setApplications(applications2);
		offer2.setNumberOfApplications(applications2.size());
		offerRepository.saveAndFlush(offer2);


		final Application application4 = new Application();
		application4.setOffer(offer3);
		application4.setCandidateEmail("max.williams@yahoo.com");
		application4.setResumeText("Max Williams's Resume.pdf");
		application4.setApplicationStatus(APPLIED);
		applications3.put(application4.getCandidateEmail(),application4);


		final Application application5 = new Application();
		application5.setOffer(offer3);
		application5.setCandidateEmail("john.peterson@yahoo.com");
		application5.setResumeText("John_Peterson's_Resume.pdf");
		application5.setApplicationStatus(APPLIED);
		applications3.put(application5.getCandidateEmail(),application5);


		offer3.setApplications(applications3);
		offer3.setNumberOfApplications(applications3.size());
		offerRepository.saveAndFlush(offer3);
	}
}
