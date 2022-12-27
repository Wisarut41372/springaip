package nvc.it.nvcjobmarketspapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("jobposts")
@Getter @Setter @NoArgsConstructor
public class Post {
    @Id
    private String _id;
    private String company_id;
    private String companyName;
    private String title;
    private String description;
    private String department;
    private String position;
    private Integer salaryMin;
    private Integer salaryMax;
    private Integer ageMin;
    private Integer ageMax;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Boolean postStatus;

    private List<Applicant> applicants = new ArrayList<Applicant>();

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
