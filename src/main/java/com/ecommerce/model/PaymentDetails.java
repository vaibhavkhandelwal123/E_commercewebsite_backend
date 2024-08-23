package com.ecommerce.model;

public class PaymentDetails {
	
	private String paymentMethod;
	private String paymentStatus;
	private String paymentId;
	private String razorpayPaymentLinkId;
	private String razorpaymentLinkReferenceId;
	private String razorpayPaymentLinkStatus;
	private String razorPaymentId;
	
	public PaymentDetails() {
		
	}
	
	public PaymentDetails(String paymentMethod, String paymentStatus, String paymentId, String razorpayPaymentLinkId,
			String razorpaymentLinkReferenceId, String razorpayPaymentLinkStatus, String razorPaymentId) {
		super();
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.paymentId = paymentId;
		this.razorpayPaymentLinkId = razorpayPaymentLinkId;
		this.razorpaymentLinkReferenceId = razorpaymentLinkReferenceId;
		this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
		this.razorPaymentId = razorPaymentId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getRazorpayPaymentLinkId() {
		return razorpayPaymentLinkId;
	}
	public void setRazorpayPaymentLinkId(String razorpayPaymentLinkId) {
		this.razorpayPaymentLinkId = razorpayPaymentLinkId;
	}
	public String getRazorpaymentLinkReferenceId() {
		return razorpaymentLinkReferenceId;
	}
	public void setRazorpaymentLinkReferenceId(String razorpaymentLinkReferenceId) {
		this.razorpaymentLinkReferenceId = razorpaymentLinkReferenceId;
	}
	public String getRazorpayPaymentLinkStatus() {
		return razorpayPaymentLinkStatus;
	}
	public void setRazorpayPaymentLinkStatus(String razorpayPaymentLinkStatus) {
		this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
	}
	public String getRazorPaymentId() {
		return razorPaymentId;
	}
	public void setRazorPaymentId(String razorPaymentId) {
		this.razorPaymentId = razorPaymentId;
	}
	
	
}
