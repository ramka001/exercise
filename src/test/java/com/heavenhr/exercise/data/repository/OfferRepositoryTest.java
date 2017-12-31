package com.heavenhr.exercise.data.repository;

import com.heavenhr.exercise.data.model.Application;
import com.heavenhr.exercise.data.model.ApplicationStatus;
import com.heavenhr.exercise.data.model.Offer;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryTest {


    @Autowired
    private OfferRepository mockOfferRepository;

    private Offer offer1;
    private Offer offer2;

    private Offer offer2Error;

    private Application application1;
    private Application application2;
    private Application application3;

    private Application application4;
    private Application application5;
    private Application application6;


    private Map<String,Application> mockOffer1Applications;
    private Map<String,Application> mockOffer2Applications;

    private final String startDate1 = "03/01/2018";
    private final String startDate2 = "01/02/2018";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");


    private static final Logger LOG = Logger.getLogger(OfferRepositoryTest.class);


    @Before
    public void setup() throws ParseException {
        mockOfferRepository = mock(OfferRepository.class);
        mockOffer1Applications = new LinkedHashMap<>();
        mockOffer2Applications = new LinkedHashMap<>();


        Date date1 = dateFormat.parse(startDate1);
        Date date2 = dateFormat.parse(startDate2);

        offer1 = new Offer();
        offer1.setJobTitle("Software Engineer");
        offer1.setStartDate(date1);
        offer1.setApplications(mockOffer1Applications);

        offer2 = new Offer();
        offer2.setJobTitle("QA Engineer");
        offer2.setStartDate(date2);
        offer2.setApplications(mockOffer2Applications);



        offer2Error = new Offer();
        offer2Error.setJobTitle("Software Engineer");
        offer2Error.setStartDate(date1);
        offer2Error.setApplications(mockOffer1Applications);

        application1 = new Application();
        application1.setOffer(offer1);
        application1.setCandidateEmail("john.doe@gmail.com");
        application1.setResumeText("Test Resume 1.docx");
        application1.setApplicationStatus(ApplicationStatus.APPLIED);


        application2 = new Application();
        application2.setOffer(offer1);
        application2.setCandidateEmail("jane.doe@gmail.com");
        application2.setResumeText("Test Resume 2.docx");
        application2.setApplicationStatus(ApplicationStatus.APPLIED);

        application3 = new Application();
        application3.setOffer(offer1);
        application3.setCandidateEmail("mock.user@gmail.com");
        application3.setResumeText("Test Resume 3.docx");
        application3.setApplicationStatus(ApplicationStatus.APPLIED);


        application4 = new Application();
        application4.setOffer(offer2);
        application4.setCandidateEmail("mock.user2@gmail.com");
        application4.setResumeText("Mock Resume 1.docx");
        application4.setApplicationStatus(ApplicationStatus.APPLIED);

        application5 = new Application();
        application5.setOffer(offer2);
        application5.setCandidateEmail("mock.user3@gmail.com");
        application5.setResumeText("Mock Resume 2.pdf");
        application5.setApplicationStatus(ApplicationStatus.APPLIED);

        application6 = new Application();
        application6.setOffer(offer2);
        application6.setCandidateEmail("john.doe@gmail.com");
        application6.setResumeText("Test Resume 1.docx");
        application6.setApplicationStatus(ApplicationStatus.APPLIED);

    }


    @Test
    public void testAddNewOffer() throws ParseException {

        LOG.info("\n\n======================== Test Begins ==============================\n\n");

            mockOfferRepository.save(offer1);

            mockOfferRepository.save(offer2);

            LOG.info("\n\n============== Insertion of Applications Offer 1 ==================\n\n");

            mockOffer1Applications.put(application1.getCandidateEmail(),application1);

            mockOffer1Applications.put(application2.getCandidateEmail(),application2);

            mockOffer1Applications.put(application3.getCandidateEmail(),application3);

            LOG.info("\n\n============== Insertion of Applications Offer 2 ==================\n\n");

            mockOffer2Applications.put(application4.getCandidateEmail(),application4);

            mockOffer2Applications.put(application5.getCandidateEmail(),application5);

            mockOffer2Applications.put(application6.getCandidateEmail(),application6);

            offer1.setNumberOfApplications(mockOffer1Applications.size());

            offer2.setNumberOfApplications(mockOffer2Applications.size());


            LOG.info("\n\n====================================================================\n\n");

            LOG.info("\n\n====================================================================\n"
                    +"Number of Applications for Offer 1: "
                    + offer1.getNumberOfApplications()
                    +"\n====================================================================\n\n");

            LOG.info("\n\n====================================================================\n"
                    +"Number of Applications for Offer 2: "
                    + offer2.getNumberOfApplications()
                    +"\n====================================================================\n\n");

            LOG.info("\n\n====================================================================\n"
                    +"Number of Offers: "
                    + mockOfferRepository.findAll().size()
                    + "\n====================================================================\n\n");


            LOG.info("\n\n====================================================================\n"
                    +"List of Offers: "
                    +"\n====================================================================");

            for(Offer o : mockOfferRepository.findAll()) {

                LOG.info("\n\n====================================================================\n"
                        +  o.getId() + " " + o.getJobTitle() + " "
                        + o.getStartDate()
                        + "\n====================================================================\n\n");
            }


            LOG.info("\n\n===================================================================\n"
                    +"List of Applicants for Offer 1 "
                    +"\n===================================================================");

            for (Application i : offer1.getApplications().values()) {

                LOG.info("\n\n====================================================================\n"
                        +"E-Mail: "
                        +  i.getCandidateEmail() + "\nResume: " + i.getResumeText()
                        + "\nApplication Status: " + i.getApplicationStatus()
                        + "\n====================================================================\n\n");
            }

            LOG.info("\n\n===================================================================\n"
                    +"List of Applicants for Offer 2 "
                    +"\n===================================================================");

            for (Application i : offer2.getApplications().values()) {

                LOG.info("\n\n====================================================================\n"
                        +"E-Mail: "
                        + i.getCandidateEmail() + "\nResume: " + i.getResumeText() + "\nApplication Status: "
                        + i.getApplicationStatus()
                        +  "\n====================================================================\n\n");
            }

    }


    @Test
    public void testDuplicateOffer() throws ParseException {

        LOG.info("\n\n================ Duplicate Offer Test Begins ======================\n\n");

            mockOfferRepository.save(offer1);

            mockOfferRepository.save(offer2Error);

            LOG.info("\n\n===================================================================\n"
                    +"Mocking Duplicate Offers With Same Title "
                    +"\n===================================================================");

            Map<String,Long>  mockOfferValidation = new LinkedHashMap<>();
            mockOfferValidation.put(offer1.getJobTitle(),offer1.getId());
            mockOfferValidation.put(offer2Error.getJobTitle(),offer2Error.getId());

            LOG.info("\n\n===================================================================\n"
                    +"Validation Map Size for Same Title\n"
                    + mockOfferValidation.size()
                    + "\n===================================================================");


            LOG.info("\n\n===================================================================\n"
                    +"Mocking Duplicate Offers With Different Title "
                    +"\n===================================================================");

            offer2.setJobTitle("QA Engineer");
            mockOfferValidation.put(offer2.getJobTitle(),offer2.getId());

            LOG.info("\n\n===================================================================\n"
                    +"Validation Map Size for Different Title\n"
                    + mockOfferValidation.size()
                    + "\n===================================================================");
    }

    @After
    public void destroy() {
        mockOfferRepository = null;
        mockOffer1Applications = null;
        mockOffer2Applications = null;
        offer1 = null;
        offer2 = null;
    }

}
