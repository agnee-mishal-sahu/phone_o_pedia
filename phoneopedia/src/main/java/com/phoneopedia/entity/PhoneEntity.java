package com.phoneopedia.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Phone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CORRELATION_ID", nullable = false)
	private String correlationId;

	@Column(name = "BRAND", nullable = false)
	private String brand;

	@Column(name = "MODEL", nullable = false)
	private String model;

	@Column(name = "OPERATING_SYSTEM")
	private String operatingSystem;

	@Column(name = "PROCESSOR")
	private String processor;

	@Column(name = "RAM")
	private Integer ram;

	@Column(name = "STORAGE")
	private Integer storage;

	@Column(name = "CONNECTIVITY")
	private String connectivity;

	@Column(name = "BATTERY_CAPACITY")
	private Integer batteryCapacity;

	@Column(name = "DISPLAY_SIZE")
	private BigDecimal displaySize;

	@Column(name = "DISPLAY_TYPE")
	private String displayType;

	@Column(name = "REFRESH_RATE")
	private Integer refreshRate;

	@Column(name = "REAR_CAMERA_RESOLUTION")
	private Integer rearCameraResolution;

	@Column(name = "FRONT_CAMERA_RESOLUTION")
	private Integer frontCameraResolution;

	@Column(name = "NUMBER_OF_CAMERA")
	private Integer numberOfCamera;

	@Column(name = "BLUETOOTH_VERSION")
	private BigDecimal bluetoothVersion;

	@Column(name = "DUAL_SIM")
	private boolean dualSim;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "FACE_UNLOCK")
	private boolean faceUnlock;

	@Column(name = "FINGER_PRINT_SENSOR")
	private boolean fingerPrintSensor;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "RELEASED_DATE")
	private Date releasedDate;

	@Column(name = "SPECIFICATION", nullable = false)
	private Blob specifications;

}
