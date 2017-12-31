Instructions
============

The project has been compressed into a zip file called exersize.zip.  You will first need to extract the zip file and build the maven project.

Certains values have been hard coded into the main class i.e. com.heavenhr.exercise.ExerciseApplication.




1) To build run 

 mvn clean install 

2) To execute run

mvn spring-boot:run

* It is recommended to use the Postman application or SoapUI for testing the request.  For platform portability I'm sending the requests using curl.



3) To view the result of the output from command terminal using the curl command as below:-
===========================================================================================

curl -v http://localhost:8080/offers
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /offers HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 31 Dec 2017 16:22:53 GMT
< 
{
  "_embedded" : {
    "offers" : [ {
      "jobTitle" : "Software Engineer",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 2,
      "applications" : {
        "john.doe@gmail.com" : {
          "candidateEmail" : "john.doe@gmail.com",
          "resumeText" : "Test Resume.pdf",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/1"
            }
          }
        },
        "peter.smith@gmail.com" : {
          "candidateEmail" : "peter.smith@gmail.com",
          "resumeText" : "Peter_Smith's_CV.docx",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/1"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/1"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/1"
        }
      }
    }, {
      "jobTitle" : "Solution Architect",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 1,
      "applications" : {
        "peter.smith@gmail.com" : {
          "candidateEmail" : "peter.smith@gmail.com",
          "resumeText" : "Peter_Smith's_CV.docx",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/2"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/2"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/2"
        }
      }
    }, {
      "jobTitle" : "Integration Engineer",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 2,
      "applications" : {
        "max.williams@yahoo.com" : {
          "candidateEmail" : "max.williams@yahoo.com",
          "resumeText" : "Max Williams's Resume.pdf",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/3"
            }
          }
        },
        "john.peterson@yahoo.com" : {
          "candidateEmail" : "john.peterson@yahoo.com",
          "resumeText" : "John_Peterson's_Resume.pdf",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/3"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/3"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/3"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/offers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/offers"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host localhost left intact




To List the offers separateley one by one they can be separated by the id
=========================================================================

curl -v http://localhost:8080/offers/1
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /offers/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 31 Dec 2017 16:23:50 GMT
< 
{
  "jobTitle" : "Software Engineer",
  "startDate" : "2018-01-01",
  "numberOfApplications" : 2,
  "applications" : {
    "john.doe@gmail.com" : {
      "candidateEmail" : "john.doe@gmail.com",
      "resumeText" : "Test Resume.pdf",
      "applicationStatus" : "APPLIED",
      "_links" : {
        "offer" : {
          "href" : "http://localhost:8080/offers/1"
        }
      }
    },
    "peter.smith@gmail.com" : {
      "candidateEmail" : "peter.smith@gmail.com",
      "resumeText" : "Peter_Smith's_CV.docx",
      "applicationStatus" : "APPLIED",
      "_links" : {
        "offer" : {
          "href" : "http://localhost:8080/offers/1"
        }
      }
    }
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/offers/1"
    },
    "offer" : {
      "href" : "http://localhost:8080/offers/1"
    }
  }
* Connection #0 to host localhost left intact



To Update the Application status a PUT request needs to be sent below is an example using curl
==============================================================================================

curl -H 'Content-Type: application/json' -H 'Accept: application/json' -X PUT -d '{"jobTitle" : "Software Engineer", "startDate" : "2018-01-01", "numberOfApplications" : 2, "applications" : { "john.doe@gmail.com" : { "candidateEmail" : "john.doe@gmail.com", "resumeText" : "Test Resume.pdf", "applicationStatus" : "INVITED", "_links" : { "offer" : { "href" : "http://localhost:8080/offers/1"  }  } }}}' \http://localhost:8080/offers/1




Once the change is made the update can be view using the a curl GET request
===========================================================================

curl -v http://localhost:8080/offers/
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /offers/ HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 31 Dec 2017 16:38:16 GMT
< 
{
  "_embedded" : {
    "offers" : [ {
      "jobTitle" : "Software Engineer",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 2,
      "applications" : {
        "john.doe@gmail.com" : {
          "candidateEmail" : "john.doe@gmail.com",
          "resumeText" : "Test Resume.pdf",
          "applicationStatus" : "INVITED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/1"
            }
          }
        },
        "peter.smith@gmail.com" : {
          "candidateEmail" : "peter.smith@gmail.com",
          "resumeText" : "Peter_Smith's_CV.docx",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/1"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/1"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/1"
        }
      }
    }, {
      "jobTitle" : "Solution Architect",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 1,
      "applications" : {
        "peter.smith@gmail.com" : {
          "candidateEmail" : "peter.smith@gmail.com",
          "resumeText" : "Peter_Smith's_CV.docx",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/2"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/2"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/2"
        }
      }
    }, {
      "jobTitle" : "Integration Engineer",
      "startDate" : "2018-01-01",
      "numberOfApplications" : 2,
      "applications" : {
        "max.williams@yahoo.com" : {
          "candidateEmail" : "max.williams@yahoo.com",
          "resumeText" : "Max Williams's Resume.pdf",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/3"
            }
          }
        },
        "john.peterson@yahoo.com" : {
          "candidateEmail" : "john.peterson@yahoo.com",
          "resumeText" : "John_Peterson's_Resume.pdf",
          "applicationStatus" : "APPLIED",
          "_links" : {
            "offer" : {
              "href" : "http://localhost:8080/offers/3"
            }
          }
        }
      },
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/offers/3"
        },
        "offer" : {
          "href" : "http://localhost:8080/offers/3"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/offers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/offers"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }




Below are the log result which display the insertion updates of the data 
========================================================================


2018-01-01 00:38:11.136  INFO 6099 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2018-01-01 00:38:11.136  INFO 6099 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2018-01-01 00:38:11.149  INFO 6099 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 13 ms
2018-01-01 00:38:11.245 DEBUG 6099 --- [nio-8080-exec-1] org.hibernate.SQL                        : select offer0_.id as id1_1_0_, offer0_.job_title as job_titl2_1_0_, offer0_.number_of_applications as number_o3_1_0_, offer0_.start_date as start_da4_1_0_ from offer offer0_ where offer0_.id=?
Hibernate: select offer0_.id as id1_1_0_, offer0_.job_title as job_titl2_1_0_, offer0_.number_of_applications as number_o3_1_0_, offer0_.start_date as start_da4_1_0_ from offer offer0_ where offer0_.id=?
2018-01-01 00:38:11.246 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
2018-01-01 00:38:11.288 DEBUG 6099 --- [nio-8080-exec-1] org.hibernate.SQL                        : select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
Hibernate: select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
2018-01-01 00:38:11.289 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
2018-01-01 00:38:11.300 DEBUG 6099 --- [nio-8080-exec-1] org.hibernate.SQL                        : update application set application_status=?, candidate_email=?, application_id=?, resume_text=? where id=?
Hibernate: update application set application_status=?, candidate_email=?, application_id=?, resume_text=? where id=?
2018-01-01 00:38:11.300 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [VARCHAR] - [john.doe@gmail.com]
2018-01-01 00:38:11.300 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [BIGINT] - [1]
2018-01-01 00:38:11.300 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [4] as [VARCHAR] - [Test Resume.pdf]
2018-01-01 00:38:11.300 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [5] as [BIGINT] - [1]
2018-01-01 00:38:11.301 DEBUG 6099 --- [nio-8080-exec-1] org.hibernate.SQL                        : update application set applications_key=? where id=?
Hibernate: update application set applications_key=? where id=?
2018-01-01 00:38:11.301 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [john.doe@gmail.com]
2018-01-01 00:38:11.301 TRACE 6099 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [1]
2018-01-01 00:38:16.740  INFO 6099 --- [nio-8080-exec-2] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
2018-01-01 00:38:16.814 DEBUG 6099 --- [nio-8080-exec-2] org.hibernate.SQL                        : select offer0_.id as id1_1_, offer0_.job_title as job_titl2_1_, offer0_.number_of_applications as number_o3_1_, offer0_.start_date as start_da4_1_ from offer offer0_ limit ?
Hibernate: select offer0_.id as id1_1_, offer0_.job_title as job_titl2_1_, offer0_.number_of_applications as number_o3_1_, offer0_.start_date as start_da4_1_ from offer offer0_ limit ?
2018-01-01 00:38:16.832 DEBUG 6099 --- [nio-8080-exec-2] org.hibernate.SQL                        : select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
Hibernate: select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
2018-01-01 00:38:16.833 TRACE 6099 --- [nio-8080-exec-2] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
2018-01-01 00:38:16.836 DEBUG 6099 --- [nio-8080-exec-2] org.hibernate.SQL                        : select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
Hibernate: select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
2018-01-01 00:38:16.836 TRACE 6099 --- [nio-8080-exec-2] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [2]
2018-01-01 00:38:16.837 DEBUG 6099 --- [nio-8080-exec-2] org.hibernate.SQL                        : select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
Hibernate: select applicatio0_.application_id as applicat5_0_0_, applicatio0_.id as id1_0_0_, applicatio0_.applications_key as applicat6_0_, applicatio0_.id as id1_0_1_, applicatio0_.application_status as applicat2_0_1_, applicatio0_.candidate_email as candidat3_0_1_, applicatio0_.application_id as applicat5_0_1_, applicatio0_.resume_text as resume_t4_0_1_ from application applicatio0_ where applicatio0_.application_id=?
2018-01-01 00:38:16.838 TRACE 6099 --- [nio-8080-exec-2] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [3]
