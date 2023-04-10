export default class medicalUserModel {
    email;
    gender;
    id;
    medicalID;
    userFullName;
    role;

    constructor(data) {
        console.log(data);
        // console.log(data[0].userFullName);
        // console.log(data[0].email);
        // console.log(data[0].gender);
        // console.log(data[0].id);
        // console.log(data[0].medicalID);
        this.email = data[0].email;
        this.gender = data[0].gender;
        this.id = data[0].id;
        this.medicalID = data[0].medicalID;
        this.userFullName = data[0].userFullName;
        this.role = data[0].role;
    }   
}