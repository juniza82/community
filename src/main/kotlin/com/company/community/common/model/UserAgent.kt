package com.company.community.common.model

class UserAgent(
    var userId: String,
    val id: String,
    val name: String = "",
    val address: String = "",
    val businessNumber: String = "",
    val telNumber: String = "",
    val faxNumber: String = "",
    val email: String = "",
    val logoUrl: String = "",
    val mobileNumber: String = "",
    val jwtToken: String = "",
    val eodingDiscountPercentage: Double = 0.0,
    val companyProfitPercentage: Double = 0.0,
    val companyCardPercentage: Double = 0.0,
) {
    override fun toString(): String {
        return "travel_agent_id : ${this.id}, " +
                "user_id : ${this.userId}, " +
                "name : ${this.name}, " +
                "address : ${this.address}, " +
                "businessNumber : ${this.businessNumber}, " +
                "telNumber : ${this.telNumber}, " +
                "faxNumber : ${this.faxNumber}, " +
                "email : ${this.email}, " +
                "mobileNumber : ${this.mobileNumber}, " +
                "jwtToken : ${this.jwtToken}, " +
                "eodingDiscountPercentage : ${this.eodingDiscountPercentage}, " +
                "companyProfitPercentage : ${this.companyProfitPercentage}, " +
                "companyCardPercentage : ${this.companyCardPercentage}"
    }
}