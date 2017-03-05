package com.pattawan.springboottraining.model;


import com.pattawan.springboottraining.model.utils.UtcCalendarType;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity  //tells Hibernate and Spring that this is our Entity class
@Table(
        name = "comment_model",
        indexes = {
                @Index(
                        name = "idx_pageId",
                        columnList = "pageId"
                )
        }
)
//defines a table name and sets an index on the pageId, we will query later on it

@TypeDefs({
        @TypeDef(name = "calendarUTC",
                typeClass = UtcCalendarType.class,
                defaultForType = Calendar.class)
})

/*
Defines a Hibernate type transformation, so we store and handle our dates in UTC
If we do not set it as fixed here, it will depend on the locales used though your systems
and can end up a mess.
*/
public class CommentModel implements Serializable {

    @Id //unique ID of our CommentModel
    @Column(length = 36)
    private String id;

    //A version ID used by Hibernate for optimistic locking
    @Version
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "calendarUTC")
    private Calendar creationDate;

    @Column(length = 32)
    private String pageId;

    @Column(length = 32)
    private String username;

    @Column(length = 32)
    private String emailAddress;

    @Column
    private boolean spam;
}