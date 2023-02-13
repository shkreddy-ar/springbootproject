package com.boa.customerapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Corporate")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporate extends Customer{
    @Column(name="Over_Draft_Limit")
	private long overDraftLimit;
}
