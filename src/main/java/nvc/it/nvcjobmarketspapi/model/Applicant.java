package nvc.it.nvcjobmarketspapi.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class Applicant {
    @Id
    private String _id;
    private String member_id;
    private String memberName;
    private String description;
    private String regisStatus = "NotView";
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regisDate = new Date(System.currentTimeMillis());
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applicantDate = new Date(System.currentTimeMillis());

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
