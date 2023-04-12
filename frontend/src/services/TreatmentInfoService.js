import http from '../http-common.jsx';

class TreatmentInfoService{
    getTreatments(){
        return http.get('/treatments');
}

addTreatment(medicalId, data){
    return http.post(`/medicalUsers/${medicalId}/treatment`, data);
}

}

export default new TreatmentInfoService();