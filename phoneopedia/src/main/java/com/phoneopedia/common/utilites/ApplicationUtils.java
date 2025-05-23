package com.phoneopedia.common.utilites;

import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.phoneopedia.common.constants.MessageConstants;
import com.phoneopedia.common.exceptions.BaseBusinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationUtils {

  protected static final Map<String, String> changepriceCodeSwedishToEnglish = new HashMap<>();

  public static Date getDate(Date date) {

    if (date == null) {
      date = new Date();
    }
      SimpleDateFormat sdf = new SimpleDateFormat(MessageConstants.DATE_FORMAT);
      try {
          String formattedDate = sdf.format(date);
          return sdf.parse(formattedDate);
      } catch (ParseException e) {
          return new Date();
      }
  }



  public static String getDateAsString(Date date) {
    return new SimpleDateFormat(MessageConstants.DATE_FORMAT).format(getDate(date));
  }

  public static String blobToString(Blob applicationDataBlob) {

    int length;
    byte[] applicationDataByteArray = null;
    try {
      length = (int) applicationDataBlob.length();
      applicationDataByteArray = applicationDataBlob.getBytes(1, length);
    } catch (SQLException e) {
      throw new BaseBusinessException(e.getMessage(), e);
    }
    return new String(applicationDataByteArray, StandardCharsets.UTF_8);
  }

  public static Blob stringToBlob(String request) {
    byte[] byteData = request.getBytes(StandardCharsets.UTF_8);
    Blob applicationDataBlob = null;
    try {
      applicationDataBlob = new SerialBlob(byteData);
      return applicationDataBlob;
    } catch (SerialException e) {
      log.error("Exception occurred : {}", e);
      throw new BaseBusinessException(e.getMessage(), e);
    } catch (SQLException e) {
      log.error("Exception occurred: {}", e);
      throw new BaseBusinessException(e.getMessage(), e);
    }
  }

  public static String getRandomUUID() {
    return UUID.randomUUID().toString();
  }
  
  private ApplicationUtils() {
	  
  }
}
