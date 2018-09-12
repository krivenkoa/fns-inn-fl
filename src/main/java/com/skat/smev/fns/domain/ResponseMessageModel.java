package com.skat.smev.fns.domain;

import java.util.List;

public class ResponseMessageModel extends BaseMessageModel {

	private String requestId;
	private String innfl;
	private List<String> attachments;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getInnFl() {
		return innfl;
	}

	public void setInnFl(String innfl) { this.innfl = innfl; }

	public List<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "ResponseMessageModel{" +
				"messageId='" + messageId + '\'' +
				", requestId='" + requestId + '\'' +
				", innfl='" + innfl + '\'' +
				'}';
	}
}