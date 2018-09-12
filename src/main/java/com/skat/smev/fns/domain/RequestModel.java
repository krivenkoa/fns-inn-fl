package com.skat.smev.fns.domain;

import java.util.List;

/**
 * 
 * Модель json-запроса
 *
 */
public class RequestModel {

	private String requestId;
	private String fnsRequestId;
	private String orgnUl;
	private String innUl;
	private String orgName;
	private String dateBirthFl;
	private String placeBirth;
	private String surnameFl;
	private String nameFl;
	private String patronymicFl;
	private String kodVidDoc;
	private String kodVydDoc;
	private String vydDoc;
	private String dateDoc;
	private String docSeriaNum;


	private List<AttachmentModel> attachments;

	public String getRequestId() {
		return requestId;
	}

	public String getFnsRequestId() {
		return fnsRequestId;
	}

	public String getOrgnUl() { return orgnUl; }
	public String getInnUl() { return innUl; }
	public String getOrgName() { return orgName; }
	public String getDateBirthFl() { return dateBirthFl; }
	public String getPlaceBirth() { return placeBirth; }
	public String getSurnameFl() { return surnameFl; }
	public String getNameFl() { return nameFl; }
	public String getPatronymicFl() { return patronymicFl; }
	public String getKodVidDoc() { return kodVidDoc; }
	public String getKodVydDoc() { return kodVydDoc; }
	public String getVydDoc() { return vydDoc; }
	public String getDateDoc() { return dateDoc; }
	public String getDocSeriaNum() { return docSeriaNum; }


	public List<AttachmentModel> getAttachments() {
		return attachments;
	}
}