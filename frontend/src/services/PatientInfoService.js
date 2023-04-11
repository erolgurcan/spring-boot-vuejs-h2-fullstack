import http from '../http-common.jsx';

class PatientInfoService{
    getPatients(){
        return http.get('/patientUsers');
}

    addPatient(treatmentid, data){
        return http.post(`/treatments/${treatmentid}/patientUser`, data);
    }

}

export default new PatientInfoService();