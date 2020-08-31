package com.fluxxed.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

  @Id
  private Long id;

  @Column("event_name")
  private String eventName;

  @Column("event_date")
  private String eventDate;
}
