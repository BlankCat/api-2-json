package com.example.hp.asapp.model.jyf;

import org.omg.CORBA.SetOverrideType;

public class OrderBean {
	 /**
     * orderId : 47
     * bookingId : 1
     * orderNo : 3221p3E685177019eypadRl630u41VBT
     * cashierId : null
     * userId : 1
     * doctorId : 1
     * subclinicId : 1
     * patientId : 1
     * couponId : null
     * orderTotalCost : 950.76
     * orderPayCost : 950.76
     * couponTotalCost : 0
     * payWay : 0
     * orderState : 3
     * payState : 1
     * orderTime : null
     * createTime : 1520149474000
     * patientName : 柳杉
     */

	public void init(int i) {
		setOrderId(i);
		setBookingId(i);
		setOrderNo(i+"3221p3E685177019eypadRl630u41VBT");
		setCashierId(null);
		setUserId(i);
		setDoctorId(i);
		setSubclinicId(i);
		setPatientId(i);
		setCouponId(null);
		setOrderTotalCost(950.76);
		setOrderPayCost(950.76);
		setCouponTotalCost(0);
		setPayState(1);
		setOrderTime(null);
		setCreateTime(1520149474000l);
		setPatientName("柳杉");
		
	}
    private int orderId;
    private int bookingId;
    private String orderNo;
    private Object cashierId;
    private int userId;
    private int doctorId;
    private int subclinicId;
    private int patientId;
    private Object couponId;
    private double orderTotalCost;
    private double orderPayCost;
    private int couponTotalCost;
    private int payWay;
    private int orderState;
    private int payState;
    private Object orderTime;
    private long createTime;
    private String patientName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Object getCashierId() {
        return cashierId;
    }

    public void setCashierId(Object cashierId) {
        this.cashierId = cashierId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSubclinicId() {
        return subclinicId;
    }

    public void setSubclinicId(int subclinicId) {
        this.subclinicId = subclinicId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Object getCouponId() {
        return couponId;
    }

    public void setCouponId(Object couponId) {
        this.couponId = couponId;
    }

    public double getOrderTotalCost() {
        return orderTotalCost;
    }

    public void setOrderTotalCost(double orderTotalCost) {
        this.orderTotalCost = orderTotalCost;
    }

    public double getOrderPayCost() {
        return orderPayCost;
    }

    public void setOrderPayCost(double orderPayCost) {
        this.orderPayCost = orderPayCost;
    }

    public int getCouponTotalCost() {
        return couponTotalCost;
    }

    public void setCouponTotalCost(int couponTotalCost) {
        this.couponTotalCost = couponTotalCost;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public Object getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Object orderTime) {
        this.orderTime = orderTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

}
