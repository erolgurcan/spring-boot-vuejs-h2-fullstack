export default class patientUserModel {
  fullName
  patientId
  birthDate
  gender
  email
  phone
  healthCard
  address
  city
  province
  zipCode

    constructor(data) {
        this.fullName = data.fullName;
        this.patientId = data.patientId;
        this.birthDate = data.birthDate;
        this.gender = data.gender;
        this.email = data.email;
        this.phone = data.phone;
        this.healthCard = data.healthCard;
        this.address = data.address;
        this.city = data.city;
        this.province = data.province;
        this.zipCode = data.zipCode;
    }
}
