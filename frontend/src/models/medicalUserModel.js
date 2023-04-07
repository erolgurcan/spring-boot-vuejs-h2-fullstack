export default class medicalUserModel {
    email;
    gender;
    id;
    medicalId;
    userFullName;

    constructor(data) {
        console.log(data)
        this.email = data.email;
        this.gender = data.gender;
        this.id = data.id;
        this.medicalId = data.medicalID;
        this.userFullName = data.userFullName;
    }   
}